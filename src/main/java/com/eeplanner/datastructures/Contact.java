package com.eeplanner.datastructures;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 08-Dec-2009
 * Time: 15:01:01
 * To change this template use File | Settings | File Templates.
 */
public class Contact {

    private int ID;
    private String firstNames;
    private String secondName;
    private String orgName;
    private String add1;
    private String add2;
    private String add3;
    private String add4;
    private String postCode;
    private String type;
    private Date dob;
    private int relatedID;
    private String sex;
    private String accountHolderName;
    private String accountNumber;
    private String accountSortCode;
    private String nationalInsuranceNumber;
    private boolean student;
    private List<Email> emails;
    private List<Phone> phoneNumbers;
    private List<Note> notes;

    public Contact() {
    }

    public Contact(int ID, String firstNames, String secondName, String orgName, String add1, String add2, String add3,
                   String add4, String postCode, String type, Date dob, int relatedID) {
        this.ID = ID;
        this.firstNames = firstNames;
        this.secondName = secondName;
        this.orgName = orgName;
        this.add1 = add1;
        this.add2 = add2;
        this.add3 = add3;
        this.add4 = add4;
        this.postCode = postCode;
        this.type = type;
        this.dob = dob;
        this.relatedID = relatedID;
    }
    public Contact(int ID, String firstNames, String secondName, String orgName, String add1, String add2, String add3,
                   String add4, String postCode, String type, Date dob, int relatedID, String sex) {
        this.ID = ID;
        this.firstNames = firstNames;
        this.secondName = secondName;
        this.orgName = orgName;
        this.add1 = add1;
        this.add2 = add2;
        this.add3 = add3;
        this.add4 = add4;
        this.postCode = postCode;
        this.type = type;
        this.dob = dob;
        this.relatedID = relatedID;
        this.sex = sex;
    }

    public Contact(int ID, String firstNames, String secondName, String orgName, String add1, String add2, String add3,
                   String add4, String postCode, String type, Date dob, int relatedID, String sex, List<Email> emails,
                   List<Phone> phoneNumbers, List<Note> notes) {
        this.ID = ID;
        this.firstNames = firstNames;
        this.secondName = secondName;
        this.orgName = orgName;
        this.add1 = add1;
        this.add2 = add2;
        this.add3 = add3;
        this.add4 = add4;
        this.postCode = postCode;
        this.type = type;
        this.dob = dob;
        this.relatedID = relatedID;
        this.sex = sex;
        this.emails = emails;
        this.phoneNumbers = phoneNumbers;
        this.notes = notes;
    }

       
    public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Phone> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    public String getAdd3() {
        return add3;
    }

    public void setAdd3(String add3) {
        this.add3 = add3;
    }

    public String getAdd4() {
        return add4;
    }

    public void setAdd4(String add4) {
        this.add4 = add4;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getRelatedID() {
        return relatedID;
    }

    public void setRelatedID(int relatedID) {
        this.relatedID = relatedID;
    }

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountSortCode() {
		return accountSortCode;
	}

	public void setAccountSortCode(String accountSortCode) {
		this.accountSortCode = accountSortCode;
	}

	public String getNationalInsuranceNumber() {
		return nationalInsuranceNumber;
	}

	public void setNationalInsuranceNumber(String nationalInsuranceNumber) {
		this.nationalInsuranceNumber = nationalInsuranceNumber;
	}

	public boolean isStudent() {
		return student;
	}

	public void setStudent(boolean student) {
		this.student = student;
	}
    
}
