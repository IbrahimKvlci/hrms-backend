package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageInformationCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cadidateCVs.LanguageInformationCandidate;

@RestController
@RequestMapping("/api/languageinformationcandidates")
public class LanguageInformationCandidatesController {

	private LanguageInformationCandidateService languageInformationCandidateService;
	
	@Autowired
	public LanguageInformationCandidatesController(
			LanguageInformationCandidateService languageInformationCandidateService) {
		super();
		this.languageInformationCandidateService = languageInformationCandidateService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody LanguageInformationCandidate languageInformationCandidate) {
		return this.languageInformationCandidateService.add(languageInformationCandidate);
	}
}
