package kodlamaio.hrms.entities.concretes.dtos.mappers;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.entities.concretes.cadidateCVs.LanguageInformationCandidate;
import kodlamaio.hrms.entities.concretes.dtos.LanguageInformationCandidateDto;

@Component
public class LanguageInformationCandidateMapper {

	public LanguageInformationCandidateDto toDto(LanguageInformationCandidate languageInformationCandidate) {
		return new LanguageInformationCandidateDto(languageInformationCandidate.getLanguage(),languageInformationCandidate.getLevel());
	}
}
