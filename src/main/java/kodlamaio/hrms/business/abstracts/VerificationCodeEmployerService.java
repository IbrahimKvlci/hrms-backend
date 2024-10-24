package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.VerificationCodeEmployer;

public interface VerificationCodeEmployerService {
	Result add(VerificationCodeEmployer verificationCodeEmployer);
	Result validateEmployer(int employerId,String code);
}
