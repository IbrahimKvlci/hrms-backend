package kodlamaio.hrms.business.concretes;

import java.net.URI;
import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationCodeEmployerService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.VerificationCodeEmployer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private VerificationCodeEmployerService verificationCodeEmployerService;

	@Autowired
	public EmployerManager(EmployerDao employerDao,VerificationCodeEmployerService verificationCodeEmployerService) {
		super();
		this.employerDao = employerDao;
		this.verificationCodeEmployerService=verificationCodeEmployerService;
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
		
		VerificationCodeEmployer verificationCodeEmployer=new VerificationCodeEmployer(0,"12345",false,null,savedEmployer.getId());
		System.out.println(savedEmployer.getId());
		verificationCodeEmployerService.add(verificationCodeEmployer);

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

}
