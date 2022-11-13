package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.EmployeeDao;
import com.masai.Dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;

public class askForLeaveByEd {

	 public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter Your Employee Id :");
			int eid = sc.nextInt();
			
			System.out.print("Enter Your Leave Request :");
			String lr  = sc.next();
	

			EmployeeDao dao = new EmployeeDaoImpl();
			
			try {			     		
				String result = dao.askForLeaveByEid(eid, lr);
				System.out.print(result);
			
			}catch(EmployeeException e) {
				
				System.out.print(e.getMessage());
			}
	
	 }
	
	
	
}
