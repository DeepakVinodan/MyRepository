package com.mphasis.training.proj.repos;

import java.util.List;

import com.mphasis.training.proj.pojos.Employee;

public interface EmployeeRepo {

    public List<Employee> retiveAllEmployee();  
    public Employee retriveEmployeeById(int id);  
    public int addEmployee(Employee e);  
    public int updateEmployee(Employee e);  
    public int deleteEmployee(int id);  
    
}
