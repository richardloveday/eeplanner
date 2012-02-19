package com.eeplanner.web.template;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.eeplanner.dao.camp.CampDao;
import com.eeplanner.dao.staff.StaffDao;
import com.eeplanner.dao.template.TemplateDao;
import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.CampStaff;
import com.eeplanner.datastructures.StaffMember;
import com.eeplanner.datastructures.Template;
import com.eeplanner.datastructures.TemplateType;
import com.eeplanner.service.DocumentService;

public class RtfGeneratorController extends MultiActionController {

	private DocumentService documentService;
	private StaffDao staffDao;
	private TemplateDao templateDao;
	private CampDao campDao;

	public ModelAndView generateStaffContract(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int staffId = ServletRequestUtils.getIntParameter(request, "staffMemberID");
		int campId = ServletRequestUtils.getIntParameter(request, "campID");
		StaffMember staff = staffDao.getStaffMemberByID(staffId);
		Camp camp = campDao.getCampByID(campId);
		CampStaff campStaff = campDao.getCampStaff(campId, staffId);

		if(campStaff.getContractDate()==null){
			campStaff.setContractDate(new Date());
			campDao.editCampStaffMember(campStaff);
		}

		Map<String, Object> sourceObjects = new HashMap<String, Object>();
		sourceObjects.put("staff", staff);
		sourceObjects.put("camp", camp);
		sourceObjects.put("campStaff", campStaff);
		sourceObjects.put("currentDate", new Date());

		String rtf = documentService.createRtfDocument(TemplateType.Contract_of_a_staff_member, sourceObjects);

		// Write to response
		response.setContentType("application/rtf");
		response.setHeader("content-disposition", "attachment;filename=Contract-" + staff.getContact().getFirstNames()
				+ staff.getContact().getSecondName() + ".rtf");
		response.getWriter().print(rtf);
		response.flushBuffer();

		return null;
	}

	public ModelAndView viewTemplateDocument(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int id = ServletRequestUtils.getIntParameter(request, "id");
		Template template = templateDao.getTemplateById(id);


		// Write to response
		response.setContentType("application/rtf");
		response.setHeader("content-disposition", "attachment;filename=" + template.getType() + ".rtf");
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

}
