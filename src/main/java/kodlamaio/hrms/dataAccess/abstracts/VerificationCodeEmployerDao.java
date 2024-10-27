package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.verifications.VerificationCodeEmployer;

public interface VerificationCodeEmployerDao extends JpaRepository<VerificationCodeEmployer, Integer> {
	VerificationCodeEmployer findByEmployerId(int id);
}
