package com.mphasis.training.proj.pl;

import java.time.LocalDate;
import java.util.Scanner;

import com.mphasis.training.proj.exceptions.BuissnessException;
import com.mphasis.training.proj.pojos.Employee;
import com.mphasis.training.proj.services.EmployeeBo;
import com.mphasis.training.proj.services.EmployeeBoImpl;
import com.mphasis.training.proj.util.DbUtil;

public class EmployeeApp {
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to Employee App");  
	    Scanner sc=new Scanner(System.in);  
	    EmployeeBo employeeBo=new EmployeeBoImpl();  
	    do {  
	    	
	        System.out.println("1. Employees 2.Add Employee");  
	        switch(sc.nextInt()) {  
	        case 1: System.out.println("List of employees");  
	            try {  
	                employeeBo.getAllEmployee().forEach(e->System.out.println(e));  
	            } catch (BuissnessException e) {  
	                System.out.println(e.getMessage());  
	            }  
	            break;  
	            
	        case 2: System.out.println("enter employee details");
	                Employee e1=new Employee();  
	                    System.out.println("enter id");  
	                    e1.setEmpid(sc.nextInt());  
	                    System.out.println("enter name");  
	                    e1.setEname(sc.next());  
	                    System.out.println("enter salary");  
	                    e1.setSalary(sc.nextDouble());  
	                    System.out.println("enter doj(year, month,date)");  
	                    e1.setDoj(LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt()));  
	                    try {  
	                                 employeeBo.addEmployee(e1);  
	                                 System.out.println("Employee added "+e1.getEmpid());  
	                        } catch (Exception e) {  
	                                                System.out.println(e.getMessage());  
	                                              }  
	            break;
	            
	        case 3:System.out.println("Enter employee id");
	        try {
	        	Employee e = employeeBo.getEmployeeById(sc.nextInt());
	        	System.out.println(e);
	        	
	        }catch(BuissnessException e) {
	        	System.out.println(e.getMessage());
	        	
	        }
	        	
	        	break;
	        	
	        case 4:System.out.println("Enter id to Update");
	        try {
	        	Employee e = employeeBo.getEmployeeById(sc.nextInt());
	        	System.out.println("Enter salary to update");
	        	e.setSalary(sc.nextDouble());
	        	employeeBo.updateEmployee(e);
	        	System.out.println(e);
	        	
	        }catch(BuissnessException e) {
	        	System.out.println(e.getMessage());
	        	
	        }
	        	
	        	break;
	        	
	        case 5:System.out.println("Enter id to Delete");
	        try {
	            employeeBo.removeEmployee(sc.nextInt());
	        	System.out.println("Enter record deleted");
	        	
	        }catch(BuissnessException e) {
	        	System.out.println(e.getMessage());
	        	
	        }
	            break;
	        
	        case 6:
	        	DbUtil.closeConnection();
	        	sc.close();
	            System.exit(0);  
	            break;
	            
	        default: System.out.println("invalid");  
	        }  
	    }while(true);  
	    }  
		
	}
	
    

