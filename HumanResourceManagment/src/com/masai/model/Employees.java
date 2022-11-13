package com.masai.model;

public class Employees {

	private int eid;
	private String ename;
	private String address;
	private String email;
	private String password;
	private int salary;
	private int did;
	private String request_for_Leave;
	private String leave_status;
	
	
	
	
	
	public int getEid() {
		return eid;
	}


	public void setEid(int eid) {
		this.eid = eid;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public int getDid() {
		return did;
	}


	public void setDid(int did) {
		this.did = did;
	}


	public String getRequest_for_Leave() {
		return request_for_Leave;
	}


	public void setRequest_for_Leave(String request_for_Leave) {
		this.request_for_Leave = request_for_Leave;
	}


	public String getLeave_status() {
		return leave_status;
	}


	public void setLeave_status(String leave_status) {
		this.leave_status = leave_status;
	}


	@Override
	public String toString() {
		return "Employees [eid=" + eid + ", ename=" + ename + ", address=" + address + ", email=" + email
				+ ", password=" + password + ", salary=" + salary + ", did=" + did + ", request_for_Leave="
				+ request_for_Leave + ", leave_status=" + leave_status + "]";
	}


	
	
	
	
	public Employees(){
		
	}
	
	
	public Employees(int eid, String ename, String address, String email, String password, int salary, int did,
			String request_for_Leave, String leave_status) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.address = address;
		this.email = email;
		this.password = password;
		this.salary = salary;
		this.did = did;
		this.request_for_Leave = request_for_Leave;
		this.leave_status = leave_status;
	}

	
	
	
	
	
}
