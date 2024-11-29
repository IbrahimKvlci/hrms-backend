package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobDao;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.concretes.dtos.JobAddDto;
import kodlamaio.hrms.entities.concretes.dtos.mappers.JobMapper;
import kodlamaio.hrms.entities.concretes.users.Employer;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;
	private EmployerService employerService;
	private JobMapper jobMapper;
	
	@Autowired
	public JobManager(JobDao jobDao,EmployerService employerService,JobMapper jobMapper) {
		super();
		this.jobDao = jobDao;
		this.employerService=employerService;
		this.jobMapper=jobMapper;
	}

	@Override
	public Result add(JobAddDto jobAddDto) {
		Employer employer=employerService.getById(jobAddDto.getEmployerId()).getData();
		
		Job job=this.jobMapper.toJob(jobAddDto);
		job.setEmployer(employer);
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
