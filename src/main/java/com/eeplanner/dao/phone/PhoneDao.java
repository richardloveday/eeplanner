package com.eeplanner.dao.phone;

import com.eeplanner.datastructures.Phone;
import com.eeplanner.datastructures.Contact;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 11-Dec-2009
 * Time: 16:16:54
 * To change this template use File | Settings | File Templates.
 */
public interface PhoneDao {

    public List<Phone> storePhoneNumbers(Contact contact);
    public Phone storePhoneNumber(Phone phoneNumber);
	public List<Phone> getPhoneNumberListByContactID(int id);
    public boolean removePhoneNumber(int id);
}
