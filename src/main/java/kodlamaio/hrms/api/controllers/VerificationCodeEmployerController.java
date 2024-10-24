package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.VerificationCodeEmployerService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/verificationcodeemployers")
public class VerificationCodeEmployerController {
	
	private VerificationCodeEmployerService verificationCodeEmployerService;

	@Autowired
	public VerificationCodeEmployerController(VerificationCodeEmployerService verificationCodeEmployerService) {
		super();
		this.verificationCodeEmployerService = verificationCodeEmployerService;
	}

	@PostMapping("/validateemployer")
	public Result validateEmployer(int employerId,String code) {
		return this.verificationCodeEmployerService.validateEmployer(employerId, code);
	}
}
