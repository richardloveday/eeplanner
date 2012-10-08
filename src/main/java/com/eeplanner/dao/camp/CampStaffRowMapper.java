package com.eeplanner.dao.camp;

import com.eeplanner.datastructures.CampStaff;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CampStaffRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        CampStaff campStaff = new CampStaff();
        campStaff.setCampID(rs.getInt("campID"));
        campStaff.setStaffID(rs.getInt("staffID"));

        campStaff.setOffered(rs.getBoolean("offered"));
        campStaff.setReturned(rs.getBoolean("returned"));
        campStaff.setAccepted(rs.getBoolean("accepted"));
        campStaff.setJob(rs.getString("job"));
        campStaff.setContractDate(rs.getDate("contract_date"));

        return campStaff;
    }
}
