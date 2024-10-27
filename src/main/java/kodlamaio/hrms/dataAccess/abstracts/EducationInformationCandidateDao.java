package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cadidateCVs.EducationInformationCandidate;

public interface EducationInformationCandidateDao extends JpaRepository<EducationInformationCandidate, Integer> {

}
