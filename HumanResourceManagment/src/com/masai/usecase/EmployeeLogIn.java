package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.Dao.EmployeeDao;
import com.masai.Dao.EmployeeDaoImpl;
import com.masai.exception.AdminException;
import com.masai.exception.EmployeeException;
import com.masai.model.Admin;
import com.masai.model.Employees;

public class EmployeeLogIn {

public static boolean main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Employee Username :");
		String username  = sc.next();
		
		System.out.print("Enter Employee Password :");
		String pass  = sc.next();
	
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		boolean flag = false;
		
		try {
			
			Employees emp = dao.logInEmployee(username, pass);
			
			System.out.println("Welcome :"+username);
			
			if(emp.getEmail().equals(username) && emp.getPassword().equals(pass)) {
				flag = true;
			}
			
		}catch(EmployeeException e) {
			System.out.print(e.getMessage());
		}
		
		
		return flag;
		
}
	
	
}
