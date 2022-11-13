package com.masai.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.exception.AdminException;
import com.masai.exception.EmployeeException;
import com.masai.model.Admin;
import com.masai.model.Department;
import com.masai.model.Employees;
import com.masai.utility.DaoUtility;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public Employees viewEmployeeProfileById(int eid) throws EmployeeException {
		Employees emp = null;

            try(Connection conn = DaoUtility.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from employees where eid = ?");
			
		     ps.setInt(1, eid);
			
		     ResultSet rs = ps.executeQuery();
		     
		     if(rs.next()) {
		    	 
		    	 int id = rs.getInt("eid");
		    	 String dname = rs.getString("ename");
		    	 String location = rs.getString("address");
		    	 String email = rs.getString("email");
		    	 String password = rs.getString("password");
		    	 int salary = rs.getInt("salary");
		    	 int did  = rs.getInt("did");
		    	 String rl = rs.getString("request_for_Leave");
		    	 String rls = rs.getString("leave_status");
		    	 
		    	 
		    	 emp = new Employees(id,dname,location,email,password,salary,did,rl,rls);
		    	 
		     }else {
		    	 throw new EmployeeException("Employee Does Not Exist With This Id");
		     }
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new EmployeeException(e.getMessage()); 
		}
		
		
		
		
		
		return emp;
	}

	@Override
	public String updateProfileById(int eid,String ename,String address,String email) throws EmployeeException {
		String message = "Profile not updated...";
		
		   try(Connection conn = DaoUtility.provideConnection()){
			   
			   PreparedStatement ps = conn.prepareStatement("update employees set ename = ?,address = ?,email = ? where eid = ?");
				
			   ps.setString(1, ename);
			   ps.setString(2, address);
			   ps.setString(3, email);
			   ps.setInt(4, eid);
			   
			   int x = ps.executeUpdate();
			   
			   if(x > 0) {
				   
				   message = "Profile updated sussecfully...";
				   
			   }
			   
			   
			   
		   }catch(SQLException e) {
				e.printStackTrace();
				throw new EmployeeException(e.getMessage()); 
			}
		
		
		
		return message;
	}

	@Override
	public String updateEmployeePassword(String email, String password) throws EmployeeException {
		
		String message  ="Password not updated...";

		   try(Connection conn = DaoUtility.provideConnection()){
			   
			   PreparedStatement ps = conn.prepareStatement("update employees set password= ? where email = ?");
				
			   ps.setString(1, password);
		       ps.setString(2, email);
			   
		       
			   int x = ps.executeUpdate();
			   
			   if(x > 0) {
				   
				   message = "Password updated sucssesfully...";
				   
			   }
			   
			   
			   
		   }catch(SQLException e) {
				e.printStackTrace();
				throw new EmployeeException(e.getMessage()); 
			}
		
		return message;
	}

	@Override
	public String askForLeaveByEid(int eid, String leave_request) throws EmployeeException {
		String message = "Leave request not applied....";
		
		
		  try(Connection conn = DaoUtility.provideConnection()){
			   
			   PreparedStatement ps = conn.prepareStatement("update employees set request_for_Leave = ? where eid = ?");
				
			   ps.setString(1, leave_request);
		       ps.setInt(2, eid);
			   
		       
			   int x = ps.executeUpdate();
			   
			   if(x > 0) {
				   
				   message = "Leave request applied....";
				   
			   }
			   
		   }catch(SQLException e) {
				e.printStackTrace();
				throw new EmployeeException(e.getMessage()); 
			}
		
		
		
		
		
		return message;
	}

	@Override
	public Employees logInEmployee(String email, String password) throws EmployeeException {
		
		Employees emp = null;
		

		  try(Connection conn = DaoUtility.provideConnection()){
				
				PreparedStatement ps = conn.prepareStatement("select * from employees where email = ? AND password = ?");
		
				ps.setString(1, email);
				ps.setString(2, password);
		
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					
					int eid = rs.getInt("eid");
					String ename = rs.getString("ename");
					String address = rs.getString("address");		
					String user = rs.getString("email");
					String pass = rs.getString("password");
					int salary = rs.getInt("salary");
					int did = rs.getInt("did");
					String rl = rs.getString("request_for_Leave");
					String ls = rs.getString("leave_status");
					
					emp = new Employees(eid,ename,address,user,pass,salary,did,rl,ls);
					
				}
				else {
					throw new EmployeeException("Invalid Username or Password");
					
				}
				}
		  
				catch(SQLException e) {
					e.printStackTrace();
					throw new EmployeeException(e.getMessage()); 
				}
		
		  
		return emp;
	}

	
	
	
	
	
}
