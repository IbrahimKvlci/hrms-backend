package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.verifications.EmployeeConfirmJob;

public interface EmployeeConfirmJobDao extends JpaRepository<EmployeeConfirmJob, Integer>{
	EmployeeConfirmJob findByJobId(int id);
}
