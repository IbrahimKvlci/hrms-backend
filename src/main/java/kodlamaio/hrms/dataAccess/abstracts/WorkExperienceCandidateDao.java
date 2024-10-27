package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cadidateCVs.WorkExperienceCandidate;

public interface WorkExperienceCandidateDao extends JpaRepository<WorkExperienceCandidate, Integer> {

}
