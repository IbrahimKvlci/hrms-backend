package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public Result add(Job job) {
		this.jobDao.save(job);
		return new SuccessResult("Job was added!");
	}

	@Override
	public DataResult<List<Job>> getAllActives() {
		return new SuccessDataResult<List<Job>>("Data was listed!",this.jobDao.getByIsActive(true));
	}

	@Override
	public DataResult<List<Job>> getAllActivesSortedByPostingDate() {
		Sort sort=Sort.by(Sort.Direction.ASC,"postingDate");
		return new SuccessDataResult<List<Job>>("Data was listed as sorted!", this.jobDao.getByIsActive(true,sort));
	}

	@Override
	public DataResult<List<Job>> getActivesByCompanyName(String companyName) {
		return new SuccessDataResult<List<Job>>(this.jobDao.getByIsActiveAndEmployer_CompanyName(true,companyName));
	}

	@Override
	public DataResult<Job> getJobById(int id) {
		return new SuccessDataResult<Job>(this.jobDao.findById(id).get());
	}
	
}
