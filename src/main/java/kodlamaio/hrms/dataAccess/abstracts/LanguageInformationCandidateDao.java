package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cadidateCVs.LanguageInformationCandidate;

public interface LanguageInformationCandidateDao extends JpaRepository<LanguageInformationCandidate, Integer> {

}
