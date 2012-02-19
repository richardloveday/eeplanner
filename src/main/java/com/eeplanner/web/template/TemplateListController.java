package com.eeplanner.web.template;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.eeplanner.dao.template.TemplateDao;

public class TemplateListController extends AbstractController {

	private TemplateDao templateDao;
    private String viewName;

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public void setTemplateDao(TemplateDao templateDao) {
		this.templateDao = templateDao;
	}

	@Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView();
        mav.setViewName(viewName);	

		mav.addObject("templateList", templateDao.getTemplates());
        return mav;
    }

}
