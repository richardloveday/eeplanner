package com.eeplanner.dao.camp;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eeplanner.datastructures.CampStaff;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 11-Jan-2010
 * Time: 15:11:20
 * To change this template use File | Settings | File Templates.
 */
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
