package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cadidateCVs.ImageCandidate;

public interface ImageCandidateDao extends JpaRepository<ImageCandidate, Integer>{

}
