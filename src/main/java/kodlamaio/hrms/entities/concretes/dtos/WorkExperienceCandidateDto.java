package kodlamaio.hrms.entities.concretes.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceCandidateDto {
	private String companyName;
	private String position;
	private String startYear;
	private String endYear;
}
