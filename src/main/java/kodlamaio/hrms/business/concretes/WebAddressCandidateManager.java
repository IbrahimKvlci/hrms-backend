package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WebAddressCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WebAddressCandidateDao;
import kodlamaio.hrms.entities.concretes.cadidateCVs.WebAddressCandidate;

@Service
public class WebAddressCandidateManager implements WebAddressCandidateService{

	private WebAddressCandidateDao webAddressCandidateDao;
	
	@Autowired
	public WebAddressCandidateManager(WebAddressCandidateDao webAddressCandidateDao) {
		super();
		this.webAddressCandidateDao = webAddressCandidateDao;
	}

	@Override
	public Result add(WebAddressCandidate webAddressCandidate) {
		this.webAddressCandidateDao.save(webAddressCandidate);
		return new SuccessResult("Added!");
	}

}
