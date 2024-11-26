package kodlamaio.hrms.entities.concretes.dtos;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobTitle;
import kodlamaio.hrms.entities.concretes.users.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
	private int id;

	private String jobDetails;
	
	private String workingTime;
	
	private String workingType;
	
	private int minSalary;

	private int maxSalary;
	
	private int numberOpenPositions;
	
	private Date postingDate;
	
	private Date applicationDeadlineDate;
	
	private boolean isActive;

	private String employerName;

	private String jobTitle;

	private String city;
}
