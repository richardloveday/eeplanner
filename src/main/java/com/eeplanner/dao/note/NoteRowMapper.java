package com.eeplanner.dao.note;

import com.eeplanner.datastructures.Note;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoteRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        Note note = new Note(rs.getInt("ID"), rs.getString("name"), rs.getString("text"),
                rs.getString("type"), rs.getInt("contactID"), rs.getDate("editedDate"));

        return note;
    }
}
