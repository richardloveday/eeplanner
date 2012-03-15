package com.eeplanner.service;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class DateTool {

	public String toTime(Date date){
		if(date==null)
			return StringUtils.EMPTY;
		return new LocalTime(date.getTime()).toString("HH:mm");
	}
	
	public String toDate(Date date){
		if(date==null)
			return StringUtils.EMPTY;
		return new LocalDate(date.getTime()).toString("dd/MM/yyyy");
	}
}
