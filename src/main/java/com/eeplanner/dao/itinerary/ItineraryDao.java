package com.eeplanner.dao.itinerary;

import java.util.List;

import com.eeplanner.datastructures.Itinerary;
import com.eeplanner.datastructures.Flight;
import com.eeplanner.datastructures.Transfer;
public interface ItineraryDao {

	public Itinerary getItineraryByID(int id);
	public Itinerary storeItinerary(Itinerary itinerary);
	public boolean setDeleted(int id, boolean isDeleted);
}
