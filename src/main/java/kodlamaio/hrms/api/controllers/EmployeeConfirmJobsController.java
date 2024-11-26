package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmJobService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/employeeconfirmjobs")
public class EmployeeConfirmJobsController {

	private EmployeeConfirmJobService employeeConfirmJobService;

	@Autowired
	public EmployeeConfirmJobsController(EmployeeConfirmJobService employeeConfirmJobService) {
		super();
		this.employeeConfirmJobService = employeeConfirmJobService;
	}
	
	@PostMapping("/confirmJob")
	public Result confirmJob(int employeeId,int jobId) {
		return this.employeeConfirmJobService.confirm(employeeId, jobId);
	}
}
