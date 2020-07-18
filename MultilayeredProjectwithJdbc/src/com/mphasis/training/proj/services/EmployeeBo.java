package com.mphasis.training.proj.services;

import java.util.List;

import com.mphasis.training.proj.exceptions.BuissnessException;
import com.mphasis.training.proj.pojos.Employee;

public interface EmployeeBo {
	 
    public List<Employee> getAllEmployee()throws BuissnessException;  
    public Employee getEmployeeById(int id)throws BuissnessException;  
    public int addEmployee(Employee e)throws BuissnessException;  
    public int updateEmployee(Employee e)throws BuissnessException;  
    public int removeEmployee(int id)throws BuissnessException;  
    public List<Employee> sortEmployeeByName()throws BuissnessException;  
    public List<Employee> getEmployeeByName(String name)throws BuissnessException;  
    public List<Employee> getEmployeeBySalary(double salary)throws BuissnessException;  
    public Employee getEmployeeWithHighestExperience()throws BuissnessException;

}
