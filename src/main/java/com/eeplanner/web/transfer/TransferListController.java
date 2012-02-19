package com.eeplanner.web.transfer;

import com.eeplanner.dao.camp.CampDao;
import com.eeplanner.dao.flight.FlightDao;
import com.eeplanner.dao.staff.StaffDao;
import com.eeplanner.dao.transfer.TransferDao;
import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.Flight;
import com.eeplanner.datastructures.StaffMember;
import com.eeplanner.datastructures.Transfer;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: charlesivie
 * Date: 10/05/11
 * Time: 12:13
 * To change this template use File | Settings | File Templates.
 */
public class TransferListController extends AbstractController{

    Logger log  = Logger.getLogger(TransferListController.class);
    private TransferDao transferDao;
    private String viewName;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
        boolean showDeleted = ServletRequestUtils.getBooleanParameter(request, "showDeleted", false);
        int year = ServletRequestUtils.getIntParameter(request, "showYear", new DateTime().getYear());

		List<Transfer> transfers = transferDao.getTransferListByYear("outboundDeparture asc", showDeleted, year);

        mav.addObject("transfers", transfers);
        mav.addObject("showYear", year);
        mav.addObject("showDeleted", showDeleted);

		return mav;
    }

    public void setTransferDao(TransferDao transferDao) {
        this.transferDao = transferDao;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

}
