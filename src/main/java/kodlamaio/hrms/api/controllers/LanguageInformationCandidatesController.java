package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlamaio.hrms.business.abstracts.LanguageInformationCandidateService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
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
	public Result add(@Valid @RequestBody LanguageInformationCandidate languageInformationCandidate) {
		return this.languageInformationCandidateService.add(languageInformationCandidate);
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
