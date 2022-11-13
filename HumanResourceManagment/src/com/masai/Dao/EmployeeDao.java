package com.masai.Dao;

import com.masai.exception.EmployeeException;
import com.masai.model.Employees;

public interface EmployeeDao {
	
	
	public Employees logInEmployee(String email, String password)throws EmployeeException; 
	
	public Employees viewEmployeeProfileById(int eid)throws EmployeeException;
	
	public String updateProfileById(int eid,String ename,String address,String email)throws EmployeeException;
	
	public String updateEmployeePassword(String email,String password)throws EmployeeException;
	
	public String askForLeaveByEid(int eid, String leave_request)throws EmployeeException;
	
	

}
