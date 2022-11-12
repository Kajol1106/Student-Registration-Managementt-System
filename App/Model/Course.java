package com.Model;

public class Course {
	private int cid;
	private String cname;
	private long courseFee;
	private String cDuration;
	private String cStartDate;
	private int totalSeat;
	private int availableSeat;
	
	public Course() {
		
	}

	public Course(int cid, String cname, long courseFee, String cDuration, String cStartDate) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.courseFee = courseFee;
		this.cDuration = cDuration;
		this.cStartDate = cStartDate;
		this.totalSeat = totalSeat;
		this.availableSeat = availableSeat;
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

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public int getAvailableSeat() {
		return availableSeat;
	}

	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", courseFee=" + courseFee + ", cDuration=" + cDuration
				+ ", cStartDate=" + cStartDate + ", totalSeat=" + totalSeat + ", availableSeat=" + availableSeat + "]";
	}
	
}
