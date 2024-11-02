package kodlamaio.hrms.entities.concretes.cadidateCVs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import kodlamaio.hrms.entities.concretes.EducationInformation;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "education_information_candidates")
@EqualsAndHashCode(callSuper = true)
public class EducationInformationCandidate extends EducationInformation {

	@ManyToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
