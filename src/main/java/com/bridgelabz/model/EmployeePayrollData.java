package com.bridgelabz.model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.dto.EmployeePayrollDTO;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_payroll")
public class EmployeePayrollData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_Id")
	private int employeeId;
	
	private String name;
	private String gender;
	private String department;
	private long salary;
	private LocalDate startDate;
	private String note;
	private String profilePicture;
	
	
	public EmployeePayrollData() { }
	
	public EmployeePayrollData(EmployeePayrollDTO employeePyarollDTO) {
		this.updateEmployeePayrollData(employeePyarollDTO);
	}
	
	
	public void updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		this.name = employeePayrollDTO.name;
		this.gender = employeePayrollDTO.gender;
		this.department = employeePayrollDTO.department;
		this.salary = employeePayrollDTO.salary;
		this.startDate = employeePayrollDTO.startDate;
		this.note =employeePayrollDTO.note;
		this.profilePicture = employeePayrollDTO.profilePicture;
	}
}
