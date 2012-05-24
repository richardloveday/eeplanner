package com.eeplanner.dao.camp;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.Contact;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 11-Jan-2010
 * Time: 15:11:20
 * To change this template use File | Settings | File Templates.
 */
public class CampRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        Contact contact = new Contact();
        contact.setID(rs.getInt("contactID"));
        Contact schoolContact = new Contact();
        schoolContact.setID(rs.getInt("schoolContactID"));

        Camp camp = new Camp();
        camp.setID(rs.getInt("ID"));
        camp.setName(rs.getString("name"));
        camp.setStart(rs.getDate("start"));
        camp.setEnd(rs.getDate("end"));
        camp.setStudentNumber(rs.getInt("studentNumber"));
        camp.setCoordinatorsNeeded(rs.getInt("coordinatorsNeeded"));
        camp.setTeachersNeeded(rs.getInt("teachersNeeded"));
        camp.setDramaTeachersNeeded(rs.getInt("dramaTeachersNeeded"));
        camp.setActivityLeadersNeeded(rs.getInt("activityLeadersNeeded"));
        camp.setActivityCoordinatorsNeeded(rs.getInt("activityCoordinatorsNeeded"));
        camp.setDptCoordinatorsNeeded(rs.getInt("dptCoordinatorsNeeded"));
        camp.setCourseSpecialistsNeeded(rs.getInt("courseSpecialistsNeeded"));
        camp.setLegacyID(rs.getInt("legacyID"));
        camp.setSiblingNumber(rs.getInt("siblingNumber"));
        camp.setStudentLevel1(rs.getInt("studentLevel1"));
        camp.setStudentLevel2(rs.getInt("studentLevel2"));
        camp.setStudentLevel3(rs.getInt("studentLevel3"));
        camp.setStudentLevel4(rs.getInt("studentLevel4"));
        camp.setStudentLevel5(rs.getInt("studentLevel5"));
        camp.setStudentLevel6(rs.getInt("studentLevel6"));
        camp.setStudentLevel7(rs.getInt("studentLevel7"));
        camp.setStudentLevel8(rs.getInt("studentLevel8"));
        
        camp.setSplitRoleNeeded(rs.getInt("splitRoleNeeded"));
        camp.setOtherNotes(rs.getString("otherNotes"));
        camp.setHeadTeacher(rs.getString("headTeacher"));
        camp.setAdminSchoolName(rs.getString("adminSchoolName"));
        camp.setAdminSchoolAddress(rs.getString("adminSchoolAddress"));
        camp.setTimetablingNotes(rs.getString("timetablingNotes"));
        camp.setFinalRegLastYear(rs.getInt("finalRegLastYear"));
        camp.setFinalRegCurrentYear(rs.getInt("finalRegCurrentYear"));
        
        camp.setForwardingDate(rs.getDate("forwardingDate"));
        camp.setDeliveryDate(rs.getDate("deliveryDate"));
        camp.setDeleted(rs.getBoolean("deleted"));
        camp.setPredictedStudents(rs.getInt("predictedStudents"));
        camp.setStudentRegistrations(rs.getInt("studentRegistrations"));
        camp.setDateStamp(rs.getDate("dateStamp"));
        camp.setStudents2Week(rs.getInt("students2Week"));
        camp.setStudents1week(rs.getInt("students1week"));   
        camp.setContactID(rs.getInt("contactID"));
        camp.setSchoolContactID(rs.getInt("schoolContactID"));
        camp.setContact(contact);
        camp.setDailyHours(rs.getString("dailyHours"));
        camp.setPresentationTime(rs.getString("presentationTime"));
        camp.setMaterialsSent(rs.getString("materialsSent"));
        camp.setItemsSent(rs.getString("itemsSent"));
        camp.setTimeReceived(rs.getString("timeReceived"));
        camp.setSignature(rs.getString("signature"));
        camp.setSchoolPhone(rs.getInt("schoolPhone"));
        camp.setSchoolFax(rs.getInt("schoolFax"));
        camp.setSchoolEmail(rs.getString("schoolEmail"));

        
        return camp;
    }
}
