package kodlamaio.hrms.entities.concretes.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageInformationCandidateDto {

	private String language;
	private int level;
}
