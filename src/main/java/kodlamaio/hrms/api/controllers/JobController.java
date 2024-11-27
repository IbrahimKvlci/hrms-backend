package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.concretes.users.Employer;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin
public class JobController {
	
	private JobService jobService;
	
	@Autowired
	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Job job) {
		return this.jobService.add(job);
	}
	
	@GetMapping("/getAllActives")
	public DataResult<List<Job>> getAllActives(){
		return this.jobService.getAllActives();
	}
	
	@GetMapping("/getAllActivesSortedByPostingDate")
	DataResult<List<Job>> getAllActivesSortedByPostingDate(){
		return this.jobService.getAllActivesSortedByPostingDate();
	}
	
	@GetMapping("/getActivesByCompanyName")
	public DataResult<List<Job>> getActivesByCompanyName(String companyName){
		return this.jobService.getActivesByCompanyName(companyName);
	}
	
	@GetMapping("/getJobById")
	public DataResult<Job> getJobById(int id){
		return this.jobService.getJobById(id);
	}
	
	
}
