package com.eeplanner.dao.email;

import com.eeplanner.datastructures.Contact;
import com.eeplanner.datastructures.Email;
import com.eeplanner.web.staff.StaffMemberController;
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

public class EmailDaoImpl implements EmailDao {

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
    public boolean removeEmail(int id) {

        try {
            Map params = new HashMap();
            params.put("ID", id);

            String qry = sqlQueries.get("removeEmail");
            this.namedParameterJdbcTemplate.update(qry, params);

            return true;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            return false;
        }
    }


    public List<Email> storeEmails(Contact contact) {

        List<Email> emls = new ArrayList<Email>();
        for (Email email : contact.getEmails()) {
            email.setContactID(contact.getID());
            emls.add(storeEmail(email));
        }
        return emls;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Transactional
    public Email storeEmail(Email email) {

        SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(email);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String qry;


        qry = sqlQueries.get("storeNewEmail");


        try {
            this.namedParameterJdbcTemplate.update(qry, fileParameters, keyHolder);
        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
        }

        if (email.getID() == 0) email.setID(keyHolder.getKey().intValue());
        return email;
    }


    @SuppressWarnings("unchecked")
    public List<Email> getEmailListByContactID(int id) {
        try {

            String qry = sqlQueries.get("getEmailsByContactID");
            List<Email> emailsList = this.jdbcTemplate.query(qry, new Object[]{id}, new EmailRowMapper());

            return emailsList;

        } catch (DataAccessException de) {
            log.fatal(de.getMessage());
            // crap
            return null;
        }
    }
}
 