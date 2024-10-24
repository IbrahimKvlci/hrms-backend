package kodlamaio.hrms.business.concretes;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmEmployerService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeConfirmEmployerDao;
import kodlamaio.hrms.entities.concretes.EmployeeConfirmEmployer;

@Service
public class EmployeeConfirmEmployerManager implements EmployeeConfirmEmployerService{

	private EmployeeConfirmEmployerDao employeeConfirmEmployerDao;
	
	@Autowired
	public EmployeeConfirmEmployerManager(EmployeeConfirmEmployerDao employeeConfirmEmployerDao) {
		super();
		this.employeeConfirmEmployerDao = employeeConfirmEmployerDao;
	}

	@Override
	public Result confirm(int employeeId, int employerId) {
		EmployeeConfirmEmployer employeeConfirmEmployer =this.employeeConfirmEmployerDao.findByEmployerId(employerId);
		
		if(employeeConfirmEmployer.isConfirmed()) {
			return new ErrorResult("User is already confirmed!");
		}
		employeeConfirmEmployer.setConfirmed(true);
		employeeConfirmEmployer.setConfirmDate(new Date());
		employeeConfirmEmployer.setEmployeeId(employeeId);
		employeeConfirmEmployer.setEmployerId(employerId);
		
		this.employeeConfirmEmployerDao.save(employeeConfirmEmployer);
		return new SuccessResult("Confirmed!");
	}

	@Override
	public Result add(EmployeeConfirmEmployer employeeConfirmEmployer) {
		this.employeeConfirmEmployerDao.save(employeeConfirmEmployer);
		return new SuccessResult();
	}

}
