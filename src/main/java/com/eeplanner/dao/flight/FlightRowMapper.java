package com.eeplanner.dao.flight;

import com.eeplanner.datastructures.Flight;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 15-Jan-2010
 * Time: 14:29:27
 * To change this template use File | Settings | File Templates.
 */
public class FlightRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        Flight flight = new Flight();
        
        flight.setID(rs.getInt("ID"));
        flight.setCarrier(rs.getString("carrier"));
        flight.setType(rs.getString("type"));
        flight.setFlightNumber(rs.getString("flightNumber"));
        flight.setReturnFlightNumber(rs.getString("returnFlightNumber"));
        flight.setDestination(rs.getString("destination"));
        flight.setCampID(rs.getInt("campID"));
        flight.setOutboundArrival(rs.getTimestamp("outboundArrival"));
        flight.setOutboundDeparture(rs.getTimestamp("outboundDeparture"));
        flight.setReturnArrival(rs.getTimestamp("returnArrival"));
        flight.setReturnDeparture(rs.getTimestamp("returnDeparture"));
        flight.setCost(rs.getBigDecimal("cost"));
        flight.setNumberOfSeats(rs.getInt("numberOfSeats"));
        flight.setAirport(rs.getString("airport"));
        flight.setDeleted(rs.getBoolean("deleted"));
        flight.setNotes(rs.getString("notes"));

        return flight;
    }
}
