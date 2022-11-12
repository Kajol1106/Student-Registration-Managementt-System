package com.Model;

public class StudentCourseDTO {
	private int roll;
	private String name;
	private String email;
	private String password;
	private String mobile;
	private String address;
	private String batch;
	private String admissionDate;
	
	private int cid;
	private String cname;
	private long courseFee;
	private String cDuration;
	private String cStartDate;
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
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public long getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(long courseFee) {
		this.courseFee = courseFee;
	}
	public String getcDuration() {
		return cDuration;
	}
	public void setcDuration(String cDuration) {
		this.cDuration = cDuration;
	}
	public String getcStartDate() {
		return cStartDate;
	}
	public void setcStartDate(String cStartDate) {
		this.cStartDate = cStartDate;
	}
	@Override
	public String toString() {
		return "StudentCourseDTO [roll=" + roll + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", mobile=" + mobile + ", address=" + address + ", batch=" + batch + ", admissionDate="
				+ admissionDate + ", cid=" + cid + ", cname=" + cname + ", courseFee=" + courseFee + ", cDuration="
				+ cDuration + ", cStartDate=" + cStartDate + "]";
	}
	
}
