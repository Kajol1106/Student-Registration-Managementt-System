package com.Model;

public class Student {
	private int roll;
	private String name;
	private String email;
	private String password;
	private String mobile;
	private String address;
	private String batch;
	private String admissionDate;
	
	public Student() {
		
	}

	public Student(int roll, String name, String email, String password, String mobile, String address, String batch,
			String admissionDate) {
		super();
		this.roll = roll;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.batch = batch;
		this.admissionDate = admissionDate;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", email=" + email + ", password=" + password + ", mobile="
				+ mobile + ", address=" + address + ", batch=" + batch + ", admissionDate=" + admissionDate + "]";
	}
	
}
