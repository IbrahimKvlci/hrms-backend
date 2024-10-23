package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.VerificationCodeCandidate;

public interface VerificationCodeCandidateDao extends JpaRepository<VerificationCodeCandidate, Integer> {
	List<VerificationCodeCandidate> findByCandidateId(int id);
}
