package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.VerificationCodeCandidateService;
import kodlamaio.hrms.core.adapters.personValidators.abstracts.PersonInformationsValidator;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import kodlamaio.hrms.entities.concretes.verifications.VerificationCodeCandidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private VerificationCodeCandidateService verificationCodeCandidateService;
	private PersonInformationsValidator personInformationsValidator;

	@Autowired
	public CandidateManager(CandidateDao candidateDao,PersonInformationsValidator personInformationsValidator,VerificationCodeCandidateService verificationCodeCandidateService) {
		super();
		this.candidateDao = candidateDao;
		this.personInformationsValidator=personInformationsValidator;
		this.verificationCodeCandidateService=verificationCodeCandidateService;
	}

	@Override
	public Result add(Candidate candidate) {
		if(areCandidateFieldsEmpty(candidate)) {
			return new ErrorResult("Required fields cannot be empty!");	
			}
		for (Candidate candidateFromList : candidateDao.findAll()) {
			if(candidateFromList.getEmail().equals(candidate.getEmail()))
				return new ErrorResult("This email is already using!");
			if(candidateFromList.getIdentityNumber().equals(candidate.getIdentityNumber()))
				return new ErrorResult("User with this identity number is already exists!");
		}
		if(!this.personInformationsValidator.isPersonInforamtionsValid(candidate.getIdentityNumber(), candidate.getFirstName(), candidate.getLastName(),candidate.getBirthYear())) {
			return new ErrorResult("User's informations are not valid!");
		}
		
		Candidate savedCandidate= candidateDao.save(candidate);
		
		VerificationCodeCandidate verificationCodeCandidate=new VerificationCodeCandidate(0, "123", false, null, savedCandidate.getId());
		this.verificationCodeCandidateService.add(verificationCodeCandidate);
		
		return new SuccessResult();
	}
	
	private boolean areCandidateFieldsEmpty(Candidate candidate) {
		if(candidate.getEmail().isEmpty()||candidate.getPassword().isEmpty()||candidate.getFirstName().isEmpty()||
				candidate.getLastName().isEmpty()||candidate.getIdentityNumber().isEmpty()||candidate.getBirthYear()==0)
			return true;
		return false;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}
	
	
	
}
