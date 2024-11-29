package kodlamaio.hrms.entities.concretes.dtos.mappers;

import java.util.Date;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Job;
import kodlamaio.hrms.entities.concretes.JobTitle;
import kodlamaio.hrms.entities.concretes.WorkingTime;
import kodlamaio.hrms.entities.concretes.WorkingType;
import kodlamaio.hrms.entities.concretes.dtos.JobAddDto;
import kodlamaio.hrms.entities.concretes.users.Employer;

@Component
public class JobMapper {

	public Job toJob(JobAddDto jobAddDto) {
		int id=0;
		String jobDetails=jobAddDto.getJobDetails();
		int minSalary=jobAddDto.getMinSalary();
		int maxSalary=jobAddDto.getMaxSalary();
		int numberOpenPositions=jobAddDto.getNumberOpenPositions();
		Date postingDate=jobAddDto.getPostingDate();
		Date applicationDeadlineDate=jobAddDto.getApplicationDeadlineDate();
		boolean isActive=true;
		Employer employer=new Employer();
		employer.setId(jobAddDto.getEmployerId());
		JobTitle jobTile=new JobTitle();
		jobTile.setId(jobAddDto.getJobTitleId());
		City city=new City();
		city.setId(jobAddDto.getCityId());
		WorkingTime workingTime=new WorkingTime();
		workingTime.setId(jobAddDto.getWorkingTimeId());
		WorkingType workingType=new WorkingType();
		workingType.setId(jobAddDto.getWorkingTypeId());
		
		return new Job(id,jobDetails,minSalary,maxSalary,numberOpenPositions,postingDate,applicationDeadlineDate,isActive,employer,jobTile,city,workingTime,workingType);
	}

}
