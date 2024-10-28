package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationInformationCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cadidateCVs.EducationInformationCandidate;

@RestController
@RequestMapping("/api/EducationInformationCandidates")
public class EducationInformationCandidatesController {

	private EducationInformationCandidateService educationInformationCandidateService;
	
	@Autowired
	public EducationInformationCandidatesController(EducationInformationCandidateService educationInformationCandidateService) {
		super();
		this.educationInformationCandidateService = educationInformationCandidateService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody EducationInformationCandidate educationInformationCandidate) {
		return this.educationInformationCandidateService.add(educationInformationCandidate);
	}
	
	@GetMapping("/getAllSorted")
	public DataResult<List<EducationInformationCandidate>> getAllSorted(){
		return this.educationInformationCandidateService.getAllSorted();	
	}
}
