package com.eeplanner.dao.email;

import com.eeplanner.datastructures.Email;
import com.eeplanner.datastructures.Contact;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 11-Dec-2009
 * Time: 16:15:31
 * To change this template use File | Settings | File Templates.
 */
public interface EmailDao {
    public List<Email> storeEmails (Contact contact);
    public Email storeEmail (Email email);
	public List<Email> getEmailListByContactID(int id);
    public boolean removeEmail(int id);
}
