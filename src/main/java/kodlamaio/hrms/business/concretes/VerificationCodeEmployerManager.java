package kodlamaio.hrms.business.concretes;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationCodeEmployerService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeEmployerDao;
import kodlamaio.hrms.entities.concretes.VerificationCodeEmployer;

@Service
public class VerificationCodeEmployerManager implements VerificationCodeEmployerService{

	private VerificationCodeEmployerDao verificationCodeEmployerDao;
	
	@Autowired
	public VerificationCodeEmployerManager(VerificationCodeEmployerDao verificationCodeEmployerDao) {
		super();
		this.verificationCodeEmployerDao = verificationCodeEmployerDao;
	}

	@Override
	public Result add(VerificationCodeEmployer verificationCodeEmployer) {
		verificationCodeEmployerDao.save(verificationCodeEmployer);
		return new SuccessResult();	
	}

	@Override
	public Result validateEmployer(int employerId, String code) {
		VerificationCodeEmployer verificationCodeEmployer=this.verificationCodeEmployerDao.findByEmployerId(employerId);
		
		if(verificationCodeEmployer.isVerified()) {
			return new ErrorResult("User was already verified!");
		}
		if(!verificationCodeEmployer.getCode().equals(code)) {
			return new ErrorResult("Wrong Code!");
		}
		verificationCodeEmployer.setVerified(true);
		verificationCodeEmployer.setVerifiedDate(new Date());
		
		verificationCodeEmployerDao.save(verificationCodeEmployer);
		return new SuccessResult("Verified!");
	}

}
