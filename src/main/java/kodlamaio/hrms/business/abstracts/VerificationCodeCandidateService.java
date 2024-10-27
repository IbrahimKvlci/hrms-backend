package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import kodlamaio.hrms.entities.concretes.verifications.VerificationCodeCandidate;

public interface VerificationCodeCandidateService {
	Result add(VerificationCodeCandidate verificationCodeCandidate);
	Result validateCandidate(int candidateId,String code);
}
