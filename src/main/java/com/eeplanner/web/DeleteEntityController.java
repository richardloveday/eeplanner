package com.eeplanner.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.eeplanner.dao.camp.CampDao;
import com.eeplanner.dao.flight.FlightDao;
import com.eeplanner.dao.itinerary.ItineraryDao;
import com.eeplanner.dao.staff.StaffDao;
import com.eeplanner.dao.transfer.TransferDao;


public class DeleteEntityController extends MultiActionController{

	private CampDao campDao;
    private FlightDao flightDao;
    private TransferDao transferDao;
    private StaffDao staffDao;
    private ItineraryDao itineraryDao;
    private String transferView;
    private String campView;
    private String flightView;
    private String staffMemberView;
    private String itineraryView;


    public ModelAndView restoreStaffMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = ServletRequestUtils.getIntParameter(request, "id");
        staffDao.setDeleted(id, false);
    	ModelAndView mav = new ModelAndView(staffMemberView);
    	mav.addObject("id", id);
    	return mav;
    }
    public ModelAndView deleteStaffMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = ServletRequestUtils.getIntParameter(request, "id");
        staffDao.setDeleted(id, true);
    	ModelAndView mav = new ModelAndView(staffMemberView);
    	mav.addObject("id", id);
    	return mav;
    }
    public ModelAndView restoreCamp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = ServletRequestUtils.getIntParameter(request, "id");
        campDao.setDeleted(id, false);
    	ModelAndView mav = new ModelAndView(campView);
    	mav.addObject("id", id);
    	return mav;
    }
    public ModelAndView deleteCamp(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = ServletRequestUtils.getIntParameter(request, "id");
        campDao.setDeleted(id, true);
    	ModelAndView mav = new ModelAndView(campView);
    	mav.addObject("id", id);
    	return mav;
    }
    public ModelAndView restoreFlight(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = ServletRequestUtils.getIntParameter(request, "id");
        flightDao.setDeleted(id, false);
    	ModelAndView mav = new ModelAndView(flightView);
    	mav.addObject("id", id);
    	return mav;
    }
    public ModelAndView deleteFlight(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = ServletRequestUtils.getIntParameter(request, "id");
        flightDao.setDeleted(id, true);
    	ModelAndView mav = new ModelAndView(flightView);
    	mav.addObject("id", id);
    	return mav;
    }
    public ModelAndView deleteTransfer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = ServletRequestUtils.getIntParameter(request, "id");
        transferDao.setDeleted(id, true);
    	ModelAndView mav = new ModelAndView(transferView);
    	mav.addObject("id", id);
    	return mav;
    }
    public ModelAndView restoreTransfer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = ServletRequestUtils.getIntParameter(request, "id");
        transferDao.setDeleted(id, false);
    	ModelAndView mav = new ModelAndView(transferView);
    	mav.addObject("id", id);
    	return mav;
    }

    public ModelAndView deleteItinerary(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = ServletRequestUtils.getIntParameter(request, "id");
        itineraryDao.setDeleted(id, true);
    	ModelAndView mav = new ModelAndView(getItineraryView());
    	mav.addObject("id", id);
    	return mav;
    }
    public ModelAndView restoreItinerary(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = ServletRequestUtils.getIntParameter(request, "id");
        itineraryDao.setDeleted(id, false);
    	ModelAndView mav = new ModelAndView(itineraryView);
    	mav.addObject("id", id);
    	return mav;
    }

    public void setTransferDao(TransferDao transferDao) {
        this.transferDao = transferDao;
    }

    public void setTransferView(String transferView) {
        this.transferView = transferView;
    }

    public void setCampView(String campView) {
		this.campView = campView;
	}
	public void setFlightView(String flightView) {
		this.flightView = flightView;
	}
	public void setStaffMemberView(String staffMemberView) {
		this.staffMemberView = staffMemberView;
	}
	public void setItineraryView(String itineraryView) {
		this.itineraryView = itineraryView;
	}
	public String getItineraryView() {
		return itineraryView;
	}
	public void setCampDao(CampDao campDao) {
		this.campDao = campDao;
	}

	public void setFlightDao(FlightDao flightDao) {
		this.flightDao = flightDao;
	}

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	public void setItineraryDao(ItineraryDao itineraryDao) {
		this.itineraryDao = itineraryDao;
	}
	public ItineraryDao getItineraryDao() {
		return itineraryDao;
	}


}
