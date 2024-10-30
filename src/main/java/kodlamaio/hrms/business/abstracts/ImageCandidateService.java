package kodlamaio.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cadidateCVs.ImageCandidate;

public interface ImageCandidateService {

	Result add(ImageCandidate imageCandidate);
	Result upload(MultipartFile file,int candidateId);
}
