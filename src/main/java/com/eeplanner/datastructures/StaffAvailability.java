package com.eeplanner.datastructures;

public class StaffAvailability {
    
	private int staffID;
    private int year;
    private boolean available1;
    private boolean available2;
    private boolean available3;
    private boolean available4;
    private boolean available5;
    private boolean available6;
    private boolean available7;
    private String note;
	
    public StaffAvailability() {
		super();
	}
    
	public StaffAvailability(int year, boolean available1, boolean available2,
			boolean available3, boolean available4, boolean available5,
			boolean available6, boolean available7, String note) {
		super();
		this.year = year;
		this.available1 = available1;
		this.available2 = available2;
		this.available3 = available3;
		this.available4 = available4;
		this.available5 = available5;
		this.available6 = available6;
		this.available7 = available7;
		this.note = note;
	}



	public StaffAvailability(int staffID, int year, boolean available1,
			boolean available2, boolean available3, boolean available4,
			boolean available5, boolean available6, boolean available7, String note) {
		super();
		this.staffID = staffID;
		this.year = year;
		this.available1 = available1;
		this.available2 = available2;
		this.available3 = available3;
		this.available4 = available4;
		this.available5 = available5;
		this.available6 = available6;
		this.available7 = available7;
		this.note = note;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setID(int staffID) {
		this.staffID = staffID;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isAvailable1() {
		return available1;
	}

	public void setAvailable1(boolean available1) {
		this.available1 = available1;
	}

	public boolean isAvailable2() {
		return available2;
	}

	public void setAvailable2(boolean available2) {
		this.available2 = available2;
	}

	public boolean isAvailable3() {
		return available3;
	}

	public void setAvailable3(boolean available3) {
		this.available3 = available3;
	}

	public boolean isAvailable4() {
		return available4;
	}

	public void setAvailable4(boolean available4) {
		this.available4 = available4;
	}

	public boolean isAvailable5() {
		return available5;
	}

	public void setAvailable5(boolean available5) {
		this.available5 = available5;
	}

	public boolean isAvailable6() {
		return available6;
	}

	public void setAvailable6(boolean available6) {
		this.available6 = available6;
	}

	public boolean isAvailable7() {
		return available7;
	}

	public void setAvailable7(boolean available7) {
		this.available7 = available7;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}    
	
}