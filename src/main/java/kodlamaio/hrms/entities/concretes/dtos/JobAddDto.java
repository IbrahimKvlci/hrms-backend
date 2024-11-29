package kodlamaio.hrms.entities.concretes.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAddDto {

	private String jobDetails;
	
	private int minSalary;

	private int maxSalary;
	
	private int numberOpenPositions;
	
	private Date postingDate;
	
	private Date applicationDeadlineDate;

	private int employerId;

	private int jobTitleId;

	private int cityId;
	
	private int workingTimeId;
	
	private int workingTypeId;
}
