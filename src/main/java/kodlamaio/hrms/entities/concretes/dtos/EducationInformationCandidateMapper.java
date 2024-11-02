package kodlamaio.hrms.entities.concretes.dtos;



import org.springframework.stereotype.Component;

import kodlamaio.hrms.entities.concretes.cadidateCVs.EducationInformationCandidate;


@Component
public class EducationInformationCandidateMapper {

	public EducationInformationCandidateDto toDto(EducationInformationCandidate educationInformationCandidate) {
		return new EducationInformationCandidateDto(educationInformationCandidate.getSchoolName(), educationInformationCandidate.getDepartment(), educationInformationCandidate.getGraduationYear());
	}
}