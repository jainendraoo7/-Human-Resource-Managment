package com.masai.usecase;

import java.util.Scanner;

import com.masai.Dao.AdminDao;
import com.masai.Dao.AdminDaoImpl;
import com.masai.exception.AdminException;
import com.masai.model.Admin;

public class AdminLogIn {

public static boolean main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Admin Username :");
		String username  = sc.next();
		
		System.out.print("Enter Admin Password :");
		String pass  = sc.next();
	
		
		AdminDao dao = new AdminDaoImpl();
		
		boolean flag = false;
		
		try {
			
			Admin ad = dao.logInAdmin(username, pass);
			
			System.out.println("Welcome :"+username);
			
			if(ad.getUsername().equals(username) && ad.getPassword().equals(pass)) {
				flag = true;
			}
			
		}catch(AdminException e) {
			System.out.print(e.getMessage());
		}
		
		
		return flag;
		
}
}
