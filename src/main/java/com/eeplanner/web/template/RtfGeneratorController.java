package com.eeplanner.web.template;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.eeplanner.dao.camp.CampDao;
import com.eeplanner.dao.contact.ContactDao;
import com.eeplanner.dao.email.EmailDao;
import com.eeplanner.dao.flight.FlightDao;
import com.eeplanner.dao.itinerary.ItineraryDao;
import com.eeplanner.dao.note.NoteDao;
import com.eeplanner.dao.phone.PhoneDao;
import com.eeplanner.dao.staff.StaffDao;
import com.eeplanner.dao.staffavailability.StaffAvailabilityDao;
import com.eeplanner.dao.template.TemplateDao;
import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.CampStaff;
import com.eeplanner.datastructures.Contact;
import com.eeplanner.datastructures.Flight;
import com.eeplanner.datastructures.Itinerary;
import com.eeplanner.datastructures.Phone;
import com.eeplanner.datastructures.StaffMember;
import com.eeplanner.datastructures.Template;
import com.eeplanner.datastructures.TemplateType;
import com.eeplanner.service.DateTool;
import com.eeplanner.service.DocumentService;

public class RtfGeneratorController extends MultiActionController {

	private DocumentService documentService;
	private StaffDao staffDao;
	protected StaffAvailabilityDao staffAvailabilityDao;
	private TemplateDao templateDao;
	private CampDao campDao;
	private FlightDao flightDao;
	private ContactDao contactDao;
	private PhoneDao phoneDao;
	protected EmailDao emailDao;
    protected NoteDao noteDao;
    protected ItineraryDao itineraryDao;

	public ModelAndView generateStaffContract(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return createCampStaffBasedTemplate(request, response,
				TemplateType.Contract_of_a_staff_member);
	}

	public ModelAndView generateStaffOffer(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return createCampStaffBasedTemplate(request, response,
				TemplateType.Offer_Letter);
	}

	private ModelAndView createCampStaffBasedTemplate(
			HttpServletRequest request, HttpServletResponse response, TemplateType templateType)
			throws ServletRequestBindingException, Exception, IOException {
		
		int staffId = ServletRequestUtils.getIntParameter(request, "staffMemberID");
		int campId = ServletRequestUtils.getIntParameter(request, "campID");
		StaffMember staff = staffDao.getStaffMemberByID(staffId);
		Camp camp = campDao.getCampByID(campId);
		CampStaff campStaff = campDao.getCampStaff(campId, staffId);
		if (camp != null && camp.getContactID() > 0) {
			camp.setContact(contactDao.getContactByID(camp.getContactID()));
		}
		Map<String, Object> sourceObjects = new HashMap<String, Object>();
		
		if((templateType == TemplateType.Contract_of_a_staff_member) 
				&& campStaff.getContractDate()==null){
			campStaff.setContractDate(new Date());
			campDao.editCampStaffMember(campStaff);
			
			if (campStaff.getContractDate() != null) {
				sourceObjects.put("campStaffContractDate", DateFormatUtils.format(campStaff.getContractDate(), "dd MMMM yyyy"));
			}
		}
		
		if(campStaff.getJob().equalsIgnoreCase("Coordinator")){
			templateType = TemplateType.Contract_of_a_coordinator;
		}
		
		campStaff.setJob(StringUtils.capitalize(campStaff.getJob()));
		
		sourceObjects.put("staff", staff);
		sourceObjects.put("camp", camp);
		sourceObjects.put("campStaff", campStaff);
		sourceObjects.put("campStartDate", DateFormatUtils.format(camp.getStart(), "dd-MM-yyyy"));
		sourceObjects.put("campEndDate", DateFormatUtils.format(camp.getEnd(), "dd-MM-yyyy"));
		
		sourceObjects.put("currentDate", new Date());
		sourceObjects.put("currentYear", new DateTime().toString("YYYY"));

		String rtf = documentService.createRtfDocument(templateType, sourceObjects);

		// Write to response
		response.setContentType("application/rtf");
		response.setHeader("content-disposition", "attachment;filename=" + templateType.name() + "-" + staff.getContact().getFirstNames()
				+ staff.getContact().getSecondName() + ".rtf");
		response.getWriter().print(rtf);
		response.flushBuffer();

		return null;
	}
	
