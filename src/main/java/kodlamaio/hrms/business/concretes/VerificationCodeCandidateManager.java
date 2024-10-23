package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationCodeCandidateService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeCandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.VerificationCodeCandidate;

@Service
public class VerificationCodeCandidateManager implements VerificationCodeCandidateService{

	private VerificationCodeCandidateDao verificationCodeCandidateDao;
	
	@Autowired
	public VerificationCodeCandidateManager(VerificationCodeCandidateDao verificationCodeCandidateDao) {
		super();
		this.verificationCodeCandidateDao = verificationCodeCandidateDao;
	}



	@Override
	public Result add(VerificationCodeCandidate verificationCodeCandidate) {
		this.verificationCodeCandidateDao.save(verificationCodeCandidate);
		return new SuccessResult();
	}



	@Override
	public Result validateCandidate(int candidateId, String code) {
		if(verificationCodeCandidateDao.findByCandidateId(candidateId).get(0).getCode().equals(code)) {
			return new SuccessResult("Verified!");
		}
		return new ErrorResult("Wrong Code!");
	}

}
