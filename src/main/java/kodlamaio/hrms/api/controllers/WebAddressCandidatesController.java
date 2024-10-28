package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WebAddressCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cadidateCVs.WebAddressCandidate;

@RestController
@RequestMapping("/api/webaddresscandidates")
public class WebAddressCandidatesController {

	private WebAddressCandidateService webAddressCandidateService;
	
	@Autowired
	public WebAddressCandidatesController(WebAddressCandidateService webAddressCandidateService) {
		super();
		this.webAddressCandidateService = webAddressCandidateService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody WebAddressCandidate webAddressCandidate) {
		return this.webAddressCandidateService.add(webAddressCandidate);
	}
}
