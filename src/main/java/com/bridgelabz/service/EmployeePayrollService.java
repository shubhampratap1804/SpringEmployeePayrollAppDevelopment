package com.bridgelabz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.dto.EmployeePayrollDTO;
import com.bridgelabz.exception.EmployeePayrollCustomException;
import com.bridgelabz.model.EmployeePayrollData;
import com.bridgelabz.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeeService {

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int id) {
		return employeeRepository.findById(id)
				.orElseThrow( () -> 
					new EmployeePayrollCustomException("Employee with this id " + id + "doest not exists!"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData =null;
		employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
		log.debug("AddressBook Data:"+employeePayrollData.toString());
		return employeeRepository.save(employeePayrollData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int id, EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(id);
		employeePayrollData.updateEmployeePayrollData(employeePayrollDTO);
		return employeeRepository.save(employeePayrollData);
	}

	@Override
	public void deleteEmployeePayrollData(int id) {
		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(id);
		employeeRepository.delete(employeePayrollData);
	}
}
