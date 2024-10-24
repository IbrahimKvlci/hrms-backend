package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmEmployerService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/employeeconfirmemployers")
public class EmployeeConfirmEmployerController {

	private EmployeeConfirmEmployerService employeeConfirmEmployerService;
	
	@Autowired
	public EmployeeConfirmEmployerController(EmployeeConfirmEmployerService employeeConfirmEmployerService) {
		super();
		this.employeeConfirmEmployerService = employeeConfirmEmployerService;
	}

	@PostMapping("/confirm")
	public Result confirm(int employeeId,int employerId) {
		return this.employeeConfirmEmployerService.confirm(employeeId, employerId);
	}
	
}
