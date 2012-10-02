package com.eeplanner.web.camp;

import com.eeplanner.dao.camp.CampDao;
import com.eeplanner.dao.staff.StaffDao;
import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.StaffMember;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 11-Jan-2010
 * Time: 16:05:27
 * To change this template use File | Settings | File Templates.
 */
public class CampListController extends AbstractController {

    Logger log = Logger.getLogger(CampListController.class);
    private CampDao campDao;
    private StaffDao staffDao;
    private String viewName;

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public void setCampDao(CampDao campDao) {
        this.campDao = campDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView();
        mav.setViewName(viewName);
        boolean showDeleted = ServletRequestUtils.getBooleanParameter(request, "showDeleted", false);
        boolean copyAll = ServletRequestUtils.getBooleanParameter(request, "copyAll", false); 
        int theYear = ServletRequestUtils.getIntParameter(request, "showYear",new DateTime().getYear());
        String orderBy = ServletRequestUtils.getStringParameter(request, "orderBy", "date");
    
        if (copyAll){
        	
        	List<Camp> camps = campDao.getCampListWithStaffWithYear("secondName", showDeleted, theYear-1);
        	
        	for (Camp camp : camps){
        		
        		Camp newCamp = new Camp();
        		DateTime newStart = new DateTime(new DateTime(camp.getStart()).plusYears(1).getYear(),1,1,0,0,0,0);
        		DateTime newEnd = new DateTime(new DateTime(camp.getEnd()).plusYears(1).getYear(),1,2,0,0,0,0);
        		
        		//newStart = newStart.plusYears(1);
        		//newEnd = newEnd.plusYears(1);
        		
        		newCamp.setName(camp.getName());
        		newCamp.setContactID(camp.getContactID());
        		
        		newCamp.setStart(newStart.toDate());
        		newCamp.setEnd(newEnd.toDate());
        		
        		campDao.storeCamp(newCamp);
        		
        		
        	}		
        }
        // int for staff need total calculation
        int iTeachersStillNeeded  = 0 ;
        int iCoordinatorsStillNeeded = 0 ;
        int iDramaTeachersStillNeeded = 0 ;
        int iActivityLeadersStillNeeded = 0 ;
        int iSplitRolesStillNeeded = 0 ;
        List<Camp> camps = campDao.getCampListWithStaffWithYear("secondName", showDeleted, theYear);
        
        for(Camp camp : camps){

			camp.setTeachersStillNeeded(camp.getTeachersNeeded());
			camp.setCoordinatorsStillNeeded(camp.getCoordinatorsNeeded());
			camp.setDramaTeachersStillNeeded(camp.getDramaTeachersNeeded());
			camp.setActivityLeadersStillNeeded(camp.getActivityLeadersNeeded());
			camp.setSplitRoleStillNeeded(camp.getSplitRoleNeeded());
			
        	for(StaffMember staff: camp.getStaffMembers()){
        		if(staff.getJob()!=null){
	        		if(staff.getJob().equalsIgnoreCase("teacher")){
	        			camp.setTeachersStillNeeded(camp.getTeachersStillNeeded()-1);
	        		}
	        		else if(staff.getJob().equalsIgnoreCase("coordinator")){
	        			camp.setCoordinatorsStillNeeded(camp.getCoordinatorsStillNeeded()-1);
	        		}
	        		else if(staff.getJob().equalsIgnoreCase("drama coordinator")){
	        			camp.setDramaTeachersStillNeeded(camp.getDramaTeachersStillNeeded()-1);
	        		}
	        		else if(staff.getJob().equalsIgnoreCase("activity leader")){
	        			camp.setActivityLeadersStillNeeded(camp.getActivityLeadersStillNeeded()-1);
	        		}
	        		else if(staff.getJob().equalsIgnoreCase("mixedRole")){
	        			camp.setSplitRoleStillNeeded(camp.getSplitRoleStillNeeded()-1);
	        		}
        		}
        	}
            iTeachersStillNeeded += camp.getTeachersStillNeeded();
            iCoordinatorsStillNeeded += camp.getCoordinatorsStillNeeded() ;
            iDramaTeachersStillNeeded += camp.getDramaTeachersStillNeeded();
            iActivityLeadersStillNeeded += camp.getActivityLeadersStillNeeded();
            iSplitRolesStillNeeded += camp.getSplitRoleStillNeeded();
        }

        if(orderBy.equalsIgnoreCase("name")){
            TreeMap<String, Camp> nameSortedMap = new TreeMap();
            for(Camp camp: camps){
                nameSortedMap.put(camp.getName(), camp);
            }
            camps = new LinkedList<Camp>(nameSortedMap.values());
        }
        // add a total record
        
        Camp totalCamp = new Camp();
        totalCamp.setName("Total");
        totalCamp.setTeachersStillNeeded(iTeachersStillNeeded);
        totalCamp.setCoordinatorsStillNeeded(iCoordinatorsStillNeeded);
        totalCamp.setDramaTeachersStillNeeded(iDramaTeachersStillNeeded);
        totalCamp.setActivityLeadersStillNeeded(iActivityLeadersStillNeeded);
        totalCamp.setSplitRoleStillNeeded(iSplitRolesStillNeeded);
        camps.add(totalCamp);
        
        /*List<Camp> camps = campDao.getCampList("secondName", show);
        if (camps != null) {
            for (Camp camp : camps) {
                camp.setStaffMembersCount(staffDao.getStaffMembersCountForCamp(camp));
            }
        }*/
        
        mav.addObject("showDeleted", showDeleted);
        mav.addObject("theYear", theYear);
        mav.addObject("orderBy", orderBy);
        mav.addObject("camps", camps);

        return mav;
    }

}
