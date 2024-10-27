package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.verifications.EmployeeConfirmEmployer;

public interface EmployeeConfirmEmployerService {
	Result add(EmployeeConfirmEmployer employeeConfirmEmployer);
	Result confirm(int employeeId,int employerId);
}
