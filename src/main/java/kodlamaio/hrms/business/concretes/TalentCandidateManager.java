package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.TalentCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.TalentCandidateDao;
import kodlamaio.hrms.entities.concretes.cadidateCVs.TalentCandidate;

@Service
public class TalentCandidateManager implements TalentCandidateService {

	private TalentCandidateDao talentCandidateDao;
	
	@Autowired
	public TalentCandidateManager(TalentCandidateDao talentCandidateDao) {
		super();
		this.talentCandidateDao = talentCandidateDao;
	}

	@Override
	public Result add(TalentCandidate talentCandidate) {
		this.talentCandidateDao.save(talentCandidate);
		return new SuccessResult("Added!");
	}

}
