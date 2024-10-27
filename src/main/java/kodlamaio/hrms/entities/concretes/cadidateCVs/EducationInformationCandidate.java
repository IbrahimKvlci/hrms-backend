package kodlamaio.hrms.entities.concretes.cadidateCVs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kodlamaio.hrms.entities.concretes.EducationInformation;
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

	@Column(name="candidate_id")
	private int candidateId;
}
