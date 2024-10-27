package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.verifications.EmployeeConfirmEmployer;

public interface EmployeeConfirmEmployerDao extends JpaRepository<EmployeeConfirmEmployer, Integer>{
	EmployeeConfirmEmployer findByEmployerId(int id);
}
