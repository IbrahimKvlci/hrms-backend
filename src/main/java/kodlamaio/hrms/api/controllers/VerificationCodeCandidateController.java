package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.VerificationCodeCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/verificationcodecandidates")
public class VerificationCodeCandidateController {
	
	private VerificationCodeCandidateService verificationCodeCandidateService;
	
	@Autowired
	public VerificationCodeCandidateController(VerificationCodeCandidateService verificationCodeCandidateService) {
		super();
		this.verificationCodeCandidateService = verificationCodeCandidateService;
	}



	@PostMapping("/validatecandidate")
	public Result validate(int candidateId,String code) {
		return this.verificationCodeCandidateService.validateCandidate(candidateId,code);
	}
}
