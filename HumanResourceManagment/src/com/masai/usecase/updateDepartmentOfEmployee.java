package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.exception.AdminException;

public class updateDepartmentOfEmployee {

	 public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter Employee Id :");
			int eid  = sc.nextInt();
			
			System.out.print("Enter Department Id :");
			int did  = sc.nextInt();
			
			
			AdminDao dao = new AdminDaoImpl();
			
			try {
				String result = dao.updateEmployeeDepartment(eid, did);
				
				System.out.print(result);
		
			}catch(AdminException e) {
				System.out.print(e.getMessage());
			}
	
}

}