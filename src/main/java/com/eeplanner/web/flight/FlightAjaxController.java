package com.eeplanner.web.flight;

import com.eeplanner.dao.flight.FlightDao;
import com.eeplanner.datastructures.Flight;
import com.eeplanner.web.EEPlannerSimpleFormController;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: charlieivie
 * Date: 26/04/2011
 * Time: 22:19
 * To change this template use File | Settings | File Templates.
 */
public class FlightAjaxController extends EEPlannerSimpleFormController{
    Logger log  = Logger.getLogger(FlightAjaxController.class);

    private FlightDao flightDao;


    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {

        log.fatal("store a flight");
        Flight flight = (Flight)command;

        flight = flightDao.storeFlight(flight);

        HashMap<String, String> jsonResponseMap = new HashMap<String, String>();
        jsonResponseMap.put("response", flight!=null?"success":"failure");

        // redirect back to the itinerary
        return new ModelAndView(getSuccessView(), jsonResponseMap);
    }


    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        Flight flight = new Flight();

        if(ServletRequestUtils.getIntParameter(request, "id")!=null){
            flight = flightDao.getFlightByID(ServletRequestUtils.getIntParameter(request, "id"));
        }

        return flight;

    }


    public void setFlightDao(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

}
