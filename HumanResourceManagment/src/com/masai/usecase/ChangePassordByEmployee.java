package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.EmployeeDao;
import com.masai.Dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;

public class ChangePassordByEmployee {

	 public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter Your Username :");
			String username  = sc.next();
			
			System.out.print("Enter Your New Password :");
			String newPass  = sc.next();
	

			EmployeeDao dao = new EmployeeDaoImpl();
			
			try {
			     		
				String result = dao.updateEmployeePassword(username, newPass);
				System.out.print(result);
			
			}catch(EmployeeException e) {
				
				System.out.print(e.getMessage());
			}
	
	 }
}
