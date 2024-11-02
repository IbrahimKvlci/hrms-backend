package kodlamaio.hrms.entities.concretes.dtos;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.entities.concretes.cadidateCVs.WorkExperienceCandidate;

@Component
public class WorkExperienceCandidateMapper {

	public WorkExperienceCandidateDto toDto(WorkExperienceCandidate workExperienceCandidate) {
		return new WorkExperienceCandidateDto(workExperienceCandidate.getCompanyName(), workExperienceCandidate.getPosition(), workExperienceCandidate.getStartYear(), workExperienceCandidate.getEndYear());
	}
}
