
package com.niit.Mainproject.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Mainproject.model1.Employee;

@Repository("employeeDAO")
@Transactional
public class EmployeeDAOImplementation implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
    
	public List<Employee> getEmployeeList() {
		
		return  sessionFactory.getCurrentSession().createQuery("from Employee").list() ;
	} 
    
   // @Override
	public Employee getEmployee(int empId) {
		
		return(Employee) sessionFactory.getCurrentSession().createQuery("from Employee where empId="+empId).uniqueResult()  ;
	}
    
   // @Override
	public boolean addEmployee(Employee emp) {
    	try
    	{
    		sessionFactory.getCurrentSession().save(emp);
    		return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
	} 
    
   // @Override
	public boolean updateEmployee(Employee emp) {
    	try
    	{
    		
			sessionFactory.getCurrentSession().update(emp);
    		return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
		
	}
    
   // @Override
	public boolean deleteEmployee(int empId) {
		try
		{
			sessionFactory.getCurrentSession().delete(findById(empId));
			return true;
		}
		catch(Exception e)
		{
		    return false;
	}
    }
    
   // @Override
	public Employee findById(int empId) {
		
    	return(Employee) sessionFactory.getCurrentSession().createQuery("from Employee where empId="+empId).uniqueResult() ;

		
	}

}
