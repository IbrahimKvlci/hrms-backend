package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{
	Job getById(int id);
	List<Job> getByIsActive(boolean isActive);
	List<Job> getByIsActive(boolean isActive,Sort sort);
	List<Job> getByIsActiveAndEmployer_CompanyName(boolean isActive,String companyName);
}
