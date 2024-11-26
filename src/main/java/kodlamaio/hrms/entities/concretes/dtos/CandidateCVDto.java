package kodlamaio.hrms.entities.concretes.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.cadidateCVs.CoverLetterCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.EducationInformationCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.ImageCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.LanguageInformationCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.TalentCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.WebAddressCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.WorkExperienceCandidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCVDto {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String coverLetterText;
	private List<EducationInformationCandidateDto> educationInformations;
	private String imageFullPath;
	private List<LanguageInformationCandidateDto> languageInormations;
	private List<TalentCandidateDto> talents;
	private String linkedinAddress;
	private String GithubAddress;
	private List<WorkExperienceCandidateDto> workExperiences;
}
