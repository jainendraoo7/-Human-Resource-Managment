package com.masai.Dao;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.model.Department;
import com.masai.model.Employees;

public interface AdminDao {

	public Admin logInAdmin(String username,String password)throws AdminException; 
	
	public String AddEmployee(Employees employee)throws AdminException;
	
	public String AddDepartment(Department department)throws AdminException;
	
	public Department viewDepartmentByDid(int did)throws AdminException;
	
	public String updateDepartMent(Department department)throws AdminException;
	
	public String updateEmployeeDepartment(int eid,int did)throws AdminException;
	
	public String grantOrDenyLeave(String leave_status, int eid)throws AdminException;
	
	
	
	
}
