package kodlamaio.hrms.entities.concretes.cadidateCVs;

import java.util.Date;

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
@Table(name = "image_candidates")
@EqualsAndHashCode(callSuper = true)
public class ImageCandidate extends Image{
	
	public ImageCandidate(int id, String imageName, Date uploadedDate, int candidateId) {
		super(id, imageName, uploadedDate);
		this.candidateId = candidateId;
	}

	@Column(name="candidate_id")
	private int candidateId;
}
