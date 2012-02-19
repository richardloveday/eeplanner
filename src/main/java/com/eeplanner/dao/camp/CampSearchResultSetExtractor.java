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
                camp.setAgeRange6_7(rs.getInt("ageRange6_7"));
                camp.setAgeRange8_10(rs.getInt("ageRange8_10"));
                camp.setAgeRange11_12(rs.getInt("ageRange11_12"));
                camp.setAgeRange13_14(rs.getInt("ageRange13_14"));
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