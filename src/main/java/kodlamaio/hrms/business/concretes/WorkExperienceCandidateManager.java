package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.WorkExperienceCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkExperienceCandidateDao;
import kodlamaio.hrms.entities.concretes.cadidateCVs.WorkExperienceCandidate;

@Service
public class WorkExperienceCandidateManager implements WorkExperienceCandidateService{

	private WorkExperienceCandidateDao workExperienceCandidateDao;
	
	@Autowired
	public WorkExperienceCandidateManager(WorkExperienceCandidateDao workExperienceCandidateDao) {
		super();
		this.workExperienceCandidateDao = workExperienceCandidateDao;
	}

	@Override
	public Result add(WorkExperienceCandidate workExperienceCandidate) {
		this.workExperienceCandidateDao.save(workExperienceCandidate);
		return new SuccessResult("Added!");
	}

}
