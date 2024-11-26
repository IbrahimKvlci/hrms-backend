package kodlamaio.hrms.business.concretes;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmJobService;
import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeConfirmJobDao;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.concretes.users.Employee;
import kodlamaio.hrms.entities.concretes.verifications.EmployeeConfirmJob;

public class EmployeeConfirmJobManager implements EmployeeConfirmJobService {

	private EmployeeConfirmJobDao employeeConfirmJobDao;
	private JobService jobService;
	
	@Autowired
	public EmployeeConfirmJobManager(EmployeeConfirmJobDao employeeConfirmJobDao,JobService jobService) {
		super();
		this.employeeConfirmJobDao = employeeConfirmJobDao;
		this.jobService=jobService;
	}



	@Override
	public Result confirm(int employeeId, int jobId) {
		EmployeeConfirmJob employeeConfirmJob=this.employeeConfirmJobDao.findByJobId(jobId);
		if(employeeConfirmJob.isConfirmed()) {
			return new ErrorResult("Job is already confirmed!");
		}
		
		employeeConfirmJob.setConfirmed(true);
		employeeConfirmJob.setConfirmDate(new Date());
		employeeConfirmJob.setEmployeeId(employeeId);
		
		this.employeeConfirmJobDao.save(employeeConfirmJob);
		
		return new SuccessResult("Confirmed");
	}

}
