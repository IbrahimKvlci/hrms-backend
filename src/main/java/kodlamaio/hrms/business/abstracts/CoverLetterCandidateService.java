package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cadidateCVs.CoverLetterCandidate;

public interface CoverLetterCandidateService {
	
	Result add(CoverLetterCandidate coverLetterCandidate);
}
