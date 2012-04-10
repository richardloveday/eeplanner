package com.eeplanner.web.flight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.eeplanner.dao.flight.FlightDao;
import com.eeplanner.dao.itinerary.ItineraryDao;
import com.eeplanner.datastructures.Itinerary;

public class ProcessFlightStaffController extends MultiActionController {

    private FlightDao flightDao;
    private ItineraryDao itineraryDao;

    public void setFlightDao(FlightDao flightDao) {
		this.flightDao = flightDao;
	}
    
    public void setItineraryDao(ItineraryDao itineraryDao) {
		this.itineraryDao = itineraryDao;
	}

	public ModelAndView removeStaffMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int flightID = 0;
        if (ServletRequestUtils.getIntParameter(request, "staffMemberID") != null) {
            int staffMemberID = ServletRequestUtils.getIntParameter(request, "staffMemberID");
            flightID = ServletRequestUtils.getIntParameter(request, "flightID");
            
            Itinerary itinerary = itineraryDao.getItineraryByFlightAndStaffID(flightID, staffMemberID);
            if(itinerary!=null) {
            	itineraryDao.delete(itinerary.getID());
            }
        }
        return new ModelAndView("redirect:/flight.htm?id="+flightID);
    }
    
}
