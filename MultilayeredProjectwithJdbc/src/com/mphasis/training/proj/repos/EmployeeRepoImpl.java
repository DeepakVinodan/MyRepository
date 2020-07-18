package com.mphasis.training.proj.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mphasis.training.proj.pojos.Employee;
import com.mphasis.training.proj.util.DbUtil;

public class EmployeeRepoImpl implements EmployeeRepo {
	
	
	
	Connection con = null;
	
	public EmployeeRepoImpl(){
		
		con= DbUtil.openConnection();
	}
	

	@Override
	public List<Employee> retiveAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<>();
		try {
			String sql ="select * from employee";
			 Statement st = con.createStatement();  
             ResultSet rs = st.executeQuery(sql);
             //mapping of java members to jdbc members
             while(rs.next()) {
            	 Employee e = new Employee();
            	 e.setEmpid(rs.getInt(1));
            	 e.setEname(rs.getNString(2));
            	 e.setSalary(rs.getDouble(3));
            	 //LocalDate of java cannot be mapped to Sql date directly
            	 //so first convert into sqldate and then map.
            	 java.sql.Date sqlDate = rs.getDate(4);
            	 LocalDate ld=sqlDate.toLocalDate();
            	 e.setDoj(ld);
            	 employees.add(e);
             }
      }catch(SQLException e) {
			e.getStackTrace();
		}
		return employees;
	}

	@Override
	public Employee retriveEmployeeById(int id) {
		// TODO Auto-generated method stub
		 Employee employee = new Employee();
		 try {
			 String sql = "select * from employee where empid=?";
			 PreparedStatement pst = con.prepareStatement(sql);
			 pst.setInt(1,id);
			 ResultSet rst = pst.executeQuery();
			 if(rst.next()) {
				
            	 employee.setEmpid(rst.getInt(1));
            	 employee.setEname(rst.getNString(2));
            	 employee.setSalary(rst.getDouble(3));
            	 //LocalDate of java cannot be mapped to Sql date directly
            	 //so first convert into sqldate and then map.
            	 java.sql.Date sqlDate = rst.getDate(4);
            	 LocalDate ld=sqlDate.toLocalDate();
            	 employee.setDoj(ld);
			 }
			 
			 
			 
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		 
		
		return employee;
	}

	@Override
	public int addEmployee(Employee e) {
		// TODO Auto-generated method stub
		
		int i=0;
		try {
			String sql ="insert into product values(?,?,?,?)";
    		PreparedStatement pst = con.prepareStatement(sql);
    		
    	
    		pst.setInt(1,e.getEmpid());
    		
    		pst.setString(2,e.getEname());
    	
    		pst.setDouble(3,e.getSalary());
    		
    		LocalDate ld=e.getDoj();
    		
    		pst.setDate(4,java.sql.Date.valueOf(ld));
    		i=pst.executeUpdate();
    		
		}catch(SQLException e1) {
			e1.getStackTrace();
		}
		return i;
	}

	@Override
	public int updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			String sql ="update employee set salary=? where empid=?";
    		PreparedStatement pst = con.prepareStatement(sql);
    		pst.setDouble(1,e.getSalary());
    		pst.setInt(2,e.getEmpid());
    		i=pst.executeUpdate();
    		
			
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteEmployee(int id) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			String sql ="delete from employee where empid=?";
    		PreparedStatement pst = con.prepareStatement(sql);
    		pst.setInt(1, id);
    		i=pst.executeUpdate();
		}catch(SQLException e1) {
			e1.printStackTrace();
}
		return i;
	}

}