	public ModelAndView generateFlightSummary(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int flightId = ServletRequestUtils.getIntParameter(request, "id");
		Flight flight = flightDao.getFlightByID(flightId);
		List<StaffMember> staffMembers = staffDao.getStaffMembersForFlight(
				flight, "secondName asc");

		List<StaffWrapper> staffWrappers = new ArrayList<RtfGeneratorController.StaffWrapper>();
		
		if(!CollectionUtils.isEmpty(staffMembers)){
			for(StaffMember staffMember : staffMembers){
				Itinerary itinerary = itineraryDao.getItineraryByFlightAndStaffID(flightId, staffMember.getID());
				
				if(itinerary!=null) {
					staffMember = staffDao.getStaffMemberForCamp(staffMember.getID(), itinerary.getCampID());
					staffMember.setCamp(campDao.getCampByID(itinerary.getCampID()));
				}
				staffMember.getContact().setPhoneNumbers(phoneDao.getPhoneNumberListByContactID(staffMember.getContact().getID()));
				staffWrappers.add(new StaffWrapper(staffMember, null));
			}
		}
		
		Map<String, Object> sourceObjects = new HashMap<String, Object>();
		sourceObjects.put("flight", flight);
		sourceObjects.put("staffMembers", staffWrappers);
		sourceObjects.put("currentDate", new Date());
		sourceObjects.put("currentYear", new DateTime().toString("YYYY"));
		sourceObjects.put("dateTool", new DateTool());
		
		String rtf = documentService.createRtfDocument(TemplateType.Flight_summary, sourceObjects);

		// Write to response
		response.setContentType("application/rtf");
		response.setHeader("content-disposition",
				"attachment;filename=" + TemplateType.Flight_summary.name() + "-"
						+ flight.getFlightNumber() + ".rtf");
		response.getWriter().print(rtf);
		response.flushBuffer();

		return null;
	}
	
	public ModelAndView generateStaffProfilesForACamp(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Map<String, Object> sourceObjects = new HashMap<String, Object>();
		int campId = ServletRequestUtils.getIntParameter(request, "id");
		Camp camp = campDao.getCampByID(campId);
		
		List<StaffWrapper> staffWrappers = new ArrayList<RtfGeneratorController.StaffWrapper>();
		List<StaffMember> staffMembers = staffDao.getStaffMembersForCamp(camp, "secondName asc");
			
		if(!CollectionUtils.isEmpty(staffMembers)){
			for(StaffMember staffMember : staffMembers){
				staffMember.getContact().setPhoneNumbers(phoneDao.getPhoneNumberListByContactID(staffMember.getContact().getID()));
				staffMember.getContact().setEmails(emailDao.getEmailListByContactID(staffMember.getContact().getID()));
				staffMember.getContact().setNotes(noteDao.getNotesListByContactID(staffMember.getContact().getID()));
				
				Itinerary itinerary = itineraryDao.getItineraryByCampAndStaffID(campId, staffMember.getID());
				
				Flight flight = itinerary==null ? null : flightDao.getFlightByID(itinerary.getFlightID());
				
				staffWrappers.add(new StaffWrapper(staffMember, flight));
			}
		}
			
		if (camp != null && camp.getContactID() > 0) {
			Contact campContact = contactDao.getContactByID(camp.getContactID());
			camp.setContact(campContact);
			if(campContact!=null){
				List<Phone> phoneNumbers = phoneDao.getPhoneNumberListByContactID(campContact.getID());
				sourceObjects.put("contactMobile", findMobileNumber(phoneNumbers));
			}
		}
		sourceObjects.put("camp", camp);
		sourceObjects.put("staffMembers", staffWrappers);
		sourceObjects.put("currentDate", new Date());
		sourceObjects.put("currentYear", new DateTime().toString("YYYY"));
		sourceObjects.put("dateTool", new DateTool());

		String rtf = documentService.createRtfDocument(TemplateType.Staff_profiles_for_a_camp, sourceObjects);

		// Write to response
		response.setContentType("application/rtf");
		response.setHeader("content-disposition",
				"attachment;filename=" + TemplateType.Staff_profiles_for_a_camp.name() + "-"
						+ camp.getName() + ".rtf");
		response.getWriter().print(rtf);
		response.flushBuffer();

		return null;
	}
	
