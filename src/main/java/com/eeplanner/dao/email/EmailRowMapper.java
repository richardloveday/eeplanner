package com.eeplanner.dao.email;

import com.eeplanner.datastructures.Email;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmailRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

    	Email email = new Email(rs.getInt("ID"), rs.getString("address"), rs.getString("name"));
        return email;
    }
}
