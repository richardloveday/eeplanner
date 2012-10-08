package com.eeplanner.dao.contact;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataAccessException;
import org.apache.log4j.Logger;
import com.eeplanner.datastructures.Contact;
import com.eeplanner.datastructures.Phone;
import com.eeplanner.datastructures.Email;
import com.eeplanner.datastructures.Note;
import com.eeplanner.dao.phone.PhoneDao;
import com.eeplanner.dao.email.EmailDao;
import com.eeplanner.dao.note.NoteDao;


import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class ContactDaoImpl implements ContactDao {

    //JdbcTemplate jdbcTemplate = getJdbcTemplate();
    Logger log = Logger.getLogger(ContactDaoImpl.class);
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private HashMap<String, String> sqlQueries;
    private PhoneDao phoneDao;
    private EmailDao emailDao;
    private NoteDao noteDao;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void setSqlQueries(HashMap<String, String> sqlQueries) {
        this.sqlQueries = sqlQueries;
    }

    public int getContactCount() {
        try {
            return this.jdbcTemplate.queryForInt("select count(ID) from contact");
        } catch (DataAccessException de) {
            // crap
            return -1;
        }
    }

    public Contact getContactByID(int id) {
        try {

            Contact contact = (Contact) this.jdbcTemplate.queryForObject(sqlQueries.get("getContactByID"),
                    new Object[]{id}, new ContactRowMapper());

            return contact;

        } catch (DataAccessException de) {
            // crap
            return null;
        }
    }

    public List<Contact> getContactListByTypeRelatedID(int relatedID, String type) {

        try {

            String qry = sqlQueries.get("getContactsByTypeRelatedID");
            Map params = new HashMap();
            params.put("relatedID", relatedID);
            params.put("type", type);
            List<Contact> contactList = this.namedParameterJdbcTemplate.query(qry, params, new ContactRowMapper());

            return getNumbersEmailsNotesForContacts(contactList);

        } catch (DataAccessException de) {
            log.fatal(de.getMessage());
            // crap
            return null;
        }
    }

    @Transactional
    public Contact storeContact(Contact contact) throws DataAccessException {

        SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(contact);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String qry;

        if (contact.getID() > 0) {
            qry = sqlQueries.get("editContact");
        } else {
            qry = sqlQueries.get("storeNewContact");
        }

        try {
            this.namedParameterJdbcTemplate.update(qry, fileParameters, keyHolder);
        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
        }

        if (contact.getID() == 0) contact.setID(keyHolder.getKey().intValue());
        return contact;
    }
    
    @Transactional
    public boolean removeContact(int contactID) {
    	try {
    		Map params = new HashMap();
    		params.put("ID", contactID);

    		String qry = sqlQueries.get("permanentlyDelete");
    		this.namedParameterJdbcTemplate.update(qry, params);

    		return true;

    	} catch (DataAccessException e) {
    		log.fatal(e.getMessage());
    		return false;
    	}
	}

    @Transactional
    public boolean removeContactEmails(int contactID) {

        try {
            Map params = new HashMap();
            params.put("contactID", contactID);

            String qry = sqlQueries.get("removeContactEmails");
            this.namedParameterJdbcTemplate.update(qry, params);

            return true;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            return false;
        }
    }
    
    @Transactional
    public boolean removeContactPhoneNumbers(int contactID) {

        try {
            Map params = new HashMap();
            params.put("contactID", contactID);

            String qry = sqlQueries.get("removeContactPhoneNumbers");
            this.namedParameterJdbcTemplate.update(qry, params);

            return true;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            return false;
        }
    }
    
    @Transactional
    public boolean removeContactNotes(int contactID) {

        try {
            Map params = new HashMap();
            params.put("contactID", contactID);

            String qry = sqlQueries.get("removeContactNotes");
            this.namedParameterJdbcTemplate.update(qry, params);

            return true;

        } catch (DataAccessException e) {
            log.fatal(e.getMessage());
            return false;
        }
    }

    private List<Contact> getNumbersEmailsNotesForContacts(List<Contact> contacts) {
        List<Contact> newContactList = new ArrayList();

        List<Phone> phoneNumbers;
        List<Email> emails;
        List<Note> notes;

            for (Contact contact : contacts) {
                emails = emailDao.getEmailListByContactID(contact.getID());
                notes = noteDao.getNotesListByContactID(contact.getID());
                phoneNumbers = phoneDao.getPhoneNumberListByContactID(contact.getID());
                contact.setPhoneNumbers(phoneNumbers);
                contact.setEmails(emails);
                contact.setNotes(notes);
                newContactList.add(contact);
            }
        return newContactList;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setPhoneDao(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    public void setEmailDao(EmailDao emailDao) {
        this.emailDao = emailDao;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

}
