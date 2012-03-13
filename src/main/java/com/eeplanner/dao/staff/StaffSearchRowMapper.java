package com.eeplanner.dao.staff;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.Contact;
import com.eeplanner.datastructures.Flight;
import com.eeplanner.datastructures.StaffMember;
import com.eeplanner.datastructures.StaffMemberSearchData;

public class StaffSearchRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        StaffMemberSearchData data = new StaffMemberSearchData();
        data.setCamp(new Camp());
        data.setFlight(new Flight());
        data.setStaffMember(new StaffMember());
        
        data.getStaffMember().setID(rs.getInt("staffMemberID"));
        data.getFlight().setID(rs.getInt("flightID"));
        data.getCamp().setID(rs.getInt("campID"));
        
        data.getStaffMember().setDeleted(rs.getBoolean("deleted"));
        
        data.getStaffMember().getContact().setID(rs.getInt("staffMemberContactID"));
        data.getStaffMember().getContact().setFirstNames(rs.getString("staffMemberFirstNames"));
        data.getStaffMember().getContact().setSecondName(rs.getString("staffMemberSecondName"));

        data.getCamp().setName(rs.getString("campName"));
        data.getCamp().setStart(rs.getTimestamp("start"));
        data.getCamp().setEnd(rs.getTimestamp("end"));
        data.getCamp().getContact().setOrgName(rs.getString("campContactOrgName"));

        data.getFlight().setType(rs.getString("flightType"));
        data.getFlight().setOutboundArrival(rs.getTimestamp("outboundArrival"));
        data.getFlight().setOutboundDeparture(rs.getTimestamp("outboundDeparture"));
        data.getFlight().setReturnArrival(rs.getTimestamp("returnArrival"));
        data.getFlight().setReturnDeparture(rs.getTimestamp("returnDeparture"));
        data.getFlight().setDestination(rs.getString("destination"));
        data.getFlight().setFlightNumber(rs.getString("flightNumber"));

        return data;
    }
}