package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CoverLetterCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cadidateCVs.CoverLetterCandidate;

@RestController
@RequestMapping("/api/CoverLetterCandidates")
public class CoverLetterCandidatesController {

	private CoverLetterCandidateService coverLetterCandidateService;
	
	@Autowired
	public CoverLetterCandidatesController(CoverLetterCandidateService coverLetterCandidateService) {
		super();
		this.coverLetterCandidateService = coverLetterCandidateService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CoverLetterCandidate coverLetterCandidate) {
		return this.coverLetterCandidateService.add(coverLetterCandidate);
	}
}
