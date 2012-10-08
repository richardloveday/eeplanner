package com.eeplanner.dao.flight;

import com.eeplanner.datastructures.Flight;

import java.util.List;

public interface FlightDao {
    public Flight getFlightByID(int id);
    public List<Flight> getFlightList(String orderBy, boolean showDeleted);
    public List<Flight> getFlightListByStaffMemberID(int staffMemberID, String orderBy);
    public Flight storeFlight(Flight flight);
    public List<Flight> getFlightsByCampID(int campID);
    public Flight getFlightByStaffMemberIDCampID(int staffMemberID, int campID);
    public boolean setDeleted(int id, boolean isDeleted);
    public List<Flight> getFlightListByYear(String orderBy, boolean showDeleted, int year);
	public boolean removeFlight(int id);
	public boolean removeAllFlights();
	public List<Flight> getFlightsByItineraryID(int itineraryID);
	public List<Flight> getFlightsByCampAndStaffID(int campID, int staffID);
}
