package com.eeplanner.web.flight;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.eeplanner.dao.flight.FlightDao;

public class ProcessFlightCampController  extends MultiActionController {
	
	   private FlightDao flightDao;

	    public void setFlightDao(FlightDao flightDao) {
			this.flightDao = flightDao;
		}

		
	    
}
