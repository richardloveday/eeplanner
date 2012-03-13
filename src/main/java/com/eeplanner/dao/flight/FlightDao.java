package com.eeplanner.dao.flight;

import com.eeplanner.datastructures.Flight;
import com.eeplanner.datastructures.Transfer;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 15-Jan-2010
 * Time: 14:29:07
 * To change this template use File | Settings | File Templates.
 */
public interface FlightDao {
    public Flight getFlightByID(int id);
    public List<Flight> getFlightList(String orderBy, boolean showDeleted);
    public List<Flight> getFlightListByStaffMemberID(int staffMemberID, String orderBy);
    public Flight storeFlight(Flight flight);
    public List<Flight> getFlightsByCampID(int campID);
    public Flight getFlightByStaffMemberIDCampID(int staffMemberID, int campID);
    public boolean setDeleted(int id, boolean isDeleted);
    public boolean addFlightStaffMember(int flightID, int staffMemberID);
    public boolean removeFlightStaffMember(int flightID, int staffMemberID);
    public boolean addFlightCamp(int flightID, int campID);
    public boolean removeFlightCamp(int flightID, int campID);
    public List<Flight> getFlightListByYear(String orderBy, boolean showDeleted, int year);
	public boolean removeFlight(int id);
	public boolean removeAllFlights();
	public List<Flight> getFlightsByItineraryID(int itineraryID);
	public List<Flight> getFlightsByCampAndStaffID(int campID, int staffID);
}
