package com.eeplanner.dao.note;

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
public class NoteRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        Note note = new Note(rs.getInt("ID"), rs.getString("name"), rs.getString("text"),
                rs.getString("type"), rs.getInt("contactID"), rs.getDate("editedDate"));

        return note;
    }
}
