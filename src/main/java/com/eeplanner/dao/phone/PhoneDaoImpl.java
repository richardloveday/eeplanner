package com.eeplanner.dao.phone;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eeplanner.datastructures.Phone;
import com.eeplanner.datastructures.Contact;
import com.eeplanner.web.staff.StaffMemberController;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 11-Dec-2009
 * Time: 16:17:04
 * To change this template use File | Settings | File Templates.
 */
public class PhoneDaoImpl implements PhoneDao {

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

    public boolean removePhoneNumber(int id) {

        try {
            Map params = new HashMap();
            params.put("ID", id);

            String qry = sqlQueries.get("removePhoneNumber");
            this.namedParameterJdbcTemplate.update(qry, params);

            return true;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            return false;
        }
    }

    public List<Phone> storePhoneNumbers(Contact contact) {

        List<Phone> numbers = new ArrayList<Phone>();
        for (Phone phoneNumber : contact.getPhoneNumbers()) {
            phoneNumber.setContactID(contact.getID());
            numbers.add(storePhoneNumber(phoneNumber));
        }
        return numbers;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @SuppressWarnings("unchecked")
    public List<Phone> getPhoneNumberListByContactID(int id) {
        try {

            String qry = sqlQueries.get("getPhoneNumbersByContactID");
            List<Phone> phoneList = this.jdbcTemplate.query(qry, new Object[]{id}, new PhoneRowMapper());

            return phoneList;

        } catch (DataAccessException de) {
            log.fatal(de.getMessage());
            // crap
            return null;
        }
    }

    public Phone storePhoneNumber(Phone phoneNumber) {

        SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(phoneNumber);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String qry;

        qry = sqlQueries.get("storeNewPhoneNumber");

        try {
            this.namedParameterJdbcTemplate.update(qry, fileParameters, keyHolder);
        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
        }

        if (phoneNumber.getID() == 0) phoneNumber.setID(keyHolder.getKey().intValue());
        return phoneNumber;
    }

}
