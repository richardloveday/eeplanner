package com.eeplanner.web.search;

import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.ServletRequestUtils;

import com.eeplanner.dao.staff.StaffDao;
import com.eeplanner.dao.camp.CampDao;
import com.eeplanner.datastructures.StaffMember;
import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.StaffMemberSearchData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;

public class SearchController extends AbstractController{

    private StaffDao staffDao;
    private CampDao campDao;
    private String viewName;

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView(viewName);
        String type = ServletRequestUtils.getStringParameter(request, "type", "");
        String text = ServletRequestUtils.getStringParameter(request, "text", "");
        int staffMemberID = ServletRequestUtils.getIntParameter(request, "staffMemberID", 0);
        int campID = ServletRequestUtils.getIntParameter(request, "campID", 0);
        List<StaffMember> staff;
        List<Camp> camps;

        if(staffMemberID!=0){
        	List<StaffMemberSearchData> staffData = staffDao.getStaffMemberSearchData(staffMemberID, "start desc");
        	mav.addObject("staffData", staffData);
        }
        
        else if(campID!=0){
        	HashMap<String, Object> campData = campDao.getCampSearchData(campID, "start desc");
        	mav.addObject("campData", campData);
        }
        else if(type.equalsIgnoreCase("staff") && !text.equalsIgnoreCase("")){
           staff = staffDao.getStaffByName(text, "secondName asc");
           mav.addObject("staff", staff);
        }
        else if(type.equalsIgnoreCase("camp") && !text.equalsIgnoreCase("")){
           camps = campDao.getCampsByName(text);;
           mav.addObject("camps", camps);
        }

        mav.addObject("type", type);
        mav.addObject("text", text);

        return mav;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    public void setCampDao(CampDao campDao) {
        this.campDao = campDao;
    }


    
    
}
