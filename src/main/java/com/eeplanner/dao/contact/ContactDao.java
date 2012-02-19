package com.eeplanner.dao.contact;

import com.eeplanner.datastructures.Contact;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 07-Dec-2009
 * Time: 13:39:32
 * To change this template use File | Settings | File Templates.
 */
public interface ContactDao {

    public Contact storeContact(Contact contact) throws Exception;
    public int getContactCount();
    public Contact getContactByID(int id);
    public List<Contact> getContactListByTypeRelatedID(int relatedID, String types);
    
    public boolean removeContact(int contactID);
    public boolean removeContactEmails(int contactID);
    public boolean removeContactPhoneNumbers(int contactID);
    public boolean removeContactNotes(int contactID);
}
