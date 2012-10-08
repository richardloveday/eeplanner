package com.eeplanner.web.camp;

import com.eeplanner.dao.itinerary.ItineraryDao;
import com.eeplanner.web.EEPlannerSimpleFormController;
import com.eeplanner.dao.camp.CampDao;
import com.eeplanner.dao.contact.ContactDao;
import com.eeplanner.dao.services.Persist;
import com.eeplanner.dao.email.EmailDao;
import com.eeplanner.dao.phone.PhoneDao;
import com.eeplanner.dao.note.NoteDao;
import com.eeplanner.dao.staff.StaffDao;
import com.eeplanner.datastructures.*;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.validation.BindException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CampController extends EEPlannerSimpleFormController {

    Logger log = Logger.getLogger(CampController.class);
    private CampDao campDao;
    private ContactDao contactDao;
    private StaffDao staffDao;
    private EmailDao emailDao;
    private PhoneDao phoneDao;
    private NoteDao noteDao;
    private Persist persistService;
    private ItineraryDao itineraryDao;

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {

        log.fatal("submit clicked");
        Camp camp = (Camp) command;

        ModelAndView mav = new ModelAndView(getSuccessView());
        
        String start = request.getParameter("startDateToSave");
        String end = request.getParameter("endDateToSave");
        String stamp = request.getParameter("dateStampToSave");
        String delivery = request.getParameter("deliveryDateToSave");
        String forwarding = request.getParameter("forwardingDateToSave");

		
		camp.setStart(getDateTimeFromString(start));
        camp.setEnd(getDateTimeFromString(end));
        camp.setDateStamp(getDateTimeFromString(stamp));
        camp.setDeliveryDate(getDateTimeFromString(delivery));
        camp.setForwardingDate(getDateTimeFromString(forwarding));
        
        Contact c = buildContactNumbersEmailsNotes(camp.getContact(), request);
        camp.setContact(c);

        Contact sc = buildSchoolContactNumbersEmailsNotes(camp.getSchoolContact(), request);
        camp.setSchoolContact(sc);
        
        camp = persistService.storeCamp(camp);

        if (camp.getID() > 0) {
            mav.addObject("camp", camp);
        }

        return mav;
    }

    
    
    @Override
    protected Object formBackingObject(HttpServletRequest request) throws Exception {

        Camp camp = new Camp();
        
        Contact contact;
        List<Phone> phoneNumbers;
        List<Email> emails;
        List<Note> notes;
        
        Contact schoolContact;
        List<Phone> schoolPhoneNumbers;
        List<Email> schoolEmails;
        List<Note> schoolNotes;
        
        List<StaffMember> staffMembers;
        
        if (ServletRequestUtils.getIntParameter(request, "id") != null) {
            camp = campDao.getCampByID(ServletRequestUtils.getIntParameter(request, "id"));
            
            contact = contactDao.getContactByID(camp.getContactID());
            emails = emailDao.getEmailListByContactID(contact.getID());
            notes = noteDao.getNotesListByContactID(contact.getID());
            phoneNumbers = phoneDao.getPhoneNumberListByContactID(contact.getID());

           if (camp.getSchoolContactID()==0){  
        	   Contact newContact = new Contact();
        	   newContact.setType(ContactType.school.getName());
        	   Contact ct = contactDao.storeContact(newContact);
        	   camp.setSchoolContactID(ct.getID());
           }
           
            schoolContact = contactDao.getContactByID(camp.getSchoolContactID());
            schoolEmails = emailDao.getEmailListByContactID(schoolContact.getID());
            schoolNotes = noteDao.getNotesListByContactID(schoolContact.getID());
            schoolPhoneNumbers = phoneDao.getPhoneNumberListByContactID(schoolContact.getID());                    
            
            staffMembers = staffDao.getStaffMembersForCamp(camp, "job asc");
            
            if(staffMembers!=null) {
	            for(StaffMember staff : staffMembers){ 
	            	Itinerary itinerary = itineraryDao.getItineraryByCampAndStaffID(camp.getID(), staff.getID());
	            	if(itinerary!=null) {
	            		List<Itinerary> items = new ArrayList<Itinerary>();
	            		items.add(itinerary);
	            		staff.setItineraries(items);
	            	}
	            }
            }

            contact.setPhoneNumbers(phoneNumbers);
            contact.setEmails(emails);
            contact.setNotes(notes);
            camp.setContact(contact);
            schoolContact.setPhoneNumbers(schoolPhoneNumbers);
            schoolContact.setEmails(schoolEmails);
            schoolContact.setNotes(schoolNotes);
            camp.setSchoolContact(schoolContact);
            
            camp.setStaffMembers(staffMembers);

        }
        return camp;
    }

    @Override
    protected Map referenceData(HttpServletRequest request) throws Exception {
        if (ServletRequestUtils.getIntParameter(request, "id") != null) {
            Map model = new HashMap();
            Camp camp = campDao.getCampByID(ServletRequestUtils.getIntParameter(request, "id"));
            List<StaffMember> staffMembers = staffDao.getStaffMembersForCamp(camp, "secondName asc");
            int coordinators = 0;
            int teachers = 0;
            int dramaTeachers = 0;
            int activityLeaders = 0;
            int activityCoordinators = 0;
            int dptCoordinators = 0;
            int courseSpecialists = 0;
            int splitRoles = 0;

            for (StaffMember staffMember : staffMembers) {
                if (staffMember.getJob() != null) {
                    if (staffMember.getJob().equalsIgnoreCase("coordinator")) coordinators++;
                    else if (staffMember.getJob().equalsIgnoreCase("teacher")) teachers++;
                    else if (staffMember.getJob().equalsIgnoreCase("drama coordinator")) dramaTeachers++;
                    else if (staffMember.getJob().equalsIgnoreCase("activity leader")) activityLeaders++;
                    else if (staffMember.getJob().equalsIgnoreCase("activityCoordinator")) activityCoordinators++;
                    else if (staffMember.getJob().equalsIgnoreCase("dptCoordinator")) dptCoordinators++;
                    else if (staffMember.getJob().equalsIgnoreCase("courseSpecialist")) courseSpecialists++;
                    else if (staffMember.getJob().equalsIgnoreCase("mixedRole")) splitRoles++;
                }

            }

            int coordinatorsStillNeeded = camp.getCoordinatorsNeeded() - coordinators;
            int teachersStillNeeded = camp.getTeachersNeeded() - teachers;
            int dramaTeachersStillNeeded = camp.getDramaTeachersNeeded() - dramaTeachers;
            int activityLeadersStillNeeded = camp.getActivityLeadersNeeded() - activityLeaders;
            int activityCoordinatorsStillNeeded = camp.getActivityCoordinatorsNeeded() - activityCoordinators;
            int dptCoordinatorsStillNeeded = camp.getDptCoordinatorsNeeded() - dptCoordinators;
            int courseSpecialistsStillNeeded = camp.getCourseSpecialistsNeeded() - courseSpecialists;
            int splitRoleStillNeeded = camp.getSplitRoleNeeded() - splitRoles;


            model.put("coordinatorsStillNeeded", coordinatorsStillNeeded);
            model.put("teachersStillNeeded", teachersStillNeeded);
            model.put("dramaTeachersStillNeeded", dramaTeachersStillNeeded);
            model.put("activityLeadersStillNeeded", activityLeadersStillNeeded);
            model.put("activityCoordinatorsStillNeeded", activityCoordinatorsStillNeeded);
            model.put("dptCoordinatorsStillNeeded", dptCoordinatorsStillNeeded);
            model.put("courseSpecialistsStillNeeded", courseSpecialistsStillNeeded);
            model.put("splitRoleStillNeeded", splitRoleStillNeeded);
            
            SimpleDateFormat simpleDateformat=new SimpleDateFormat("yyyy");
            int theYear = Integer.parseInt(simpleDateformat.format(camp.getStart()));
            model.put("availableStaff", staffDao.getAvailableStaffMembers(camp.getID(),theYear, "secondName", false));
            return model;
        }
        return super.referenceData(request);
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    public void setCampDao(CampDao campDao) {
        this.campDao = campDao;
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

    public void setPersistService(Persist persistService) {
        this.persistService = persistService;
    }

	public void setItineraryDao(ItineraryDao itineraryDao) {
		this.itineraryDao = itineraryDao;
	}
}
