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
@Table(name = "verification_code_candidates")
@EqualsAndHashCode(callSuper = true)
public class VerificationCodeCandidate extends VerificationCode {
	
	@Column(name="candidate_id")
	private int candidateId;

	public VerificationCodeCandidate(int id, String code, boolean isVerified, Date verifiedDate, int candidateId) {
		super(id, code, isVerified, verifiedDate);
		this.candidateId = candidateId;
	}
}
