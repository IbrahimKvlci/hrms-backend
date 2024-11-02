package kodlamaio.hrms.entities.concretes.cadidateCVs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import kodlamaio.hrms.entities.concretes.WebAddress;
import kodlamaio.hrms.entities.concretes.users.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "web_address_candidates")
@EqualsAndHashCode(callSuper = true)
public class WebAddressCandidate extends WebAddress {

	@OneToOne
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
}
