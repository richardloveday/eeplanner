package com.eeplanner.dao.staffavailability;

import com.eeplanner.datastructures.StaffAvailability;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StaffAvailabilityRowMapper implements RowMapper<StaffAvailability> {
    public StaffAvailability mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
    	StaffAvailability staffAvailability = new StaffAvailability();
    	staffAvailability.setID(rs.getInt("staffID"));
    	staffAvailability.setYear(rs.getInt("years"));
    	staffAvailability.setAvailable1(rs.getBoolean("available1"));
    	staffAvailability.setAvailable2(rs.getBoolean("available2"));
    	staffAvailability.setAvailable3(rs.getBoolean("available3"));
    	staffAvailability.setAvailable4(rs.getBoolean("available4"));
    	staffAvailability.setAvailable5(rs.getBoolean("available5"));
    	staffAvailability.setAvailable6(rs.getBoolean("available6"));
    	staffAvailability.setAvailable7(rs.getBoolean("available7"));
    	staffAvailability.setNote(rs.getString("note"));
    	
    	return staffAvailability;
    }
}