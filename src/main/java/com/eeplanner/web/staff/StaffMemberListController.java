package com.eeplanner.web.staff;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.eeplanner.dao.staff.StaffDao;
import com.eeplanner.dao.staffavailability.StaffAvailabilityDao;
import com.eeplanner.datastructures.StaffMember;

public class StaffMemberListController extends AbstractController {

    Logger log = Logger.getLogger(StaffMemberController.class);
    private StaffDao staffDao;
    private String viewName;
    private StaffAvailabilityDao staffAvailabilityDao;


    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    public void setStaffAvailabilityDao(StaffAvailabilityDao staffAvailabilityDao) {
        this.staffAvailabilityDao = staffAvailabilityDao;
    }


    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView();
        mav.setViewName(viewName);
        boolean show = ServletRequestUtils.getBooleanParameter(request, "showDeleted", false);
        int year = ServletRequestUtils.getIntParameter(request, "showYear", 0);
        String role = ServletRequestUtils.getStringParameter(request, "showRole", null);

        List<StaffMember> staffMembers = staffDao.getStaffList("secondName", show, role);

        if (year != 0) {
            for (StaffMember staffMember : staffMembers) {
                staffMember.setStaffAvailability(staffAvailabilityDao.getStaffAvailabilityByIDAndYear(staffMember.getID(), year));
            }
        }

        mav.addObject("staffMembers", staffMembers);
        mav.addObject("showYear", year);
        mav.addObject("showRole", role);

        return mav;
    }


}
