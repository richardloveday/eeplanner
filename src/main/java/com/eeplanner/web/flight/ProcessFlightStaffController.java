package com.eeplanner.web.flight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.eeplanner.dao.flight.FlightDao;

public class ProcessFlightStaffController extends MultiActionController {

    private FlightDao flightDao;

    public void setFlightDao(FlightDao flightDao) {
		this.flightDao = flightDao;
	}

	public ModelAndView addStaffMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int flightID = 0;
        if (ServletRequestUtils.getIntParameter(request, "staffMemberID") != null) {
            int staffMemberID = ServletRequestUtils.getIntParameter(request, "staffMemberID");
            flightID = ServletRequestUtils.getIntParameter(request, "flightID");
            flightDao.addFlightStaffMember(flightID, staffMemberID);
        }
        return new ModelAndView("redirect:/flight.htm?id="+flightID);
    }

    public ModelAndView removeStaffMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int flightID = 0;
        if (ServletRequestUtils.getIntParameter(request, "staffMemberID") != null) {
            int staffMemberID = ServletRequestUtils.getIntParameter(request, "staffMemberID");
            flightID = ServletRequestUtils.getIntParameter(request, "flightID");
            flightDao.removeFlightStaffMember(flightID, staffMemberID);
        }
        return new ModelAndView("redirect:/flight.htm?id="+flightID);
    }
    
    public ModelAndView editStaffMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int flightID = 0;
        if (ServletRequestUtils.getIntParameter(request, "staffMemberID") != null) {
            int staffMemberID = ServletRequestUtils.getIntParameter(request, "staffMemberID");
            flightID = ServletRequestUtils.getIntParameter(request, "flightID");
            boolean infoSent = false;
            if(request.getParameter("infoSent")!=null) infoSent = true;
            boolean transferNeeded = false;
            if(request.getParameter("transferNeeded")!=null) transferNeeded = true;
            flightDao.editFlightStaffMember(flightID, staffMemberID, infoSent, transferNeeded);
        }
        return new ModelAndView("redirect:/flight.htm?id="+flightID);
    }

}
