package com.emp.model;


public class Employee {
	private long id; 
	private String full_name; 
	private String address; 
	private String email_id;
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail_id() {
		return email_id;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(long l, String full_name, String address, String email_id) {
		super();
		this.id = l;
		this.full_name = full_name;
		this.address = address;
		this.email_id = email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	
}
