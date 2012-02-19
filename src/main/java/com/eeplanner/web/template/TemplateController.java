package com.eeplanner.web.template;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.multipart.support.StringMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.eeplanner.dao.template.TemplateDao;
import com.eeplanner.datastructures.Template;
import com.eeplanner.datastructures.TemplateType;
import com.eeplanner.web.EEPlannerSimpleFormController;

public class TemplateController extends EEPlannerSimpleFormController {

    private Logger log = Logger.getLogger(TemplateController.class);
    private TemplateDao templateDao;

    public void setTemplateDao(TemplateDao templateDao) {
		this.templateDao = templateDao;
	}
    
    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
    	super.initBinder(request, binder);
        binder.registerCustomEditor(String.class, "text", new StringMultipartFileEditor());
    }
    
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {

		log.fatal("submit clicked");
		Template template = (Template) command;

		template = templateDao.storeTemplate(template);
		ModelAndView mav = new ModelAndView(getSuccessView());

		if (template.getID() > 0) {
			mav.addObject("template", template);
		}

		return mav;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {

		Template template = null;

		if (ServletRequestUtils.getIntParameter(request, "id") != null) {
			template = templateDao.getTemplateById(ServletRequestUtils.getIntParameter(request, "id"));
		}
		
		return template==null ? new Template() : template;
	}

	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map model = new HashMap();

		model.put("typeList", TemplateType.values());
		
		return model;
	}

}
