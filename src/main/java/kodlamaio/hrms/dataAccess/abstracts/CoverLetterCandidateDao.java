package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cadidateCVs.CoverLetterCandidate;

public interface CoverLetterCandidateDao extends JpaRepository<CoverLetterCandidate, Integer> {

	CoverLetterCandidate getByCandidate_Id(int candidateId);
}
