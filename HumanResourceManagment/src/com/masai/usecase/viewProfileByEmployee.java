package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.EmployeeDao;
import com.masai.Dao.EmployeeDaoImpl;
import com.masai.exception.EmployeeException;
import com.masai.model.Employees;

public class viewProfileByEmployee {
	
	 public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter Department Id :");
			int eid  = sc.nextInt();
			
			EmployeeDao dao = new EmployeeDaoImpl();
			
			try {
			     		
				Employees emp = dao.viewEmployeeProfileById(eid);
				System.out.print(emp.toString());
			
			}catch(EmployeeException e) {
				
				System.out.print(e.getMessage());
			}
			

	 
	 }
}