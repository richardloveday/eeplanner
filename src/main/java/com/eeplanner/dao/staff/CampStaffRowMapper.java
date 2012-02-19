package com.eeplanner.dao.staff;

import com.eeplanner.datastructures.Contact;
import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.StaffMember;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 27-Jan-2010
 * Time: 11:26:16
 * To change this template use File | Settings | File Templates.
 */
public class CampStaffRowMapper implements RowMapper {   
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        StaffMember staffMember = new StaffMember();
        staffMember.setID(rs.getInt("ID"));
        staffMember.setTeacher(rs.getBoolean("teacher"));
        staffMember.setCoordinator(rs.getBoolean("coordinator"));
        staffMember.setDrama(rs.getBoolean("drama"));
        staffMember.setActivityleader(rs.getBoolean("activityleader"));
        staffMember.setActivityCoordinator(rs.getBoolean("activityCoordinator"));
        staffMember.setDptCoordinator(rs.getBoolean("dptCoordinator"));
        staffMember.setCourseSpecialist(rs.getBoolean("courseSpecialist"));
        staffMember.setKinName(rs.getString("kinName"));
        staffMember.setKinNumber(rs.getString("kinNumber"));  
        staffMember.setArchivePassword(rs.getString("archivePassword"));
        staffMember.setExisting(rs.getBoolean("existing"));
        staffMember.setStatus(rs.getString("status"));
        staffMember.setDeleted(rs.getBoolean("deleted"));

        staffMember.setAccepted(rs.getBoolean("accepted"));
        staffMember.setOffered(rs.getBoolean("offered"));
        staffMember.setReturned(rs.getBoolean("returned"));
        staffMember.setJob(rs.getString("job"));
        
        Contact contact = new Contact();
        contact.setID(rs.getInt("contactID"));
        contact.setFirstNames(rs.getString("firstNames"));
        contact.setSecondName(rs.getString("secondName"));
        contact.setAdd1(rs.getString("add1"));
        contact.setAdd2(rs.getString("add2"));
        contact.setAdd3(rs.getString("add3"));
        contact.setAdd4(rs.getString("add4"));
        contact.setPostCode(rs.getString("postCode"));
        contact.setDob(rs.getTimestamp("dob"));
        contact.setSex(rs.getString("sex"));

        Camp camp = new Camp();
        camp.setID(rs.getInt("campID"));
        camp.setName(rs.getString("campName"));
        camp.setStart(rs.getTimestamp("start"));
        camp.setEnd(rs.getTimestamp("end"));

        staffMember.setContact(contact);
        staffMember.setCamp(camp);


        return staffMember;
    }
}