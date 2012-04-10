package com.eeplanner.dao.itinerary;

import com.eeplanner.datastructures.Itinerary;
public interface ItineraryDao {

	public Itinerary getItineraryByID(int id);
	public Itinerary storeItinerary(Itinerary itinerary);
	public boolean setDeleted(int id, boolean isDeleted);
	public Itinerary getItineraryByCampAndStaffID(int campID, int staffMemberID);
	public Itinerary getItineraryByFlightAndStaffID(int flightID, int staffMemberID);
	public boolean delete(int id);
}
