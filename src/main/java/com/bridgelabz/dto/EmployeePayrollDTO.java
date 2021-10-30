package com.bridgelabz.dto;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmployeePayrollDTO {
	
	public String name;
	public String gender;
	public String department;
	public long salary;
	public LocalDate startDate;
	public String note;
	public String profilePicture;
	
	
	public EmployeePayrollDTO(String name, String gender, String department, long salary,  LocalDate startDate, String note, String profilePicture) {
		this.name = name;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
		this.startDate = startDate;
		this.note = note;
		this.profilePicture = profilePicture;
	}
}
