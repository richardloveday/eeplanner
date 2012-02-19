package com.eeplanner.dao.transfer;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.eeplanner.datastructures.Transfer;

public class TransferRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        Transfer transfer = new Transfer();

        transfer.setID(rs.getInt("id"));
        transfer.setOutboundType(rs.getString("outbound_type"));
        transfer.setOutboundReference(rs.getString("outbound_reference"));
        transfer.setOutboundDeparture(rs.getTimestamp("outbound_departure"));
        transfer.setOutboundDeparturePoint(rs.getString("outbound_departure_point"));
        transfer.setOutboundArrival(rs.getTimestamp("outbound_arrival"));
        transfer.setOutboundArrivalPoint(rs.getString("outbound_arrival_point"));
        transfer.setOutboundNotes(rs.getString("outbound_notes"));
        transfer.setReturnType(rs.getString("return_type"));
        transfer.setReturnReference(rs.getString("return_reference"));
        transfer.setReturnDeparture(rs.getTimestamp("return_departure"));
        transfer.setReturnDeparturePoint(rs.getString("return_departure_point"));
        transfer.setReturnArrival(rs.getTimestamp("return_arrival"));
        transfer.setReturnArrivalPoint(rs.getString("return_arrival_point"));
        transfer.setReturnNotes(rs.getString("return_notes"));
        transfer.setDeleted(rs.getBoolean("deleted"));

        return transfer;

    }

}
