package kodlamaio.hrms.entities.concretes.dtos.mappers;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.entities.concretes.cadidateCVs.TalentCandidate;
import kodlamaio.hrms.entities.concretes.dtos.TalentCandidateDto;

@Component
public class TalentCandidateMapper {

	public TalentCandidateDto toDto(TalentCandidate talentCandidate) {
		return new TalentCandidateDto(talentCandidate.getKnownTechnology());
	}
}
