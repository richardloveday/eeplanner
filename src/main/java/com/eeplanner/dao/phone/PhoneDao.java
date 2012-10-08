package com.eeplanner.dao.phone;

import com.eeplanner.datastructures.Phone;
import com.eeplanner.datastructures.Contact;

import java.util.List;

public interface PhoneDao {

    public List<Phone> storePhoneNumbers(Contact contact);
    public Phone storePhoneNumber(Phone phoneNumber);
	public List<Phone> getPhoneNumberListByContactID(int id);
    public boolean removePhoneNumber(int id);
}
