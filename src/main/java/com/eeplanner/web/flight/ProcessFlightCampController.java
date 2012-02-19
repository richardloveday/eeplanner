package com.eeplanner.web.flight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.eeplanner.dao.flight.FlightDao;

public class ProcessFlightCampController  extends MultiActionController {
	
	   private FlightDao flightDao;

	    public void setFlightDao(FlightDao flightDao) {
			this.flightDao = flightDao;
		}

		public ModelAndView addCamp(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        int flightID = 0;
	        if (ServletRequestUtils.getIntParameter(request, "campID") != null) {
	            int staffMemberID = ServletRequestUtils.getIntParameter(request, "campID");
	            flightID = ServletRequestUtils.getIntParameter(request, "flightID");
	            flightDao.addFlightCamp(flightID, staffMemberID);
	        }
	        return new ModelAndView("redirect:/flight.htm?id="+flightID);
	    }

	    public ModelAndView removeCamp(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        int flightID = 0;
	        if (ServletRequestUtils.getIntParameter(request, "campID") != null) {
	            int staffMemberID = ServletRequestUtils.getIntParameter(request, "campID");
	            flightID = ServletRequestUtils.getIntParameter(request, "flightID");
	            flightDao.removeFlightCamp(flightID, staffMemberID);
	        }
	        return new ModelAndView("redirect:/flight.htm?id="+flightID);
	    }
	    
	    public ModelAndView editCamp(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        int flightID = 0;
	        if (ServletRequestUtils.getIntParameter(request, "campID") != null) {
	            int campID = ServletRequestUtils.getIntParameter(request, "campID");
	            flightID = ServletRequestUtils.getIntParameter(request, "flightID");
	            boolean infoSent = false;
	            if(request.getParameter("infoSent")!=null) infoSent = true;
	            flightDao.editFlightCamp(flightID, campID);
	        }
	        return new ModelAndView("redirect:/flight.htm?id="+flightID);
	    }

}
