package com.eeplanner.dao.camp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.StaffMember;

public class CampSearchResultSetExtractor implements ResultSetExtractor{

    public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
       
        Map<String, Camp> map = new TreeMap<String, Camp>();
        Camp camp = null;
        while(rs.next()){
            String key = "";
            if(rs.getDate("start")!=null){
                key = rs.getDate("start").getTime()+"_"+rs.getInt("ID");
            }else{
                key = new Date().getTime()+"_"+rs.getInt("ID");   
            }
           
            //Integer id = rs.getInt("ID");
            camp = map.get(key);
            if(camp == null){
                camp = new Camp();
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
                camp.setStaffMembers(new ArrayList<StaffMember>());
            }
            StaffMember staffMember = new StaffMember();
            staffMember.setAccepted(rs.getBoolean("accepted"));
            staffMember.setOffered(rs.getBoolean("offered"));
            staffMember.setReturned(rs.getBoolean("returned"));
            staffMember.setJob(rs.getString("job"));
            staffMember.setID(rs.getInt("staffID"));
            camp.getStaffMembers().add(staffMember);

            map.put(key, camp);
        }
        List<Camp> camps = new ArrayList<Camp>(map.values());
        Collections.reverse(camps);
        return camps;
    }

}