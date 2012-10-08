package com.eeplanner.web.transfer;

import com.eeplanner.dao.transfer.TransferDao;
import com.eeplanner.datastructures.Transfer;
import com.eeplanner.web.EEPlannerSimpleFormController;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class TransferController extends EEPlannerSimpleFormController{

    Logger log = Logger.getLogger(TransferController.class);
    private TransferDao transferDao;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {

		log.fatal("submit clicked");
		Transfer transfer = (Transfer) command;

        transfer = parseArrivalAndDepDates(transfer, request);

		transfer = transferDao.storeTransfer(transfer);
		ModelAndView mav = new ModelAndView(getSuccessView());

		if (transfer.getID() > 0) {
			mav.addObject("transfer", transfer);
		}

		return mav;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {

		Transfer transfer = new Transfer();

		if (ServletRequestUtils.getIntParameter(request, "id") != null) {
			transfer = transferDao.getTransferByID(ServletRequestUtils.getIntParameter(request, "id"));
		}
		return transfer;
	}

    private Transfer parseArrivalAndDepDates(Transfer transfer, HttpServletRequest request)throws Exception{


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

            transfer.setOutboundArrival(getDateTimeFromString(arr.toString()));
        }
        else transfer.setOutboundArrival(null);

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

            transfer.setOutboundDeparture(getDateTimeFromString(dep.toString()));
        }
        else transfer.setOutboundDeparture(null);


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

            transfer.setReturnArrival(getDateTimeFromString(arr.toString()));
        }
        else transfer.setReturnArrival(null);

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

            transfer.setReturnDeparture(getDateTimeFromString(dep.toString()));
        }
        else transfer.setReturnDeparture(null);

        return transfer;
    }

    public void setTransferDao(TransferDao transferDao) {
        this.transferDao = transferDao;
    }


	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map model = new HashMap();

		if (ServletRequestUtils.getIntParameter(request, "id") != null) {

			Transfer transfer = transferDao.getTransferByID(ServletRequestUtils.getIntParameter(request, "id"));

		}

		return model;
	}
}
