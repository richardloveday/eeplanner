package com.eeplanner.dao.phone;

import com.eeplanner.datastructures.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 10-Dec-2009
 * Time: 14:58:13
 * To change this template use File | Settings | File Templates.
 */
public class PhoneRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        Phone phone = new Phone(rs.getInt("ID"), rs.getString("number"), rs.getInt("contactID"), rs.getString("name"));
        return phone;
    }
}
