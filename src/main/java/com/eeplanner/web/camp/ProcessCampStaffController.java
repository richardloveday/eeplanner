package com.eeplanner.web.camp;

import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.ServletRequestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eeplanner.dao.camp.CampDao;
import com.eeplanner.datastructures.CampStaff;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 19-Jan-2010
 * Time: 18:09:19
 * To change this template use File | Settings | File Templates.
 */
public class ProcessCampStaffController extends MultiActionController {

    private CampDao campDao;

    public void setCampDao(CampDao campDao) {
        this.campDao = campDao;
    }

    public ModelAndView addStaffMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int campID = 0;
        if (ServletRequestUtils.getIntParameter(request, "staffMemberID") != null) {
            int staffMemberID = ServletRequestUtils.getIntParameter(request, "staffMemberID");
            campID = ServletRequestUtils.getIntParameter(request, "campID");
            campDao.addCampStaffMember(campID, staffMemberID);
        }
        return new ModelAndView("redirect:/camp.htm?id="+campID);
    }

    public ModelAndView removeStaffMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int campID = 0;
        if (ServletRequestUtils.getIntParameter(request, "staffMemberID") != null) {
            int staffMemberID = ServletRequestUtils.getIntParameter(request, "staffMemberID");
            campID = ServletRequestUtils.getIntParameter(request, "campID");
            campDao.removeCampStaffMember(campID, staffMemberID);
        }
        return new ModelAndView("redirect:/camp.htm?id="+campID);
    }

    public ModelAndView editStaffMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int campID = 0;
        if (ServletRequestUtils.getIntParameter(request, "staffMemberID") != null) {
            int staffMemberID = ServletRequestUtils.getIntParameter(request, "staffMemberID");
            campID = ServletRequestUtils.getIntParameter(request, "campID");
            String job = ServletRequestUtils.getStringParameter(request, "job");
            boolean offered = false;
            boolean accepted = false;
            boolean returned = false;
            if(request.getParameter("offered")!=null) offered = true;
            if(request.getParameter("accepted")!=null) accepted = true;
            if(request.getParameter("returned")!=null) returned = true;

            campDao.editCampStaffMember(new CampStaff(staffMemberID, campID, offered, accepted, returned, job));
        }
        return new ModelAndView("redirect:/camp.htm?id="+campID);
    }

}
