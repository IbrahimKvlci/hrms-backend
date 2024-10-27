package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cadidateCVs.WorkExperienceCandidate;

public interface WorkExperienceCandidateService {

	Result add(WorkExperienceCandidate workExperienceCandidate);
}
