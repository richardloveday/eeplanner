package com.eeplanner.web.template;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.eeplanner.dao.camp.CampDao;
import com.eeplanner.dao.contact.ContactDao;
import com.eeplanner.dao.flight.FlightDao;
import com.eeplanner.dao.staff.StaffDao;
import com.eeplanner.dao.template.TemplateDao;
import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.CampStaff;
import com.eeplanner.datastructures.Flight;
import com.eeplanner.datastructures.StaffMember;
import com.eeplanner.datastructures.Template;
import com.eeplanner.datastructures.TemplateType;
import com.eeplanner.service.DocumentService;

public class RtfGeneratorController extends MultiActionController {

	private DocumentService documentService;
	private StaffDao staffDao;
	private TemplateDao templateDao;
	private CampDao campDao;
	private FlightDao flightDao;
	private ContactDao contactDao;

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

	public ModelAndView generateFlightInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int flightId = ServletRequestUtils.getIntParameter(request, "id");
		Flight flight = flightDao.getFlightByID(flightId);
		List<StaffMember> staffMembers = staffDao.getStaffMembersForFlight(
				flight, "secondName asc");

		Map<String, Object> sourceObjects = new HashMap<String, Object>();
		sourceObjects.put("flight", flight);
		sourceObjects.put("staffMembers", staffMembers);
		sourceObjects.put("currentDate", new Date());
		sourceObjects.put("currentYear", new DateTime().toString("YYYY"));

		String rtf = documentService.createRtfDocument(
				TemplateType.Flight_data, sourceObjects);

		// Write to response
		response.setContentType("application/rtf");
		response.setHeader("content-disposition",
				"attachment;filename=" + TemplateType.Flight_data.name() + "-"
						+ flight.getFlightNumber() + ".rtf");
		response.getWriter().print(rtf);
		response.flushBuffer();

		return null;
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

}
