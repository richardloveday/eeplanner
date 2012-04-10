package com.eeplanner.datastructures;

import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 15-Jan-2010
 * Time: 14:13:39
 * To change this template use File | Settings | File Templates.
 */
public class Flight {

    private int ID;
    private String carrier;
    private String type;
    private String flightNumber;
    private String returnFlightNumber;
    private String destination;
    private int numberOfSeats;
    private String airport;    
    private Date outboundArrival;
    private Date outboundDeparture;
    private Date returnArrival;
    private Date returnDeparture;    
    private BigDecimal cost;
    private boolean deleted;
    private List<Camp> camps;
    private Camp camp;
    private int campID;
    private String itemLabel;
    private String notes;

    public String getItemLabel() {
        return  "("+this.type + ") " + this.destination + " - " + this.outboundDeparture;
    }

    public Flight() {
    }

    public Flight(boolean transferRequired, String carrier, String type, String flightNumber, String destination, int campID, Date arrival, Date departure, BigDecimal cost) {

        this.carrier = carrier;
        this.type = type;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.campID = campID;
        this.cost = cost;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Camp> getCamps() {
        return camps;
    }

    public void setCamps(List<Camp> camps) {
        this.camps = camps;
    }

    public Camp getCamp() {
        return camp;
    }

    public void setCamp(Camp camp) {
        this.camp = camp;
    }

    public int getCampID() {
        return campID;
    }

    public void setCampID(int campID) {
        this.campID = campID;
    }

	private List<StaffMember> staffMembers;

       
    public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getAirport() {
		return airport;
	}

	public void setAirport(String airport) {
		this.airport = airport;
	}

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}


    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

	public List<StaffMember> getStaffMembers() {
		return staffMembers;
	}

	public void setStaffMembers(List<StaffMember> staffMembers) {
		this.staffMembers = staffMembers;
	}

    public Date getOutboundArrival() {
        return outboundArrival;
    }

    public void setOutboundArrival(Date outboundArrival) {
        this.outboundArrival = outboundArrival;
    }

    public Date getOutboundDeparture() {
        return outboundDeparture;
    }

    public void setOutboundDeparture(Date outboundDeparture) {
        this.outboundDeparture = outboundDeparture;
    }

    public Date getReturnArrival() {
        return returnArrival;
    }

    public void setReturnArrival(Date returnArrival) {
        this.returnArrival = returnArrival;
    }

    public Date getReturnDeparture() {
        return returnDeparture;
    }

    public void setReturnDeparture(Date returnDeparture) {
        this.returnDeparture = returnDeparture;
    }

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getReturnFlightNumber() {
		return returnFlightNumber;
	}

	public void setReturnFlightNumber(String returnFlightNumber) {
		this.returnFlightNumber = returnFlightNumber;
	}
	
}
