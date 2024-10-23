package kodlamaio.hrms.core.adapters.personValidators.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.personValidators.abstracts.PersonInformationsValidator;

@Service
public class MernisPersonInfarmationsValidationAdapter implements PersonInformationsValidator{

	
	//Simulation (There will be Mernis validation system)
	@Override
	public boolean isPersonInforamtionsValid(String identityNumber, String firstName, String lastName, int birthYear) {
		if(identityNumber.length()!=11)
			return false;
		return true;
	}

}
