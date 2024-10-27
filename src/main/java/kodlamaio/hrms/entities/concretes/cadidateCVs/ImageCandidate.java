package kodlamaio.hrms.entities.concretes.cadidateCVs;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kodlamaio.hrms.entities.concretes.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "image_candidate")
@EqualsAndHashCode(callSuper = true)
public class ImageCandidate extends Image{
	
	@Column(name="candidate_id")
	private int candidateIs;
}
