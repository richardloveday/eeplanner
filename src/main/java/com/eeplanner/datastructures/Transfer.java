package com.eeplanner.datastructures;

import java.util.Date;
import java.util.List;

public class Transfer{

    private int ID;
    private String outboundType;
    private String outboundReference;
    private Date outboundDeparture;
    private String outboundDeparturePoint;
    private Date outboundArrival;
    private String outboundArrivalPoint;
    private String outboundNotes;

    private String returnType;
    private String returnReference;
    private Date returnDeparture;
    private String returnDeparturePoint;
    private Date returnArrival;
    private String returnArrivalPoint;
    private String returnNotes;
    private boolean deleted;

    private Itinerary itinerary;
    private int itineraryID;
    private List<Camp> camps;
    private Camp camp;
    private StaffMember staffMember;
    private int campID;
    private int staffMemberID;

    private String itemLabel;

    public String getItemLabel() {
        return "("+this.outboundType+") " + this.outboundDeparturePoint + " - " + this.outboundArrivalPoint + " " + this.outboundDeparture;
    }

    public void setItemLabel(String itemLabel) {
        this.itemLabel = itemLabel;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOutboundType() {
        return outboundType;
    }

    public void setOutboundType(String outboundType) {
        this.outboundType = outboundType;
    }

    public String getOutboundReference() {
        return outboundReference;
    }

    public void setOutboundReference(String outboundReference) {
        this.outboundReference = outboundReference;
    }

    public Date getOutboundDeparture() {
        return outboundDeparture;
    }

    public void setOutboundDeparture(Date outboundDeparture) {
        this.outboundDeparture = outboundDeparture;
    }

    public String getOutboundDeparturePoint() {
        return outboundDeparturePoint;
    }

    public void setOutboundDeparturePoint(String outboundDeparturePoint) {
        this.outboundDeparturePoint = outboundDeparturePoint;
    }

    public Date getOutboundArrival() {
        return outboundArrival;
    }

    public void setOutboundArrival(Date outboundArrival) {
        this.outboundArrival = outboundArrival;
    }

    public String getOutboundArrivalPoint() {
        return outboundArrivalPoint;
    }

    public void setOutboundArrivalPoint(String outboundArrivalPoint) {
        this.outboundArrivalPoint = outboundArrivalPoint;
    }

    public String getOutboundNotes() {
        return outboundNotes;
    }

    public void setOutboundNotes(String outboundNotes) {
        this.outboundNotes = outboundNotes;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getReturnReference() {
        return returnReference;
    }

    public void setReturnReference(String returnReference) {
        this.returnReference = returnReference;
    }

    public Date getReturnDeparture() {
        return returnDeparture;
    }

    public void setReturnDeparture(Date returnDeparture) {
        this.returnDeparture = returnDeparture;
    }

    public String getReturnDeparturePoint() {
        return returnDeparturePoint;
    }

    public void setReturnDeparturePoint(String returnDeparturePoint) {
        this.returnDeparturePoint = returnDeparturePoint;
    }

    public Date getReturnArrival() {
        return returnArrival;
    }

    public void setReturnArrival(Date returnArrival) {
        this.returnArrival = returnArrival;
    }

    public String getReturnArrivalPoint() {
        return returnArrivalPoint;
    }

    public void setReturnArrivalPoint(String returnArrivalPoint) {
        this.returnArrivalPoint = returnArrivalPoint;
    }

    public String getReturnNotes() {
        return returnNotes;
    }

    public void setReturnNotes(String returnNotes) {
        this.returnNotes = returnNotes;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }

    public int getItineraryID() {
        return itineraryID;
    }

    public void setItineraryID(int itineraryID) {
        this.itineraryID = itineraryID;
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

    public StaffMember getStaffMember() {
        return staffMember;
    }

    public void setStaffMember(StaffMember staffMember) {
        this.staffMember = staffMember;
    }

    public int getCampID() {
        return campID;
    }

    public void setCampID(int campID) {
        this.campID = campID;
    }

    public int getStaffMemberID() {
        return staffMemberID;
    }

    public void setStaffMemberID(int staffMemberID) {
        this.staffMemberID = staffMemberID;
    }
}
