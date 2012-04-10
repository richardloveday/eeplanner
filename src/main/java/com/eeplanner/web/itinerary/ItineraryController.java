package com.eeplanner.web.itinerary;

import com.eeplanner.dao.flight.FlightDao;
import com.eeplanner.dao.itinerary.ItineraryDao;
import com.eeplanner.dao.staff.StaffDao;
import com.eeplanner.dao.transfer.TransferDao;
import com.eeplanner.datastructures.*;
import com.eeplanner.web.EEPlannerSimpleFormController;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: charlesivie
 * Date: 06/05/11
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 */

public class ItineraryController extends EEPlannerSimpleFormController{


	Logger log = Logger.getLogger(ItineraryController.class);

    private ItineraryDao itineraryDao;
    private TransferDao transferDao;
    private FlightDao flightDao;
    private StaffDao staffDao;

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {

        log.fatal("submit clicked");

        Itinerary itinerary = (Itinerary)command;

        itinerary = itineraryDao.storeItinerary(itinerary);

        ModelAndView mav = new ModelAndView(getSuccessView());

        if(itinerary.getID()>0){
            mav.addObject("itinerary", itinerary);
        }

        return mav;
    }

    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        // get the itinerary if it exists, if not doesnt matetr
        int year = ServletRequestUtils.getIntParameter(request, "year", new DateTime().getYear());
        int campID = ServletRequestUtils.getIntParameter(request, "campID", 0);
        int staffMemberID = ServletRequestUtils.getIntParameter(request, "staffMemberID", 0);
        int id = ServletRequestUtils.getIntParameter(request, "id", 0);

        Itinerary itinerary = null;

        if(id>0){
            itinerary = itineraryDao.getItineraryByID(id);
            itinerary.setStaffMember(staffDao.getStaffMemberByID(itinerary.getStaffID()));
        } else {
        	itinerary = itineraryDao.getItineraryByCampAndStaffID(campID, staffMemberID);
        	if(itinerary!=null){
        		itinerary.setStaffMember(staffDao.getStaffMemberByID(itinerary.getStaffID()));
        	}
        }

        if(itinerary==null){
            itinerary = new Itinerary();
            itinerary.setStaffID(staffMemberID);
            itinerary.setStaffMember(staffDao.getStaffMemberByID(staffMemberID));
            itinerary.setCampID(campID);
            itinerary.setYear(year);
        }

        return itinerary;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        HashMap<String, Object> model = new HashMap<String, Object>();

        int year = ServletRequestUtils.getIntParameter(request, "year", new DateTime().getYear());

        List<Flight> flights = flightDao.getFlightListByYear("destination asc, outboundArrival desc", false, year);
        if(flights!=null) {
        	for(Flight flight: flights){
        		List<StaffMember> staffMembers = staffDao.getStaffMembersForFlight(flight, "secondName asc");
        		flight.setStaffMembers(staffMembers);
        	}
        }
        
        model.put("flights", flights);

        return model;
    }

    public void setItineraryDao(ItineraryDao itineraryDao) {
        this.itineraryDao = itineraryDao;
    }

    public void setTransferDao(TransferDao transferDao) {
        this.transferDao = transferDao;
    }

    public void setFlightDao(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }
}
