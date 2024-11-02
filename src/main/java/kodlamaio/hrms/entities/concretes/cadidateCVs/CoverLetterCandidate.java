package kodlamaio.hrms.entities.concretes.cadidateCVs;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cover_letter_candidates")
@EqualsAndHashCode(callSuper = true)
public class CoverLetterCandidate extends CoverLetter {
	
	@OneToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
