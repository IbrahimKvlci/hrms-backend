package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterCandidateDao;
import kodlamaio.hrms.entities.concretes.cadidateCVs.CoverLetterCandidate;

@Service
public class CoverLetterCandidateManager implements CoverLetterCandidateService {

	private CoverLetterCandidateDao coverLetterCandidateDao;
	
	@Autowired
	public CoverLetterCandidateManager(CoverLetterCandidateDao coverLetterCandidateDao) {
		super();
		this.coverLetterCandidateDao = coverLetterCandidateDao;
	}

	@Override
	public Result add(CoverLetterCandidate coverLetterCandidate) {
		this.coverLetterCandidateDao.save(coverLetterCandidate);
		return new SuccessResult("Added!");
	}

}
