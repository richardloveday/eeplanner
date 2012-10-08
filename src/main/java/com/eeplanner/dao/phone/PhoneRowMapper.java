package com.eeplanner.dao.phone;

import com.eeplanner.datastructures.Phone;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        Phone phone = new Phone(rs.getInt("ID"), rs.getString("number"), rs.getInt("contactID"), rs.getString("name"));
        return phone;
    }
}
