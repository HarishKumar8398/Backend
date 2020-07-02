package com.niit.Mainproject.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.niit.Mainproject.model1.Employee;

public interface EmployeeService {
	public List<Employee> getEmployeeList();
	public Employee getEmployee(int empId);
	public boolean addEmployee(Employee emp);
	public boolean updateEmployee(Employee emp);
	public boolean deleteEmployee(int empId);
	public Employee findById(int empId);
	
	
	

}
