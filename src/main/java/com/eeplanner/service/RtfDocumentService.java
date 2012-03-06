package com.eeplanner.service;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import net.sourceforge.rtf.RTFTemplate;
import net.sourceforge.rtf.helper.RTFTemplateBuilder;

import org.springframework.util.CollectionUtils;

import com.eeplanner.dao.template.TemplateDao;
import com.eeplanner.datastructures.TemplateType;

public class RtfDocumentService implements DocumentService {

	private TemplateDao templateDao;
	
	public void setTemplateDao(TemplateDao templateDao) {
		this.templateDao = templateDao;
	}

    public String createRtfDocument(TemplateType documentType, Map<String, Object> sourceObjectMap) throws Exception {

		// 1. Get default RTFtemplateBuilder
		RTFTemplateBuilder builder = RTFTemplateBuilder.newRTFTemplateBuilder();

		// 2. Get RTFtemplate with default Implementation of template engine (Freemarker)
		RTFTemplate rtfTemplate = builder.newRTFTemplate();

		// 3. Set the RTF model source
		StringReader reader = new StringReader(templateDao.getTemplateByType(documentType.name()).getText());
		rtfTemplate.setTemplate(reader);

		// 4. Put the context
		if(!CollectionUtils.isEmpty(sourceObjectMap)){
			for(String objectName : sourceObjectMap.keySet()){
				rtfTemplate.put(objectName, sourceObjectMap.get(objectName));				
			}
		}
		
		// 5. Merge the RTF source model and the context
		Writer writer = new StringWriter();
		rtfTemplate.merge(writer);

		return writer.toString();
	}

}
