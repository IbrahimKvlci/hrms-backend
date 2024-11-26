package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.concretes.users.Employee;

public interface EmployeeConfirmJobService {

	Result confirm(int employeeId,int jobId);
}
