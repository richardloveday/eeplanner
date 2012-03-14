package com.eeplanner.web.flight;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.validation.BindException;
import com.eeplanner.dao.flight.FlightDao;
import com.eeplanner.dao.services.Persist;
import com.eeplanner.dao.staff.StaffDao;
import com.eeplanner.dao.camp.CampDao;
import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.Flight;
import com.eeplanner.datastructures.StaffMember;
import com.eeplanner.web.EEPlannerSimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 15-Jan-2010
 * Time: 16:18:02
 * To change this template use File | Settings | File Templates.
 */
public class FlightController extends EEPlannerSimpleFormController {


	Logger log = Logger.getLogger(FlightController.class);
	private FlightDao flightDao;
	private Persist persistService;
	private StaffDao staffDao;
	private CampDao campDao;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {

		log.fatal("submit clicked");
		Flight flight = (Flight) command;

        flight = parseArrivalAndDepDates(flight, request);

		flight = persistService.storeFlight(flight);
		ModelAndView mav = new ModelAndView(getSuccessView());

		if (flight.getID() > 0) {
			mav.addObject("flight", flight);
		}

		return mav;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {

		Flight flight = new Flight();
		List<Camp> camps;
		List<StaffMember> staffMembers;

		if (ServletRequestUtils.getIntParameter(request, "id") != null) {
			flight = flightDao.getFlightByID(ServletRequestUtils.getIntParameter(request, "id"));
			staffMembers = staffDao.getStaffMembersForFlight(flight, "secondName asc");
			camps = campDao.getCampsForFlight(flight.getID(), "secondName asc");

			flight.setStaffMembers(staffMembers);
			flight.setCamps(camps);
		}
		return flight;
	}

    private Flight parseArrivalAndDepDates(Flight flight, HttpServletRequest request)throws Exception{


        if (ServletRequestUtils.getStringParameter(request, "outboundArrivalDateToSave")!=null
                &&	!ServletRequestUtils.getStringParameter(request, "outboundArrivalDateToSave").equalsIgnoreCase("")) {

            StringBuffer arr = new StringBuffer(request.getParameter("outboundArrivalDateToSave"));

            if(request.getParameter("outarrhours")!=null &&
                    !request.getParameter("outarrhours").equalsIgnoreCase("") &&
                    request.getParameter("outarrminutes")!=null &&
                    !request.getParameter("outarrminutes").equalsIgnoreCase("")){

                arr.append(" ").append(ServletRequestUtils.getStringParameter(request, "outarrhours"));
                arr.append(":").append(ServletRequestUtils.getStringParameter(request, "outarrminutes"));
            }

            flight.setOutboundArrival(getDateTimeFromString(arr.toString()));
        }
        else flight.setOutboundArrival(null);

        if (ServletRequestUtils.getStringParameter(request, "outboundDepartureDateToSave")!=null
                &&	!ServletRequestUtils.getStringParameter(request, "outboundDepartureDateToSave").equalsIgnoreCase("")) {

            StringBuffer dep = new StringBuffer(request.getParameter("outboundDepartureDateToSave"));

            if(request.getParameter("outdephours")!=null &&
                    !request.getParameter("outdephours").equalsIgnoreCase("") &&
                    request.getParameter("outdepminutes")!=null &&
                    !request.getParameter("outdepminutes").equalsIgnoreCase("")){

                dep.append(" ").append(ServletRequestUtils.getStringParameter(request, "outdephours"));
                dep.append(":").append(ServletRequestUtils.getStringParameter(request, "outdepminutes"));
            }

            flight.setOutboundDeparture(getDateTimeFromString(dep.toString()));
        }
        else flight.setOutboundDeparture(null);


        if (ServletRequestUtils.getStringParameter(request, "returnArrivalDateToSave")!=null
                &&	!ServletRequestUtils.getStringParameter(request, "returnArrivalDateToSave").equalsIgnoreCase("")) {

            StringBuffer arr = new StringBuffer(request.getParameter("returnArrivalDateToSave"));

            if(request.getParameter("retarrhours")!=null &&
                    !request.getParameter("retarrhours").equalsIgnoreCase("") &&
                    request.getParameter("retarrminutes")!=null &&
                    !request.getParameter("retarrminutes").equalsIgnoreCase("")){

                arr.append(" ").append(ServletRequestUtils.getStringParameter(request, "retarrhours"));
                arr.append(":").append(ServletRequestUtils.getStringParameter(request, "retarrminutes"));
            }

            flight.setReturnArrival(getDateTimeFromString(arr.toString()));
        }
        else flight.setReturnArrival(null);

        if (ServletRequestUtils.getStringParameter(request, "returnDepartureDateToSave")!=null
                &&	!ServletRequestUtils.getStringParameter(request, "returnDepartureDateToSave").equalsIgnoreCase("")) {

            StringBuffer dep = new StringBuffer(request.getParameter("returnDepartureDateToSave"));

            if(request.getParameter("retdephours")!=null &&
                    !request.getParameter("retdephours").equalsIgnoreCase("") &&
                    request.getParameter("retdepminutes")!=null &&
                    !request.getParameter("retdepminutes").equalsIgnoreCase("")){

                dep.append(" ").append(ServletRequestUtils.getStringParameter(request, "retdephours"));
                dep.append(":").append(ServletRequestUtils.getStringParameter(request, "retdepminutes"));
            }

            flight.setReturnDeparture(getDateTimeFromString(dep.toString()));
        }
        else flight.setReturnDeparture(null);

        return flight;
    }

	public void setCampDao(CampDao campDao) {
		this.campDao = campDao;
	}

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	public void setFlightDao(FlightDao flightDao) {
		this.flightDao = flightDao;
	}

	public void setPersistService(Persist persistService) {
		this.persistService = persistService;
	}

	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map model = new HashMap();
        
		if (ServletRequestUtils.getIntParameter(request, "id") != null) {

			Flight flight = flightDao.getFlightByID(ServletRequestUtils.getIntParameter(request, "id"));

			int flightsYear = new DateTime(flight.getOutboundDeparture()).getYear();
			
			List<Camp> camps = campDao.getAvailableCampsForFlight(flight.getID(), "secondName asc", false);
			List<Camp> currentYearsCamps = campDao.getCampsForYear(flightsYear);
			int[] campIDs = new int[currentYearsCamps.size()];
			int cntr = 0;
			for(Camp camp: currentYearsCamps){
				campIDs[cntr] = camp.getID();
				cntr++;
			}
			List<StaffMember> staffMembers = staffDao.getStaffMembersForCamps(campIDs, "secondName asc");

			model.put("availableCamps", camps);
			model.put("availableStaff", staffMembers);

		}

		model.put("camps", campDao.getCampList("name asc", false));
		return model;
	}
}
