package kodlamaio.hrms.entities.concretes.dtos;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.entities.concretes.cadidateCVs.LanguageInformationCandidate;

@Component
public class LanguageInformationCandidateMapper {

	public LanguageInformationCandidateDto toDto(LanguageInformationCandidate languageInformationCandidate) {
		return new LanguageInformationCandidateDto(languageInformationCandidate.getLanguage(),languageInformationCandidate.getLevel());
	}
}
