package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.EmployeeDao;
import com.masai.Dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;
import com.masai.model.Employees;

public class updateEmployeeProfile {


	 public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter Your Id :");
			int eid  = sc.nextInt();
			
			System.out.print("Enter Your Name :");
			String newName  = sc.next();
			
			System.out.print("Enter Your Address :");
			String newAddress = sc.next();
	
			System.out.print("Enter Your Email :");
			String newEmail  = sc.next();


			
			
			EmployeeDao dao = new EmployeeDaoImpl();
			
			try {
			     		
				String result = dao.updateProfileById(eid, newName, newAddress, newEmail);
				System.out.print(result);
			
			}catch(EmployeeException e) {
				
				System.out.print(e.getMessage());
			}
	 }
}
