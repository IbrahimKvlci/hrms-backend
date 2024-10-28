package kodlamaio.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationInformationCandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
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

	@Override
	public DataResult<List<EducationInformationCandidate>> getAllSorted() {
		List<EducationInformationCandidate> educationInformationCandidateList=new ArrayList<EducationInformationCandidate>();
		List<EducationInformationCandidate> educationInformationCandidateListFromDataSorted=educationInformationCandidateDao.findAll(Sort.by(Sort.Direction.DESC,"graduationYear"));
		
		for (EducationInformationCandidate educationInformationCandidate : educationInformationCandidateListFromDataSorted) {
			if(educationInformationCandidate.getGraduationYear().isEmpty()) {
				educationInformationCandidate.setGraduationYear("Continue");
				educationInformationCandidateList.add(educationInformationCandidate);
			}
		}
		
		for (EducationInformationCandidate educationInformationCandidate : educationInformationCandidateListFromDataSorted){
			if(educationInformationCandidateList.contains(educationInformationCandidate))
				continue;
			educationInformationCandidateList.add(educationInformationCandidate);
		}
		
		return new SuccessDataResult<List<EducationInformationCandidate>>(educationInformationCandidateList);
	}

}
