package com.eeplanner.web.staff;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import au.com.bytecode.opencsv.CSVWriter;

import com.eeplanner.dao.camp.CampDao;
import com.eeplanner.dao.staff.StaffDao;
import com.eeplanner.dao.staffavailability.StaffAvailabilityDao;
import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.StaffAvailability;
import com.eeplanner.datastructures.StaffMember;
import com.eeplanner.service.DateTool;

public class StaffMemberListController extends AbstractController {

    Logger log = Logger.getLogger(StaffMemberController.class);
    private StaffDao staffDao;
    private CampDao campDao;
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

    public void setCampDao(CampDao campDao) {
		this.campDao = campDao;
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
        
        boolean export = ServletRequestUtils.getBooleanParameter(request, "staffExport", false);
    	if(export){
    		return generateStaffExport(year, staffMembers, response);
    	}

        mav.addObject("staffMembers", staffMembers);
        mav.addObject("showYear", year);
        mav.addObject("showRole", role);

        return mav;
    }
    
    private ModelAndView generateStaffExport(int year, List<StaffMember> staffMembers, HttpServletResponse response) throws Exception {
    	
    	// Write to response
		response.setContentType("application/csv");
		response.setHeader("content-disposition", "attachment;filename=staffs.csv");
		PrintWriter writer = response.getWriter();
		
		CSVWriter csvWriter = new CSVWriter(writer);
		csvWriter.writeNext("Surname#First name#Date of birth#NI number#Sort code#Account number#Start date#Sex#Address".split("#"));
		
		for (StaffMember staffMember : staffMembers) {
			
			
			
			if (year != 0) {
				
				if(staffMember.getStaffAvailability()!=null && staffMember.getStaffAvailability().isAvailable()) {
					
					List<Camp> camps = campDao.getCampsByStaffMemberID(staffMember.getID(), "start");
					if( !CollectionUtils.isEmpty(camps) ) {
						staffMember.setCamp(camps.get(0));
					}
					
					writeRow(csvWriter, staffMember);
				}
				
			} else {
			
				writeRow(csvWriter, staffMember);
			}
        }
		
		csvWriter.close();
		response.flushBuffer();
    	return null;
    }

	private void writeRow(CSVWriter csvWriter, StaffMember staffMember) {
		
		List<String> row = new ArrayList<String>();
		row.add(staffMember.getContact().getSecondName());
		row.add(staffMember.getContact().getFirstNames());
		row.add(DateTool.instance.toDate(staffMember.getContact().getDob()));
		row.add(staffMember.getContact().getNationalInsuranceNumber());
		row.add(staffMember.getContact().getAccountSortCode());
		row.add(staffMember.getContact().getAccountNumber());
		row.add(DateTool.instance.toDate(staffMember.getCamp().getStart()));
		row.add(staffMember.getContact().getSex());
		row.add(staffMember.getContact().getAdd1() 
				+ " " + staffMember.getContact().getAdd2()
				+ " " + staffMember.getContact().getAdd3()
				+ " " + staffMember.getContact().getAdd4());
		
		csvWriter.writeNext(row.toArray(new String[0]));
	}


}
