package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TalentCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cadidateCVs.TalentCandidate;

@RestController
@RequestMapping("/api/talentcandidates")
public class TalentCandidatesController {

	private TalentCandidateService talentCandidateService;
	
	@Autowired
	public TalentCandidatesController(TalentCandidateService talentCandidateService) {
		super();
		this.talentCandidateService = talentCandidateService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody TalentCandidate talentCandidate) {
		return this.talentCandidateService.add(talentCandidate);
	}
}
