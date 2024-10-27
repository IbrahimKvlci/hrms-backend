package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageInformationCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageInformationCandidateDao;
import kodlamaio.hrms.entities.concretes.cadidateCVs.LanguageInformationCandidate;

@Service
public class LanguageInformationCandidateManager implements LanguageInformationCandidateService {

	private LanguageInformationCandidateDao languageInformationCandidateDao;
	
	@Autowired
	public LanguageInformationCandidateManager(LanguageInformationCandidateDao languageInformationCandidateDao) {
		super();
		this.languageInformationCandidateDao = languageInformationCandidateDao;
	}

	@Override
	public Result add(LanguageInformationCandidate languageInformationCandidate) {
		this.languageInformationCandidateDao.save(languageInformationCandidate);
		return new SuccessResult("Added!");
	}

}
