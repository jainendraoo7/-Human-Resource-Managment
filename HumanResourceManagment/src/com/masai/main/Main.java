package com.masai.main;

import java.util.Scanner;

import com.masai.usecase.AddEmployeeByAdmin;
import com.masai.usecase.AdminLogIn;
import com.masai.usecase.ChangePassordByEmployee;
import com.masai.usecase.EmployeeLogIn;
import com.masai.usecase.addDepartmentByAdmin;
import com.masai.usecase.askForLeaveByEd;
import com.masai.usecase.grantOrDenyLeaveOfEmployee;
import com.masai.usecase.updateDepartmentByadmin;
import com.masai.usecase.updateDepartmentOfEmployee;
import com.masai.usecase.updateEmployeeProfile;
import com.masai.usecase.viewDepartmentByAdmin;
import com.masai.usecase.viewProfileByEmployee;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("--------------Welome-To-Human-Resourse-Managment------------");
		
		while(true) {
			
			System.out.println(" ");
			System.out.println("1. Login as Admin ");
			System.out.println("2. Login as Employee");
			System.out.println("3. Exit Application");
			System.out.println(" ");
			System.out.println("Enter a number 1 or 2 or 3");
			
			int login = 0;
			
			
			try {
				login = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Enter an integer value");
				break;
			}
			
			
			if(login==1) {
				
				AdminLogIn adminLog = new AdminLogIn();
				
				boolean adminIn = false;
				
				if(adminLog.main(args)) {
					
					adminIn = true;
					
				}else {
					adminIn = false;
				}
				
				
				while(adminIn) {
					System.out.print(" ");
					System.out.println("1. Add Department :");
					System.out.println("2. Update Department :");
					System.out.println("3. Add Employee :");
					System.out.println("4. View Department :");
					System.out.println("5. Update Employee Department :");
					System.out.println("6. Grant Or Deny Leave :");
					System.out.println("7. Logout");
					System.out.print(" ");
					System.out.print("Enter Your Choice");
					int choice = sc.nextInt();
					
					
					
					switch(choice) {
				    
					case 1: {
						addDepartmentByAdmin ad = new addDepartmentByAdmin();
						ad.main(args);
						break;
						
					}
					
					case 2:{
						updateDepartmentByadmin updateDepartment = new updateDepartmentByadmin();
						updateDepartment.main(args);
						break;
					}
					
					case 3:{
						
						AddEmployeeByAdmin addEmployee = new AddEmployeeByAdmin();
						addEmployee.main(args);
						break;
						
					}
					

					case 4:{
						
					    viewDepartmentByAdmin viewDepartment = new viewDepartmentByAdmin();
					    viewDepartment.main(args);
						break;
					}
					
					
					case 5:{
						
						updateDepartmentOfEmployee updateDeptEmp = new updateDepartmentOfEmployee();
						updateDeptEmp.main(args);
						break;
					}
					
					case 6:{
						
						grantOrDenyLeaveOfEmployee gOrD = new grantOrDenyLeaveOfEmployee();
						gOrD.main(args);
						break;
						
					}
					
					
					case 7:{
						
						System.out.print("Admin Succesfully Logout");
						adminIn = false;
						break;
					}
					
					default:
					{
						System.out.println("Admin Successfully Logged Out");
						adminIn = false;
						break;
					}
				
				}
				}
				
			}
			
			
			
			
			
			
			if(login==2) {
				
				EmployeeLogIn empLogIn = new EmployeeLogIn();
				
				boolean empIn = false;
				
                   if(empLogIn.main(args)) {
					
					empIn = true;
					
				}else {
					empIn = false;
				}
                   
                   

   				while(empIn) {
   					System.out.print(" ");
   					System.out.println("1. View Your Profile :");
   					System.out.println("2. Update Your Profile :");
   					System.out.println("3. Update Your Password :");
   					System.out.println("4. Permission For Leave :");
   					System.out.println("5. Logout");
   					System.out.print(" ");
   					System.out.print("Enter Your Choice");
   					int choice = sc.nextInt();
   					
   					
   					switch(choice) {
   				    
   					case 1: {
   						
   						viewProfileByEmployee viewProfile = new viewProfileByEmployee();
   						viewProfile.main(args);
   						break;
   						
   					}
   					
   					case 2:{
   						
   						updateEmployeeProfile updateProfile = new updateEmployeeProfile();
   						updateProfile.main(args);
   						break;
   						
   					}
   					
   					
   					case 3:{
   						
   						ChangePassordByEmployee changePass = new ChangePassordByEmployee();
   						changePass.main(args);
   						break;
   						
   					}
   					

   					case 4:{
   						
   					   askForLeaveByEd ask = new askForLeaveByEd();
   					   ask.main(args);
   						break;
   					}
   					
   					case 5:{
   						
   						System.out.print("Admin Succesfully Logout");
   						empIn = false;
   						break;
   					}
   					
   					default:
   					{
   						System.out.println("Admin Successfully Logged Out");
   						empIn = false;
   						break;
   					}
   				
   				}
   				}
                   
                   
				
			}
			
			
			if(login == 3) {
				System.out.println("Thank you for using our application");
				break;
			}
			if(login != 1 && login != 2 && login != 3) {
				System.out.println("Wrong Choice, Please select 1 or 2 or 3 only");
			}
		}
		
		
	}
	
}
