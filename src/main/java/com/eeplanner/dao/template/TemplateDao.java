package com.eeplanner.dao.template;

import java.util.List;

import com.eeplanner.datastructures.Template;
import com.eeplanner.datastructures.TemplateType;

public interface TemplateDao {
	public List<Template> getTemplates();
    public Template storeTemplate(Template template);
    public Template getTemplateById(int id);
    public Template getTemplateByType(String type);
}
