package com.eeplanner.datastructures;

public class StaffMemberSearchData {

	private StaffMember staffMember;
	private Camp camp;
	private Flight flight;

    public StaffMemberSearchData() {
    }

	public StaffMember getStaffMember() {
		return staffMember;
	}
	public void setStaffMember(StaffMember staffMember) {
		this.staffMember = staffMember;
	}
	public Camp getCamp() {
		return camp;
	}
	public void setCamp(Camp camp) {
		this.camp = camp;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
