package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;

	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
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
		
		candidateDao.save(candidate);
		return new SuccessResult();
	}
	
	private boolean areCandidateFieldsEmpty(Candidate candidate) {
		if(candidate.getEmail().isEmpty()||candidate.getPassword().isEmpty()||candidate.getFirstName().isEmpty()||
				candidate.getLastName().isEmpty()||candidate.getIdentityNumber().isEmpty()||candidate.getBirthYear()==0)
			return true;
		return false;
	}
	
	
	
}
