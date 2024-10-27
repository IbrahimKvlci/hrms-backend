package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationInformationCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationInformationCandidateDao;
import kodlamaio.hrms.entities.concretes.cadidateCVs.EducationInformationCandidate;

@Service
public class EducationInformationCandidateManager implements EducationInformationCandidateService {

	private EducationInformationCandidateDao educationInformationCandidateDao;
	
	@Autowired
	public EducationInformationCandidateManager(EducationInformationCandidateDao educationInformationCandidateDao) {
		super();
		this.educationInformationCandidateDao = educationInformationCandidateDao;
	}

	@Override
	public Result add(EducationInformationCandidate educationInformationCandidate) {
		this.educationInformationCandidateDao.save(educationInformationCandidate);
		return new SuccessResult("Added!");
	}

}
