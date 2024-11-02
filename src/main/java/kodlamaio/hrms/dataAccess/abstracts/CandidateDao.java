package kodlamaio.hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.dtos.CandidateCVDto;
import kodlamaio.hrms.entities.concretes.users.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

	//@Query("SELECT new kodlamaio.hrms.entities.concretes.dtos.CandidateCVDto(cand.id,cov,ima,lan,tal,web,wor) FROM Candidate cand LEFT JOIN cand.coverLetterCandidate cov LEFT JOIN cand.imageCandidate ima LEFT JOIN cand.languageInformationCandidates lan LEFT JOIN cand.talentCandidates tal LEFT JOIN cand.webAddressCandidate web LEFT JOIN cand.workExperienceCandidates wor WHERE cand.id=:candidateId")
	//List<CandidateCVDto> getCandidateCVDtoById(int candidateId);
}
