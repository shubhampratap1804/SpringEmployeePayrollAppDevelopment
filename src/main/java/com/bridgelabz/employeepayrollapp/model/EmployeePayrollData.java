package com.bridgelabz.employeepayrollapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

@Entity
@Table(name ="EMPLOYEE")
public class EmployeePayrollData {

	@Id
	private int employeeId;
	private String name;
	private long salary;

	public EmployeePayrollData() {
	}

	public EmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		super();
		this.employeeId = empId;
		this.name = empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

}
