package com.eeplanner.dao.email;

import com.eeplanner.datastructures.Email;
import com.eeplanner.datastructures.Contact;

import java.util.List;

public interface EmailDao {
    public List<Email> storeEmails (Contact contact);
    public Email storeEmail (Email email);
	public List<Email> getEmailListByContactID(int id);
    public boolean removeEmail(int id);
}
