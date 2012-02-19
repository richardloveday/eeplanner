package com.eeplanner.web.template;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eeplanner.dao.template.TemplateDao;
import com.eeplanner.datastructures.Template;

public class TemplateValidator implements Validator {

	protected TemplateDao templateDao;
	
	public void setTemplateDao(TemplateDao templateDao) {
		this.templateDao = templateDao;
	}

	public boolean supports(Class clazz) {
		return Template.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Template template = (Template)target;
		 
		if(StringUtils.isBlank(template.getText())){
			errors.rejectValue("text", "required");
		}
		if(StringUtils.isBlank(template.getType())){
			errors.rejectValue("type", "required");
		}else{
			Template templateByType = templateDao.getTemplateByType(template.getType());
			if(templateByType!=null && templateByType.getID()!=template.getID()){
				errors.rejectValue("type", "dublicate");
			}
		}
	}

}
