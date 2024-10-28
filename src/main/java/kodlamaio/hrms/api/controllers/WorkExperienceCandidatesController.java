package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkExperienceCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cadidateCVs.WorkExperienceCandidate;

@RestController
@RequestMapping("/api/workexperiencecandidates")
public class WorkExperienceCandidatesController {

	private WorkExperienceCandidateService workExperienceCandidateService;
	
	@Autowired
	public WorkExperienceCandidatesController(WorkExperienceCandidateService workExperienceCandidateService) {
		super();
		this.workExperienceCandidateService = workExperienceCandidateService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody WorkExperienceCandidate workExperienceCandidate) {
		return this.workExperienceCandidateService.add(workExperienceCandidate);
	}
}
