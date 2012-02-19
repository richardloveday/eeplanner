package com.eeplanner.web.transfer;

import com.eeplanner.dao.transfer.TransferDao;
import com.eeplanner.datastructures.*;
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
 * Time: 18:31
 * To change this template use File | Settings | File Templates.
 */
public class TransferAjaxController extends EEPlannerSimpleFormController {


    Logger log  = Logger.getLogger(TransferAjaxController.class);
    private TransferDao transferDao;


    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {

        log.fatal("store a transfer");
        Transfer transfer = (Transfer)command;

        transfer = transferDao.storeTransfer(transfer);

        HashMap<String, String> jsonResponseMap = new HashMap<String, String>();
        jsonResponseMap.put("response", transfer!=null?"success":"failure");

        // redirect back to the itinerary
        return new ModelAndView(getSuccessView(), jsonResponseMap);
    }


    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        Transfer transfer = new Transfer();

        if(ServletRequestUtils.getIntParameter(request, "id")!=null){
            transfer = transferDao.getTransferByID(ServletRequestUtils.getIntParameter(request, "id"));
        }

        return transfer;

    }


    public void setTransferDao(TransferDao transferDao) {
        this.transferDao = transferDao;
    }


}
