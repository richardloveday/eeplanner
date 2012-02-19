package com.eeplanner.dao.itinerary;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eeplanner.datastructures.Itinerary;
import com.eeplanner.datastructures.StaffMember;

public class ItineraryRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

		Itinerary itinerary = new Itinerary();
		itinerary.setID(rs.getInt("ID"));
		itinerary.setName(rs.getString("name"));
		itinerary.setStaffID(rs.getInt("staff_id"));
		itinerary.setStaffID(rs.getInt("camp_id"));
		itinerary.setTransfer1ID(rs.getInt("transfer_1_id"));
		itinerary.setTransfer2ID(rs.getInt("transfer_2_id"));
		itinerary.setFlightID(rs.getInt("flight_id"));
		itinerary.setYear(rs.getInt("year"));
		itinerary.setDeleted(rs.getBoolean("deleted"));
		
		return itinerary;

	}

}
