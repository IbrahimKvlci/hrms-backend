package kodlamaio.hrms.business.concretes;

import java.net.URI;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmEmployerService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationCodeEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.EmployeeConfirmEmployer;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.concretes.VerificationCodeEmployer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private JobDao jobDao;
	private VerificationCodeEmployerService verificationCodeEmployerService;
	private EmployeeConfirmEmployerService employeeConfirmEmployerService;

	@Autowired
	public EmployerManager(EmployerDao employerDao,VerificationCodeEmployerService verificationCodeEmployerService,EmployeeConfirmEmployerService employeeConfirmEmployerService,JobDao jobDao) {
		super();
		this.employerDao = employerDao;
		this.jobDao=jobDao;
		this.verificationCodeEmployerService=verificationCodeEmployerService;
		this.employeeConfirmEmployerService=employeeConfirmEmployerService;
	}

	@Override
	public Result add(Employer employer) {
		if(areEmployerRequiredFieldsEmpty(employer)) {
			return new ErrorResult("Required fields cannot be empty!");
		}
		if(!splitEmailDomain(employer.getEmail()).equals(splitWebsiteDomain(employer.getWebAddress()))) {
			return new ErrorResult("Email and website domains are not same! "+splitEmailDomain(employer.getEmail())+" "+splitWebsiteDomain(employer.getWebAddress()));
		}
		for(Employer employerFromList : employerDao.findAll()) {
			if(employerFromList.getEmail().equals(employer.getEmail())) {
				return new ErrorResult("This email is already using!");
			}
		}
		
		Employer savedEmployer= this.employerDao.save(employer);
		
		VerificationCodeEmployer verificationCodeEmployer=new VerificationCodeEmployer(0,"1234567",false,null,savedEmployer.getId());
		verificationCodeEmployerService.add(verificationCodeEmployer);
		
		EmployeeConfirmEmployer employeeConfirmEmployer=new EmployeeConfirmEmployer(0,1,false,null,savedEmployer.getId());
		this.employeeConfirmEmployerService.add(employeeConfirmEmployer);

		return new SuccessResult("Employer added!");
	}
	
	private boolean areEmployerRequiredFieldsEmpty(Employer employer) {
		if(employer.getEmail().isEmpty()||employer.getPassword().isEmpty()||employer.getCompanyName().isEmpty()||
				employer.getWebAddress().isEmpty()||employer.getPhoneNumber().isEmpty()) {
			return true;
		}

		return false;
	}
	
	private String splitWebsiteDomain(String website) {
		return website.replaceAll("http(s)?://|www\\.|/.*", "");
	}
	private String splitEmailDomain(String email) {
		return StringUtils.substringAfter(email, "@");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result changeJobActive(int employerId, int jobId,boolean active) {
		Job job=this.jobDao.getById(jobId);
		if(job.getEmployer().getId()!=employerId)
			return new ErrorResult("The employer cannot change this Job Active. The employer can only change their own jobs!");
		
		job.setActive(active);
		this.jobDao.save(job);
		
		return new SuccessResult("Job Active was changed!");
	}

}
