package kodlamaio.hrms.business.concretes;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageCandidateService;
import kodlamaio.hrms.core.adapters.imageCloudServices.abstracts.ImageCloudService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageCandidateDao;
import kodlamaio.hrms.entities.concretes.cadidateCVs.ImageCandidate;
import kodlamaio.hrms.entities.concretes.users.Candidate;

@Service
public class ImageCandidateManager implements ImageCandidateService {

	private ImageCandidateDao imageCandidateDao;
	private ImageCloudService imageCloudService;
	
	@Autowired
	public ImageCandidateManager(ImageCandidateDao imageCandidateDao,ImageCloudService imageCloudService) {
		super();
		this.imageCandidateDao = imageCandidateDao;
		this.imageCloudService=imageCloudService;
	}

	@Override
	public Result add(ImageCandidate imageCandidate) {
		this.imageCandidateDao.save(imageCandidate);
		return new SuccessResult("Added!");
	}

	@Override
	public Result upload(MultipartFile file,int candidateId) {
		String imageName= this.imageCloudService.upload(file);
		add(new ImageCandidate(0, imageName, new Date(), new Candidate(candidateId)));
		return new SuccessResult("Uploaded");
	}

}
