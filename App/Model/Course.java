package com.Model;

public class Course {
	private int cid;
	private String cname;
	private long courseFee;
	private String cDuration;
	private String cStart;
	private int totalSeat;
	private int availableSeat;


	public Course(int cid, String cname, long courseFee, String cDuration, String cStart, int totalSeat,
			int availableSeat) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.courseFee = courseFee;
		this.cDuration = cDuration;
		this.cStart = cStart;
		this.totalSeat = totalSeat;
		this.availableSeat = availableSeat;
	}
	
	public Course(String cname, long courseFee, String cDuration, String cStart, int totalSeat,
			int availableSeat) {
		super();
		this.cname = cname;
		this.courseFee = courseFee;
		this.cDuration = cDuration;
		this.cStart = cStart;
		this.totalSeat = totalSeat;
		this.availableSeat = availableSeat;
	}
	
	public Course(int cid, String cname, long courseFee, String cDuration, String cStart, int totalSeat) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.courseFee = courseFee;
		this.cDuration = cDuration;
		this.cStart = cStart;
		this.totalSeat = totalSeat;
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
	
	public String getcStart() {
		return cDuration;
	}

	public void setcStart(String cDuration) {
		this.cDuration = cDuration;
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
				+ ", cStart=" + cStart +", totalSeat=" + totalSeat + ", availableSeat=" + availableSeat + "]";
	}

	
}
