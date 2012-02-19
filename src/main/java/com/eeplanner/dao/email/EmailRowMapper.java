package com.eeplanner.dao.email;

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
public class EmailRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

    	Email email = new Email(rs.getInt("ID"), rs.getString("address"), rs.getString("name"));
        return email;
    }
}
