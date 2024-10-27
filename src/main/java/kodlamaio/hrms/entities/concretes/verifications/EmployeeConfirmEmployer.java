package kodlamaio.hrms.entities.concretes.verifications;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Table(name="employee_confirm_employers")
public class EmployeeConfirmEmployer extends EmployeeConfirm {

	@Column(name="employer_id")
	private int employerId;
	
	public EmployeeConfirmEmployer(int id,int employeeId,boolean isConfirmed,Date confirmedDate,int employerId) {
		super(id,employeeId,isConfirmed,confirmedDate);
		this.employerId=employerId;
	}
}
