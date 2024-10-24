package kodlamaio.hrms.business.concretes;

import java.util.Date;

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
		VerificationCodeCandidate verificationCodeCandidate=verificationCodeCandidateDao.findByCandidateId(candidateId);
		if(verificationCodeCandidate.isVerified()) {
			return new ErrorResult("User was already verified!");
		}
		
		if(verificationCodeCandidate.getCode().equals(code)) {
			verificationCodeCandidate.setVerified(true);
			verificationCodeCandidate.setVerifiedDate(new Date());
			
			verificationCodeCandidateDao.save(verificationCodeCandidate);
			return new SuccessResult("Verified!");
		}
		return new ErrorResult("Wrong Code!");
	}

}
