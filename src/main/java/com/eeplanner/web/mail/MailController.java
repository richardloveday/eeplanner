package com.eeplanner.web.mail;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.eeplanner.dao.camp.CampDao;
import com.eeplanner.dao.email.EmailDao;
import com.eeplanner.dao.staff.StaffDao;
import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.Email;
import com.eeplanner.datastructures.StaffMember;

public class MailController extends MultiActionController {

	private CampDao campDao;
	private StaffDao staffDao;
	private EmailDao emailDao;
	private String campView;
	private String staffView;
	private String mailView;
	
	public ModelAndView mail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        ModelAndView mav = new ModelAndView();
        mav.setViewName(mailView);
        
        String contacts = ServletRequestUtils.getStringParameter(request, "contacts");              
        
        mav.addObject("contacts", contacts);

        return mav;	
	}
	
	public ModelAndView camps(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
        ModelAndView mav = new ModelAndView();
        mav.setViewName(campView);
        
        String contacts = ServletRequestUtils.getStringParameter(request, "contacts"); 
        
        int theYear = ServletRequestUtils.getIntParameter(request, "showYear",new DateTime().getYear());
    
        List<Camp> camps = campDao.getCampListWithStaffWithYear("secondName", false, theYear);
        
        mav.addObject("theYear", theYear);   
        mav.addObject("camps", camps);    
        mav.addObject("contacts", contacts);

        return mav;			
	}
	
	public ModelAndView staff(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
        mav.setViewName(staffView);
		
        String contacts = ServletRequestUtils.getStringParameter(request, "contacts");
		List<StaffMember> staffMembers = staffDao.getStaffList("secondName", false);
		
		mav.addObject("staffMembers", staffMembers);        
        mav.addObject("contacts", contacts);

        return mav;		
	}
	
	public ModelAndView addCamp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
        mav.setViewName(mailView);
		
		String contacts = ServletRequestUtils.getStringParameter(request, "contacts");		
		List<Camp> camps = campDao.getCampList("start", true);
		
		for (Camp camp : camps){	
			
			if (ServletRequestUtils.getBooleanParameter(request, String.valueOf(camp.getID()),false) == true){				
				List<StaffMember> staffs = staffDao.getStaffMembersForCamp(camp, "ID");				
				for (StaffMember staff : staffs){
					//List<Email> emails =staff.getContact().getEmails();				
					List<Email> emails = emailDao.getEmailListByContactID(staff.getContactID());
					
					if (emails != null){
						for (Email email : emails){		
							if (email.getAddress().length()>1){ //some emails are empty and without this the contacts get extra ;
								contacts = contacts + email.getAddress() + "; ";
							}
									
																		
						}									
					}
				}
				
			}
			
		}  
		mav.addObject("contacts", this.removeDuplicates(contacts));
		return mav;	 
    }
	
public ModelAndView addStaff(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
        mav.setViewName(mailView);
		
		String contacts = ServletRequestUtils.getStringParameter(request, "contacts");		
		List<StaffMember> staffs = staffDao.getStaffList("ID", true);
		
		for (StaffMember staff : staffs){
			
			if (ServletRequestUtils.getBooleanParameter(request, String.valueOf(staff.getID()),false) == true){
				List<Email> emails = emailDao.getEmailListByContactID(staff.getContactID());
				if (emails != null){
					for (Email email : emails){														
						if (email.getAddress().length()>1){	
							contacts = contacts + email.getAddress() + "; ";																	
						}					
					}									
				}
				
				
			}
			
		}	
		
		mav.addObject("contacts", this.removeDuplicates(contacts));
		return mav;	 
    }

	private String removeDuplicates(String contacts){
        
		String[] tokens = contacts.split(";");
		Set<String> set = new HashSet<String>();
		contacts = "";
				
		for (String contact : tokens) {
			if (contact.length()>2){
				set.add(contact.trim());
			}
		}		
		for (String s : set) {
        	contacts = contacts + s + "; ";
    	} 
    	return contacts;   	   	 	
	}
	
	public void setCampDao(CampDao campDao) {
		this.campDao = campDao;
	}
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	public void setEmailDao(EmailDao emailDao) {
		this.emailDao = emailDao;
	}
	public void setCampView(String campView) {
		this.campView = campView;
	}
	public void setStaffView(String staffView) {
		this.staffView = staffView;
	}
	public void setMailView(String mailView) {
		this.mailView = mailView;
	}	
}