	public ModelAndView generateStaffDataForm(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int staffId = ServletRequestUtils.getIntParameter(request, "id");
		StaffMember staff = staffDao.getStaffMemberByID(staffId);
		if (staff != null) {
			staff.setStaffAvailability(staffAvailabilityDao.getStaffAvailabilityByIDAndYear(staff.getID(), new DateTime().getYear()));
			staff.setContact(getContact(staff));
        }

		Map<String, Object> sourceObjects = new HashMap<String, Object>();
		sourceObjects.put("staff", staff);
		sourceObjects.put("currentDate", new Date());
		sourceObjects.put("currentYear", new DateTime().toString("YYYY"));
		sourceObjects.put("dateTool", new DateTool());

		String rtf = documentService.createRtfDocument(TemplateType.Staff_data_form, sourceObjects);

		// Write to response
		response.setContentType("application/rtf");
		response.setHeader("content-disposition",
				"attachment;filename=" + TemplateType.Staff_data_form.name() + "-"
						+ staff.getContact().getFirstNames() + staff.getContact().getSecondName() + ".rtf");
		response.getWriter().print(rtf);
		response.flushBuffer();

		return null; 
	}
	
	public ModelAndView generatePersonalInfoDocument(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int staffId = ServletRequestUtils.getIntParameter(request, "staffMemberID");
		int campId = ServletRequestUtils.getIntParameter(request, "campID");
		
		Itinerary itinerary = itineraryDao.getItineraryByCampAndStaffID(campId, staffId);
		
		Flight flight = itinerary==null ? null : flightDao.getFlightByID(itinerary.getFlightID());
		Camp camp = campDao.getCampByID(campId);
		

		Map<String, Object> sourceObjects = new HashMap<String, Object>();
		sourceObjects.put("itinerary", itinerary);
		sourceObjects.put("flight", flight);
		sourceObjects.put("camp", camp);
		sourceObjects.put("currentDate", new Date());
		sourceObjects.put("currentYear", new DateTime().toString("YYYY"));
		sourceObjects.put("dateTool", new DateTool());

		String rtf = documentService.createRtfDocument(TemplateType.Personal_transfer_info, sourceObjects);

		// Write to response
		response.setContentType("application/rtf");
		response.setHeader("content-disposition",
				"attachment;filename=" + TemplateType.Personal_transfer_info.name() + "-"
						+ itinerary.getName() + ".rtf");
		response.getWriter().print(rtf);
		response.flushBuffer();

		return null; 
	}
	
