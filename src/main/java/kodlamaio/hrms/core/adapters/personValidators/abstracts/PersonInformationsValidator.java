package kodlamaio.hrms.core.adapters.personValidators.abstracts;

public interface PersonInformationsValidator {
	boolean isPersonInforamtionsValid(String identityNumber,String firstName,String lastName,int birthYear);
}
