package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import kodlamaio.hrms.entities.concretes.users.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="jobs")
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	//@Column(name="employer_id")
	//private int employerId;
	
	//@Column(name="job_title_id")
	//private int jobTitleId;
	
	//@Column(name="city_id")
	//private int cityId;
	
	@Column(name="job_details")
	private String jobDetails;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="number_open_positions")
	private int numberOpenPositions;
	
	@Column(name="posting_date")
	private Date postingDate;
	
	@Column(name="application_deadline_date")
	private Date applicationDeadlineDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@JoinColumn(name="employer_id")
	@ManyToOne
	private Employer employer;
	
	@JoinColumn(name="job_title_id")
	@ManyToOne
	private JobTitle jobTitle;
	
	@JoinColumn(name="city_id")
	@ManyToOne
	private City city;
	
	@JoinColumn(name="working_time_id")
	@ManyToOne
	private WorkingTime workingTime;
	
	@JoinColumn(name="working_type_id")
	@ManyToOne
	private WorkingType workingType;
}
