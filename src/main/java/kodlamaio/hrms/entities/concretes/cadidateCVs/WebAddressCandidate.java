package kodlamaio.hrms.entities.concretes.cadidateCVs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kodlamaio.hrms.entities.concretes.WebAddress;
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

	@Column(name="candidate_id")
	private int candidateId;
}
