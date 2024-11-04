package kodlamaio.hrms.entities.concretes.dtos.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.adapters.imageCloudServices.abstracts.ImageCloudService;
import kodlamaio.hrms.entities.concretes.cadidateCVs.CoverLetterCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.EducationInformationCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.ImageCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.LanguageInformationCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.TalentCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.WebAddressCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.WorkExperienceCandidate;
import kodlamaio.hrms.entities.concretes.dtos.CandidateCVDto;
import kodlamaio.hrms.entities.concretes.dtos.EducationInformationCandidateDto;
import kodlamaio.hrms.entities.concretes.dtos.LanguageInformationCandidateDto;
import kodlamaio.hrms.entities.concretes.dtos.TalentCandidateDto;
import kodlamaio.hrms.entities.concretes.dtos.WorkExperienceCandidateDto;
import kodlamaio.hrms.entities.concretes.users.Candidate;

@Component
public class CandidateCVMapper {
	
	private EducationInformationCandidateMapper educationInformationCandidateMapper;
	private LanguageInformationCandidateMapper languageInformationCandidateMapper;
	private TalentCandidateMapper talentCandidateMapper;
	private WorkExperienceCandidateMapper workExperienceCandidateMapper;
	
	private ImageCloudService imageCloudService;
	
	@Autowired
	public CandidateCVMapper(EducationInformationCandidateMapper educationInformationCandidateMapper,LanguageInformationCandidateMapper languageInformationCandidateMapper,TalentCandidateMapper talentCandidateMapper,WorkExperienceCandidateMapper workExperienceCandidateMapper,ImageCloudService imageCloudService) {
		super();
		this.educationInformationCandidateMapper = educationInformationCandidateMapper;
		this.languageInformationCandidateMapper=languageInformationCandidateMapper;
		this.talentCandidateMapper=talentCandidateMapper;
		this.workExperienceCandidateMapper=workExperienceCandidateMapper;
		this.imageCloudService=imageCloudService;
	}


	public CandidateCVDto toDto(Candidate candidate) {
		int id=candidate.getId();
		String coverLetterText=candidate.getCoverLetterCandidate().getCoverLetterText();
		List<EducationInformationCandidateDto> educationInformationCandidates=candidate.getEducationInformationCandidates().stream().map(educationInformationCandidateMapper::toDto).collect(Collectors.toList());
		String imageFullPath=this.imageCloudService.getImagePath(candidate.getImageCandidate().getImageName());
		List<LanguageInformationCandidateDto> languageInormations = candidate.getLanguageInformationCandidates().stream().map(languageInformationCandidateMapper::toDto).collect(Collectors.toList());
		List<TalentCandidateDto> talents=candidate.getTalentCandidates().stream().map(talentCandidateMapper::toDto).collect(Collectors.toList());
		String linkedinAddress=candidate.getWebAddressCandidate().getLinkedinAddress();
		String githubAddress=candidate.getWebAddressCandidate().getGithubAddress();
		List<WorkExperienceCandidateDto> workExperiences=candidate.getWorkExperienceCandidates().stream().map(workExperienceCandidateMapper::toDto).collect(Collectors.toList());
		
		return new CandidateCVDto(id, coverLetterText, educationInformationCandidates, imageFullPath, languageInormations, talents, linkedinAddress,githubAddress, workExperiences);
	}
}
