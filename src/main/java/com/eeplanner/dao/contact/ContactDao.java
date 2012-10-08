package com.eeplanner.dao.contact;

import com.eeplanner.datastructures.Contact;

import java.util.List;

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
