package com.bridgelabz.employeepayrollapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

public interface EmployeeRepository extends JpaRepository<EmployeePayrollData, Integer> {

	
}
