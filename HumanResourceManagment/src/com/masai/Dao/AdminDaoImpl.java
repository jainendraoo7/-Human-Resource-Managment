package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.Department;
import com.masai.model.Employees;
import com.masai.utility.DaoUtility;

public class AdminDaoImpl implements AdminDao {

	@Override
	public String AddEmployee(Employees employee) throws AdminException {
		String message  = "Not Inserted....";
		
		try(Connection conn = DaoUtility.provideConnection()){
			
		PreparedStatement ps = 	conn.prepareStatement("insert into employees values(?,?,?,?,?,?,?,?,?)");
			
		ps.setInt(1, employee.getEid());
		ps.setString(2, employee.getEname());
		ps.setString(3, employee.getAddress());
		ps.setString(4, employee.getEmail());
		ps.setString(5, employee.getPassword());
		ps.setInt(6, employee.getSalary());
		ps.setInt(7, employee.getDid());
		ps.setString(8, employee.getRequest_for_Leave());
		ps.setString(9, employee.getLeave_status());

		int x = ps.executeUpdate();
		
		if(x > 0) {
			message  = "Employee Inserted Succesfully...";
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage()); 
		}
		
		
		
		return message;
	}

	@Override
	public String AddDepartment(Department department) throws AdminException {
		
		
         String message  = "Department Not Inserted....";
		
		try(Connection conn = DaoUtility.provideConnection()){
			
		PreparedStatement ps = 	conn.prepareStatement("insert into department values(?,?,?)");
			
	
		ps.setInt(1, department.getDid());
		ps.setString(2, department.getDname());
		ps.setString(3, department.getLocation());

		
		int x = ps.executeUpdate();
		
		if(x > 0) {
			message  = "Department Inserted Succesfully...";
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage()); 
		}
		
		return message;
	}

	@Override
	public Department viewDepartmentByDid(int did) throws AdminException {
		Department dept = null;
		
		try(Connection conn = DaoUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from department where did = ?");
			
		     ps.setInt(1, did);
			
		     ResultSet rs = ps.executeQuery();
		     
		     if(rs.next()) {
		    	 
		    	 int id = rs.getInt("did");
		    	 String dname = rs.getString("dname");
		    	 String location = rs.getString("location");
		    	 
		    	 dept = new Department(id,dname,location);
		    	 
		     }else {
		    	 throw new AdminException("Department Does Not Exist With This Id");
		     }
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage()); 
		}
		
		
		
		return dept;
	}

	@Override
	public String updateDepartMent(Department department) throws AdminException {
		String message  = "Department not updated";
		
		try(Connection conn = DaoUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update department set dname = ?, location = ? where did = ? ");
			
			ps.setString(1, department.getDname());
			ps.setString(2, department.getLocation());
			ps.setInt(3, department.getDid());
			
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				
				message = "Department updated sucessfully...";
				
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage()); 
		}
		
		
		
		return message;
	}

	
	
	@Override
	public String updateEmployeeDepartment(int eid, int did) throws AdminException {
		
		String message = "Employee Department not updated...";
		
		try(Connection conn = DaoUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update employees set did = ? where eid = ?");
			
			ps.setInt(1, did);
			ps.setInt(2, eid);
			
			int x = ps.executeUpdate();
			

			if(x > 0) {
				
				message = "Employee Department updated sucessfully...";
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage()); 
		}
		
		
		return message;
	}

	@Override
	public String grantOrDenyLeave(String leave_status, int eid) throws AdminException {
		String message = "Leave Status Applied...";
		
            try(Connection conn = DaoUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update employees set leave_status = ? where eid = ?");
			
			ps.setString(1, leave_status);
			ps.setInt(2, eid);
			
			int x = ps.executeUpdate();
			

			if(x > 0) {
				
				message = "Employee Leave Status updated sucessfully...";
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new AdminException(e.getMessage()); 
		}
		
		
		
		
		return message;
	}

	@Override
	public Admin logInAdmin(String username, String password) throws AdminException {
		
		Admin ad = null;
		
		
		  try(Connection conn = DaoUtility.provideConnection()){
				
				PreparedStatement ps = conn.prepareStatement("select * from admin where username = ? AND password = ?");
		
				ps.setString(1, username);
				ps.setString(2, password);
		
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					
					String uname = rs.getString("username");
					String pass = rs.getString("password");
					
					ad = new Admin(uname,pass);
					
				}
				else {
					throw new AdminException("Invalid Username or Password");
					
				}
				}
		  
				catch(SQLException e) {
					e.printStackTrace();
					throw new AdminException(e.getMessage()); 
				}
		
		         return ad;
		
	}
	
	
}
