package com.eeplanner.datastructures;

import java.util.Date;

public class CampStaff {

	private int staffID;
	private int campID;
	private boolean accepted;
	private boolean offered;
	private boolean returned;
	private String job;
	private Date contractDate;

	public CampStaff() {
	}



	public CampStaff(int staffID, int campID, boolean offered,
			boolean accepted, boolean returned, String job) {
		this.staffID = staffID;
		this.campID = campID;
		this.offered = offered;
		this.accepted = accepted;
		this.returned = returned;
		this.job = job;
	}



	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public int getCampID() {
		return campID;
	}
	public void setCampID(int campID) {
		this.campID = campID;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public boolean isOffered() {
		return offered;
	}
	public void setOffered(boolean offered) {
		this.offered = offered;
	}
	public boolean isReturned() {
		return returned;
	}
	public void setReturned(boolean returned) {
		this.returned = returned;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getContractDate() {
		return contractDate;
	}
	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

}
