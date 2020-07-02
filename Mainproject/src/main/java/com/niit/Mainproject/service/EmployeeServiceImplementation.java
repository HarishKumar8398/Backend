package com.niit.Mainproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Mainproject.dao.EmployeeDAO;
import com.niit.Mainproject.model1.Employee;
@Service
@Repository("employeeService")
@Transactional
public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	//@Override
	public List<Employee> getEmployeeList() {
		
		return employeeDAO.getEmployeeList();
	}
	
	public Employee getEmployee(int empId) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(empId);
	}	


	
	//@Override
	public boolean addEmployee(Employee emp) {
		
		 employeeDAO.addEmployee(emp);
		 return true;
		
	}

	//@Override
	public boolean updateEmployee(Employee emp) {
		
		 employeeDAO.updateEmployee(emp);
		 return true;
	}

	//@Override
	public boolean deleteEmployee(int empId) {
		employeeDAO.deleteEmployee(empId);
		return true;
	}

	//@Override
	public Employee findById(int empId) {
		return employeeDAO.findById(empId);
		
	}

	
}
