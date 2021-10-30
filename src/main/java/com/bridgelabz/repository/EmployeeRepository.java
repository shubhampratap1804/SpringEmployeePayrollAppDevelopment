package com.bridgelabz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.model.EmployeePayrollData;

public interface EmployeeRepository extends JpaRepository<EmployeePayrollData, Integer>{

}
