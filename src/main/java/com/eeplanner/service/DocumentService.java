package com.eeplanner.service;

import java.util.Map;

import com.eeplanner.datastructures.TemplateType;

public interface DocumentService {

	String createRtfDocument(TemplateType documentType, Map<String, Object> sourceObjectMap) throws Exception;

}
