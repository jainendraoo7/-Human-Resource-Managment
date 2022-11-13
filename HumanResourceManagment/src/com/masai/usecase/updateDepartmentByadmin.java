package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.exception.AdminException;
import com.masai.model.Department;

public class updateDepartmentByadmin {

	       public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter Department Id :");
			int did  = sc.nextInt();
			
			System.out.print("Enter Department Name :");
			String dname  = sc.next();
			
			System.out.print("Enter Department Location :");
			String address  = sc.next();
			
			
			Department dept = new Department(did,dname,address);
	
			AdminDao dao = new AdminDaoImpl();
			
			
			try {
				String result = dao.updateDepartMent(dept);
				
				System.out.print(result);
		
			}catch(AdminException e) {
				System.out.print(e.getMessage());
			}
	
	       }
}