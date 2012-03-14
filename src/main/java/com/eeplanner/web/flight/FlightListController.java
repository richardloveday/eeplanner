package com.eeplanner.web.flight;

import org.joda.time.DateTime;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eeplanner.dao.flight.FlightDao;
import com.eeplanner.dao.staff.StaffDao;
import com.eeplanner.datastructures.Flight;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 15-Jan-2010
 * Time: 16:18:13
 * To change this template use File | Settings | File Templates.
 */
public class FlightListController extends AbstractController{


    Logger log  = Logger.getLogger(FlightListController.class);
    private FlightDao flightDao;
    private StaffDao staffDao;
    private String viewName;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		boolean showDeleted = ServletRequestUtils.getBooleanParameter(request, "showDeleted", false);
        int theYear = ServletRequestUtils.getIntParameter(request, "showYear",new DateTime().getYear());
        
		List<Flight> flights = flightDao.getFlightListByYear("destination asc, outboundArrival desc", showDeleted, theYear);
		if (!CollectionUtils.isEmpty(flights)) {
			for (Flight flight : flights) {
				flight.setStaffMembers(staffDao.getStaffMembersForFlight(
						flight, "secondName asc"));
			}
		}
		mav.addObject("flights", flights);
		mav.addObject("theYear", theYear);
		mav.addObject("showDeleted", showDeleted);
		
		return mav;
    }

    public void setFlightDao(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

}
