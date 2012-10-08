package com.eeplanner.web.staff;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;

import com.eeplanner.dao.contact.ContactDao;
import com.eeplanner.dao.email.EmailDao;
import com.eeplanner.dao.note.NoteDao;
import com.eeplanner.dao.phone.PhoneDao;
import com.eeplanner.dao.services.Persist;
import com.eeplanner.dao.staff.StaffDao;
import com.eeplanner.dao.staffavailability.StaffAvailabilityDao;
import com.eeplanner.datastructures.Contact;
import com.eeplanner.datastructures.ContactType;
import com.eeplanner.datastructures.NoteType;
import com.eeplanner.datastructures.StaffAvailability;
import com.eeplanner.datastructures.StaffMember;
import com.eeplanner.web.EEPlannerSimpleFormController;

public class StaffMemberController extends EEPlannerSimpleFormController {

    Logger log  = Logger.getLogger(getClass());
    protected StaffDao staffDao;
    protected ContactDao contactDao;
    protected EmailDao emailDao;
    protected PhoneDao phoneDao;
    protected NoteDao noteDao;
    protected StaffAvailabilityDao staffAvailabilityDao;
    protected Persist persistService;

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {

        log.info("submit clicked");
        StaffMember staffMember = (StaffMember)command;

        String dob = ServletRequestUtils.getStringParameter(request, "dobToSave", "");

        Contact c = buildContactNumbersEmailsNotes(staffMember.getContact(), request);
        c.setDob(getDateFromString(dob));
        staffMember.setContact(c);
        
        staffMember = this.storeStaffMember(staffMember, request);

        ModelAndView mav = new ModelAndView(getSuccessViewInternal(request));
        if(staffMember.getID()>0){
            mav.addObject("staffMember", staffMember);
        }
        return mav;
    }

    /**
     * Override method to customize for External Page
     * @param staffMember
     * @return
     * @throws Exception
     */
	protected StaffMember storeStaffMember(StaffMember staffMember, HttpServletRequest request) throws Exception {
		return persistService.storeStaffMember(staffMember);
	}
	
	protected StaffMember getStaffMember(HttpServletRequest request) throws Exception {
	
		StaffMember staffMember = new StaffMember();
		
		int staffId = ServletRequestUtils.getIntParameter(request, "id", 0);
		if (staffId != 0) {
			staffMember = staffDao.getStaffMemberByID(staffId);   
			if (staffMember != null && StringUtils.isBlank(staffMember.getHash())) {
				String md5Id = DigestUtils.md5Hex(staffMember.getID() + "");
				staffMember.setHash(md5Id);
				staffMember = staffDao.storeStaffMember(staffMember);
			}
		}
		
		return staffMember;
	}
	
	protected Contact getContact(StaffMember staffMember) throws Exception {
		Contact contact = contactDao.getContactByID(staffMember.getContactID());
		if(contact!=null) {
			contact.setPhoneNumbers(phoneDao.getPhoneNumberListByContactID(contact.getID()));
			contact.setEmails(emailDao.getEmailListByContactID(contact.getID()));
			contact.setNotes(noteDao.getNotesListByContactID(contact.getID()));
		}
		return contact;
	}
	
	protected StaffAvailability getStaffAvailability(StaffMember staffMember, HttpServletRequest request) throws Exception {
		
		int theYear = ServletRequestUtils.getIntParameter(request, "staffYear", new DateTime().getYear());

		StaffAvailability staffAvailability = staffAvailabilityDao.getStaffAvailabilityByIDAndYear(staffMember.getID(), theYear);
		
		return staffAvailability==null 
				? new StaffAvailability(staffMember.getID(), theYear,false,false,false,false,false,false,false,null) 
				: staffAvailability;
	}
	
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        
        StaffMember staffMember = getStaffMember(request);

		if (staffMember != null) {
			staffMember.setContact(getContact(staffMember));
			staffMember.setStaffAvailability(getStaffAvailability(staffMember, request));
        }
		
		
        return staffMember;
    }

	@Override
    protected Map<String, Object> referenceData(HttpServletRequest request) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("contactTypes", Arrays.asList(ContactType.values()));
        model.put("noteTypes", Arrays.asList(NoteType.values()));
        return model;    //To change body of overridden methods use File | Settings | File Templates.
    }
    
	protected String getSuccessViewInternal(HttpServletRequest request){
		return getSuccessView();
	}

    public void setPersistService(Persist persistService) {
        this.persistService = persistService;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public void setEmailDao(EmailDao emailDao) {
		this.emailDao = emailDao;
	}

	public void setPhoneDao(PhoneDao phoneDao) {
		this.phoneDao = phoneDao;
	}

	public void setNoteDao(NoteDao noteDao) {
		this.noteDao = noteDao;
	}

	public void setStaffAvailabilityDao(StaffAvailabilityDao staffAvailabilityDao) {
		this.staffAvailabilityDao = staffAvailabilityDao;
	} 
	
}

