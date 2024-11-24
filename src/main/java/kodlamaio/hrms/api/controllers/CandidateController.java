package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.CandidateCVDto;
import kodlamaio.hrms.entities.concretes.users.Candidate;

@RestController
@RequestMapping("/api/candidates")
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
	
	@GetMapping("/getCandidateCVById")
	public DataResult<CandidateCVDto> getCandidateCVById(@RequestParam int candidateId){
		return this.candidateService.getCandidateCVById(candidateId);
	}
	
	@GetMapping("/getAllCandidateCV")
	public DataResult<List<CandidateCVDto>> getAllCandidateCV(){
		return this.candidateService.getAllCandidateCV();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors = new HashMap<String,String>();

        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>("Doğrulama Hataları!",validationErrors);

        return errors;
    }
}
