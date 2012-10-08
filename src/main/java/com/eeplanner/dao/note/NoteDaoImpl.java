package com.eeplanner.dao.note;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eeplanner.datastructures.Note;
import com.eeplanner.datastructures.Contact;
import com.eeplanner.web.staff.StaffMemberController;

public class NoteDaoImpl implements NoteDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private HashMap<String, String> sqlQueries;
    Logger log = Logger.getLogger(StaffMemberController.class);

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void setSqlQueries(HashMap<String, String> sqlQueries) {
        this.sqlQueries = sqlQueries;
    }

    @Transactional
    public boolean removeNote(int id) {

        try {
            Map params = new HashMap();
            params.put("ID", id);

            String qry = sqlQueries.get("removeNote");
            this.namedParameterJdbcTemplate.update(qry, params);

            return true;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Note> getNotesListByContactID(int id) {
        try {

            String qry = sqlQueries.get("getNotesByContactID");
            List<Note> notesList = this.jdbcTemplate.query(qry, new Object[]{id}, new NoteRowMapper());

            return notesList;

        } catch (DataAccessException de) {
            log.fatal(de.getMessage());
            return null;
        }
    }

    @Transactional
    public Note storeNote(Note note) {

        SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(note);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        String qry;


        qry = sqlQueries.get("storeNewNote");


        try {
            this.namedParameterJdbcTemplate.update(qry, fileParameters, keyHolder);
        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
        }

        if (note.getID() == 0) note.setID(keyHolder.getKey().intValue());
        return note;
    }


    public List<Note> storeNotes(Contact contact) {

        List<Note> nts = new ArrayList<Note>();
        for (Note note : contact.getNotes()) {
            note.setContactID(contact.getID());
            note.setType(contact.getType());
            nts.add(storeNote(note));
        }
        return nts;
    }
}
