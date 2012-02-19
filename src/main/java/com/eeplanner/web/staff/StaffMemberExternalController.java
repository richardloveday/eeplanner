package com.eeplanner.web.staff;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.eeplanner.datastructures.Contact;
import com.eeplanner.datastructures.StaffMember;


public class StaffMemberExternalController extends StaffMemberController {

	protected StaffMember storeStaffMember(StaffMember staffMember, HttpServletRequest request) throws Exception {
		
		if(staffMember.getParentID()==0){
			// Clone StaffMember here
			staffMember.setParentID(staffMember.getID());
			staffMember.setID(0);
			
			Contact contactToDublicate = staffMember.getContact();
			if(contactToDublicate!=null){
				contactToDublicate.setID(0);
			}
		}

		StaffMember saved = persistService.storeStaffMember(staffMember);
		
		if(StringUtils.equalsIgnoreCase("Submit", ServletRequestUtils.getStringParameter(request, "submitOperation", null))){
        	// Copy Changes to Original Parent.
			persistService.updateBackStaffMember(saved);
        }
		
		return saved;
	}
	
	@Override
	protected String getSuccessViewInternal(HttpServletRequest request) {
		if(StringUtils.equalsIgnoreCase("Submit", ServletRequestUtils.getStringParameter(request, "submitOperation", null))){
			return super.getSuccessView();
        }
		return super.getFormView();
	}
	
	protected StaffMember getStaffMember(HttpServletRequest request) throws Exception {
		StaffMember staffMember = null;
		String staffHash = ServletRequestUtils.getStringParameter(request, "hash", null);
		if (StringUtils.isNotBlank(staffHash)) {
			staffMember = staffDao.getStaffMemberByHash(staffHash);
			if (staffMember == null) {
				staffMember = staffDao.getStaffMemberByHash(staffHash);
			}
		}
		
		if (staffMember == null) {
			throw new IllegalAccessException("Illegal usage.");
		} else if(staffMember.getParentID()==-1){
			throw new IllegalAccessException("Update Disable for given Staff Member.");
		}
		
		return staffMember;
	}
	
}

