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
@AllArgsConstructor
@NoArgsConstructor
@Table(name="verification_code_employers")
@EqualsAndHashCode(callSuper=true)
public class VerificationCodeEmployer extends VerificationCode{
	
	@Column(name="employer_id")
	private int employerId;
	
	public VerificationCodeEmployer(int id, String code, boolean isVerified, Date verifiedDate, int employerId) {
		super(id, code, isVerified, verifiedDate);
		this.employerId = employerId;
	}
}
