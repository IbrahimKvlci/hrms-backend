package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cadidateCVs.WebAddressCandidate;

public interface WebAddressCandidateDao extends JpaRepository<WebAddressCandidate, Integer> {

}
