package kodlamaio.hrms.core.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ValidationException;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;

@RestControllerAdvice
public class GlobalExceptionHandler {

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
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(HttpMessageNotReadableException exception){
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(exception.getMessage());
        return errors;
    }
	
	@ExceptionHandler(ValidationException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(ValidationException exception){
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(exception.getMessage());
        return errors;
    }
	
	@ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(IllegalArgumentException exception){
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(exception.getMessage());
        return errors;
    }

	@ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(NoSuchElementException exception){
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(exception.getMessage());
        return errors;
    }
}
