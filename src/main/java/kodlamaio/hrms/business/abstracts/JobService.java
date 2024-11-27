package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;

public interface JobService {
	Result add(Job job);
	DataResult<List<Job>> getAllActives();
	DataResult<List<Job>> getAllActivesSortedByPostingDate();
	DataResult<List<Job>> getActivesByCompanyName(String companyName);
	DataResult<Job> getJobById(int id); 
}
