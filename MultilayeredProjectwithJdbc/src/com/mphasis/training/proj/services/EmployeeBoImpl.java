package com.mphasis.training.proj.services;

import java.util.List;
import java.util.stream.Collectors;

import com.mphasis.training.proj.exceptions.BuissnessException;
import com.mphasis.training.proj.pojos.Employee;
import com.mphasis.training.proj.repos.EmployeeRepo;
import com.mphasis.training.proj.repos.EmployeeRepoImpl;

public class EmployeeBoImpl implements EmployeeBo {

	EmployeeRepo employeeRepo;  
    
    public EmployeeBoImpl() {  
       employeeRepo=new EmployeeRepoImpl();  
    }  
     
    
   public List<Employee> getAllEmployee() throws BuissnessException{  
       List<Employee> employees=employeeRepo.retiveAllEmployee();  
       if(employees.isEmpty()) {  
           throw new BuissnessException("No Employees Found");  
       }  
       return employees;  
   }
	

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeRepo.retriveEmployeeById(id);
	}

	@Override
	public int addEmployee(Employee e)throws BuissnessException {
		// TODO Auto-generated method stub
		
		int i=0;
		if(e.getEmpid()>0 && e.getEmpid()<999) {
			if(e.getEname().matches("[a-zA-z]{3,10}")) {
				if(e.getSalary()>20000 && e.getSalary()<80000) {
					i=employeeRepo.addEmployee(e);
				}
				else {
					throw new BuissnessException("Invalid Employee Salary");
                }
			}
			else {
				throw new BuissnessException("Invalid Employee Name(Name should contain 3 to 10 letters)");
            }
			
		}
		else {
			      throw new BuissnessException("Invalid Employee Id");
		}
	    return i;
	}

	@Override
	public int updateEmployee(Employee e) {
		// TODO Auto-generated method stub
	
		return employeeRepo.updateEmployee(e);
	}

	@Override
	public int removeEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeRepo.deleteEmployee(id);
	}

	@Override
	public List<Employee> sortEmployeeByName() {
		// TODO Auto-generated method stub
	            List<Employee> employee = employeeRepo.retiveAllEmployee();
		        employee.sort((e1,e2)->e1.getEname().compareTo(e2.getEname()));
		        return employee;
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		
		
		// TODO Auto-generated method stub
		return employeeRepo.retiveAllEmployee().stream()
				.filter((e)->e.getEname().equals(name))
				.collect(Collectors.toList());
	}

	@Override
	public List<Employee> getEmployeeBySalary(double salary) {
		// TODO Auto-generated method stub
		List<Employee> employee = employeeRepo.retiveAllEmployee();
        employee.sort((e1,e2)->(int)(e1.getSalary()-e2.getSalary()));
		return employee;
	}

	@Override
	public Employee getEmployeeWithHighestExperience() {
		// TODO Auto-generated method stub
		return null;
	}

}