	public ModelAndView generateTravelSummaryForACamp(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Map<String, Object> sourceObjects = new HashMap<String, Object>();

		int campId = ServletRequestUtils.getIntParameter(request, "id");
		Camp camp = campDao.getCampByID(campId);
	
		List<StaffWrapper> staffWrappers = new ArrayList<RtfGeneratorController.StaffWrapper>();
		List<StaffMember> staffMembers = staffDao.getStaffMembersForCamp(camp, "secondName asc");
		
		if(!CollectionUtils.isEmpty(staffMembers)){
			for(StaffMember staffMember : staffMembers){
				staffMember.getContact().setPhoneNumbers(phoneDao.getPhoneNumberListByContactID(staffMember.getContact().getID()));
				
				Itinerary itinerary = itineraryDao.getItineraryByCampAndStaffID(campId, staffMember.getID());
				
				Flight flight = itinerary==null ? null : flightDao.getFlightByID(itinerary.getFlightID());
				
				staffWrappers.add(new StaffWrapper(staffMember, flight));
			}
		}
		
		sourceObjects.put("camp", camp);
		sourceObjects.put("staffMembers", staffWrappers);
		sourceObjects.put("currentDate", new Date());
		sourceObjects.put("currentYear", new DateTime().toString("YYYY"));
		sourceObjects.put("dateTool", new DateTool());

		String rtf = documentService.createRtfDocument(TemplateType.Travel_info_for_a_camp, sourceObjects);

		// Write to response
		response.setContentType("application/rtf");
		response.setHeader("content-disposition",
				"attachment;filename=" + TemplateType.Travel_info_for_a_camp.name() + "-"
						+ camp.getName() + ".rtf");
		response.getWriter().print(rtf);
		response.flushBuffer();

		return null;
	}
	
	
	public ModelAndView generateHostFamilyProfilesForACamp(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Map<String, Object> sourceObjects = new HashMap<String, Object>();

		int campId = ServletRequestUtils.getIntParameter(request, "id");
		Camp camp = campDao.getCampByID(campId);
	
		List<StaffWrapper> staffWrappers = new ArrayList<RtfGeneratorController.StaffWrapper>();
		List<StaffMember> staffMembers = staffDao.getStaffMembersForCamp(camp, "secondName asc");
		
		if(!CollectionUtils.isEmpty(staffMembers)){
			for(StaffMember staffMember : staffMembers){
				staffMember.getContact().setPhoneNumbers(phoneDao.getPhoneNumberListByContactID(staffMember.getContact().getID()));
				staffMember.getContact().setEmails(emailDao.getEmailListByContactID(staffMember.getContact().getID()));
				staffMember.getContact().setNotes(noteDao.getNotesListByContactID(staffMember.getContact().getID()));
				
				Itinerary itinerary = itineraryDao.getItineraryByCampAndStaffID(campId, staffMember.getID());
				
				Flight flight = itinerary==null ? null : flightDao.getFlightByID(itinerary.getFlightID());
				
				staffWrappers.add(new StaffWrapper(staffMember, flight));
			}
		}
		
		sourceObjects.put("camp", camp);
		sourceObjects.put("staffMembers", staffWrappers);
		sourceObjects.put("currentDate", new Date());
		sourceObjects.put("currentYear", new DateTime().toString("YYYY"));
		sourceObjects.put("dateTool", new DateTool());

		String rtf = documentService.createRtfDocument(TemplateType.Host_family_profiles_for_a_camp, sourceObjects);

		// Write to response
		response.setContentType("application/rtf");
		response.setHeader("content-disposition",
				"attachment;filename=" + TemplateType.Host_family_profiles_for_a_camp.name() + "-"
						+ camp.getName() + ".rtf");
		response.getWriter().print(rtf);
		response.flushBuffer();

		return null;
	}
	
	public static class StaffWrapper 
	{
		final StaffMember staff;
		final Flight flight;
		final String mobileNumber;
		
		public StaffWrapper(StaffMember staff, Flight flight){
			this.staff = staff;
			this.flight = flight;
			this.mobileNumber = RtfGeneratorController.findMobileNumber(staff.getContact().getPhoneNumbers());
		}
		
		public StaffMember getStaff() {
			return staff;
		}

		public Flight getFlight() {
			return flight;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}
	}
	
	private static String findMobileNumber(List<Phone> phoneNumbers) {
		if(!CollectionUtils.isEmpty(phoneNumbers)){
			for(Phone phone : phoneNumbers){
				if(StringUtils.contains(phone.getName(), "mobile")) {
					return phone.getNumber();
				}
			}
			return phoneNumbers.get(0).getNumber();
		}
		return null;
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
	
	public ModelAndView viewTemplateDocument(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int id = ServletRequestUtils.getIntParameter(request, "id");
		Template template = templateDao.getTemplateById(id);

		// Write to response
		response.setContentType("application/rtf");
		response.setHeader("content-disposition", "attachment;filename="
				+ template.getType() + ".rtf");
		response.getWriter().print(template.getText());
		response.flushBuffer();

		return null;
	}

	public void setDocumentService(DocumentService documentService) {
		this.documentService = documentService;
	}

	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	public void setCampDao(CampDao campDao) {
		this.campDao = campDao;
	}

	public void setTemplateDao(TemplateDao templateDao) {
		this.templateDao = templateDao;
	}

	public void setFlightDao(FlightDao flightDao) {
		this.flightDao = flightDao;
	}

	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public void setPhoneDao(PhoneDao phoneDao) {
		this.phoneDao = phoneDao;
	}

	public void setStaffAvailabilityDao(StaffAvailabilityDao staffAvailabilityDao) {
		this.staffAvailabilityDao = staffAvailabilityDao;
	}

	public void setEmailDao(EmailDao emailDao) {
		this.emailDao = emailDao;
	}

	public void setNoteDao(NoteDao noteDao) {
		this.noteDao = noteDao;
	}

	public void setItineraryDao(ItineraryDao itineraryDao) {
		this.itineraryDao = itineraryDao;
	}
	

}
