package kodlamaio.hrms.entities.concretes.users;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import kodlamaio.hrms.entities.concretes.cadidateCVs.CoverLetterCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.EducationInformationCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.ImageCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.LanguageInformationCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.TalentCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.WebAddressCandidate;
import kodlamaio.hrms.entities.concretes.cadidateCVs.WorkExperienceCandidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","coverLetterCandidate","educationInformationCandidates","imageCandidate","languageInformationCandidates","talentCandidates","webAddressCandidate","workExperienceCandidates"})
public class Candidate extends User{
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name = "birth_year")
	private int birthYear;
	
	@OneToOne(mappedBy = "candidate")
	private CoverLetterCandidate coverLetterCandidate;
	
	@OneToMany(mappedBy = "candidate")
	private List<EducationInformationCandidate> educationInformationCandidates;
	
	@OneToOne(mappedBy = "candidate")
	private ImageCandidate imageCandidate;
	
	@OneToMany(mappedBy = "candidate")
	private List<LanguageInformationCandidate> languageInformationCandidates;
	
	@OneToMany(mappedBy = "candidate")
	private List<TalentCandidate> talentCandidates;
	
	@OneToOne(mappedBy = "candidate")
	private WebAddressCandidate webAddressCandidate;
	
	@OneToMany(mappedBy = "candidate")
	private List<WorkExperienceCandidate> workExperienceCandidates;
}
