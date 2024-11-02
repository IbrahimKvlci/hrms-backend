package kodlamaio.hrms.entities.concretes.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInformationCandidateDto {

	private String schoolName;
	private String department;
	private String graduationYear;
}
