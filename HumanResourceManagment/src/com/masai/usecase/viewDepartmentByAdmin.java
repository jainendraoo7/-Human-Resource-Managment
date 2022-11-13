package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.exception.AdminException;
import com.masai.model.Department;

public class viewDepartmentByAdmin {

	
	 public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Department Id :");
	        int id = sc.nextInt();
	        
	        AdminDao dao = new AdminDaoImpl();
	        
	        try {
	        	
	        	Department dept = dao.viewDepartmentByDid(id);
	        	
	        	System.out.println(dept.toString());
	        	
	        	
	        }catch(AdminException e){
	        	System.out.println(e.getMessage());
	        	
	        }
	
}
}