package com.eeplanner.dao.template;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eeplanner.datastructures.Template;

public class TemplateRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        Template template = new Template();

        template.setID(rs.getInt("id"));
        template.setText(rs.getString("text"));
        template.setEditedDate(rs.getDate("edited_date"));
    	template.setType(rs.getString("type"));
    	
        return template;
    }

}
