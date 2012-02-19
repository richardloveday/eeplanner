package com.eeplanner.datastructures;

import java.util.LinkedList;

public class Itinerary {
	
	private int ID;
	private String name;
	private StaffMember staffMember;
    private int year;
	private int staffID;
    private int campID;
    private int transfer1ID;
    private int transfer2ID;
    private int flightID;
    private boolean deleted;
    private Flight flight;
    private Transfer transfer1;
    private Transfer transfer2;

    public Itinerary() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StaffMember getStaffMember() {
        return staffMember;
    }

    public void setStaffMember(StaffMember staffMember) {
        this.staffMember = staffMember;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public int getTransfer1ID() {
        return transfer1ID;
    }

    public void setTransfer1ID(int transfer1ID) {
        this.transfer1ID = transfer1ID;
    }

    public int getTransfer2ID() {
        return transfer2ID;
    }

    public void setTransfer2ID(int transfer2ID) {
        this.transfer2ID = transfer2ID;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Transfer getTransfer1() {
        return transfer1;
    }

    public void setTransfer1(Transfer transfer1) {
        this.transfer1 = transfer1;
    }

    public Transfer getTransfer2() {
        return transfer2;
    }

    public void setTransfer2(Transfer transfer2) {
        this.transfer2 = transfer2;
    }

    public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean getDeleted() {
		return deleted;
	}
	
}
