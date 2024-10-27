package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ImageCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageCandidateDao;
import kodlamaio.hrms.entities.concretes.cadidateCVs.ImageCandidate;

@Service
public class ImageCandidateManager implements ImageCandidateService {

	private ImageCandidateDao imageCandidateDao;
	
	@Autowired
	public ImageCandidateManager(ImageCandidateDao imageCandidateDao) {
		super();
		this.imageCandidateDao = imageCandidateDao;
	}

	@Override
	public Result add(ImageCandidate imageCandidate) {
		this.imageCandidateDao.save(imageCandidate);
		return new SuccessResult("Added!");
	}

}
