package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.verifications.VerificationCodeCandidate;

public interface VerificationCodeCandidateDao extends JpaRepository<VerificationCodeCandidate, Integer> {
	VerificationCodeCandidate findByCandidateId(int id);
}
