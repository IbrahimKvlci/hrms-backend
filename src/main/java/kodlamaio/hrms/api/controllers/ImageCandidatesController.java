package kodlamaio.hrms.api.controllers;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageCandidateService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.cadidateCVs.ImageCandidate;

@RestController
@RequestMapping("/api/ImageCandidates")
public class ImageCandidatesController {

	private ImageCandidateService imageCandidateService;
	
	@Autowired
	public ImageCandidatesController(ImageCandidateService imageCandidateService) {
		super();
		this.imageCandidateService = imageCandidateService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody ImageCandidate imageCandidate) {
		return this.imageCandidateService.add(imageCandidate);
	}
	
	@RequestMapping(
		    path = "/upload", 
		    method = RequestMethod.POST, 
		    consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Result upload(@RequestPart MultipartFile file,@RequestParam int candidateId) {
		return this.imageCandidateService.upload(file,candidateId);
	}
}
