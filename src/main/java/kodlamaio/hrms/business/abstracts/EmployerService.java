package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.concretes.users.Employer;

public interface EmployerService {

	Result add(Employer employer);
	DataResult<Employer> getById(int id);
	DataResult<List<Employer>> getAll(); 
	Result changeJobActive(int employerId,int jobId,boolean active);
}
