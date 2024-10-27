package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cadidateCVs.TalentCandidate;

public interface TalentCandidateDao extends JpaRepository<TalentCandidate, Integer> {

}
