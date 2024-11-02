package kodlamaio.hrms.entities.concretes.dtos;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.entities.concretes.cadidateCVs.TalentCandidate;

@Component
public class TalentCandidateMapper {

	public TalentCandidateDto toDto(TalentCandidate talentCandidate) {
		return new TalentCandidateDto(talentCandidate.getKnownTechnology());
	}
}
