package kodlamaio.hrms.api.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.CandidateCVDto;
import kodlamaio.hrms.entities.concretes.users.Candidate;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidateController {

	private CandidateService candidateService;
	
	@Autowired
	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@GetMapping("/getAllCandidateCV")
	public DataResult<List<CandidateCVDto>> getAllCandidateCV(){
		return this.candidateService.getAllCandidateCV();
	}
	
	@GetMapping("/getCandidateCVById")
	public DataResult<CandidateCVDto> getCandidateCVById(@RequestParam int candidateId){
		return this.candidateService.getCandidateCVById(candidateId);
	}
	
}
