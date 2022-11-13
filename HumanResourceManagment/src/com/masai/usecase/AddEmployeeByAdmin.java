package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.exception.AdminException;
import com.masai.model.Employees;

public class AddEmployeeByAdmin {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Employee Id");
		int eid  = sc.nextInt();
		
		System.out.print("Enter Employee Name");
		String ename  = sc.next();
		
		System.out.print("Enter Employee Address");
		String address  = sc.next();
		
		System.out.print("Enter Employee Email");
		String email = sc.next();
		
		System.out.print("Enter Employee password");
		String password  = sc.next();
		
		System.out.print("Enter Employee Salary");
		int salary  = sc.nextInt();
		
		System.out.print("Enter Employee Department Id");
		int did  = sc.nextInt();
		
		System.out.print("Enter Employee RFL");
		String rfl  = sc.next();
		
		System.out.print("Enter Employee ls");
		String ls  = sc.next();
		
		
		Employees emp = new Employees(eid,ename,address,email,password,salary,did,rfl,ls);
		
		AdminDao dao = new AdminDaoImpl();
		
		
		try {
			String result = dao.AddEmployee(emp);
			
			System.out.print(result);
	
		}catch(AdminException e) {
			System.out.print(e.getMessage());
		}
		
		
		
	}
	
	
	
}
