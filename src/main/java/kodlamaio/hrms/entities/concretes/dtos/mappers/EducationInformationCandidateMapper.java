package kodlamaio.hrms.entities.concretes.dtos.mappers;



import org.springframework.stereotype.Component;

import kodlamaio.hrms.entities.concretes.cadidateCVs.EducationInformationCandidate;
import kodlamaio.hrms.entities.concretes.dtos.EducationInformationCandidateDto;


@Component
public class EducationInformationCandidateMapper {

	public EducationInformationCandidateDto toDto(EducationInformationCandidate educationInformationCandidate) {
		return new EducationInformationCandidateDto(educationInformationCandidate.getSchoolName(), educationInformationCandidate.getDepartment(), educationInformationCandidate.getGraduationYear());
	}
}