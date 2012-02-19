package com.eeplanner.datastructures;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 11-Dec-2009
 * Time: 12:31:32
 * To change this template use File | Settings | File Templates.
 */
public class Email {
    private int ID;
    private String address;
    private int contactID;
    private String name;

    public Email(){}

    public Email(int ID, String address, int contactID, String name) {
        this.ID = ID;
        this.address = address;
        this.contactID = contactID;
        this.name = name;
    }

    public Email(int ID, String address, String name) {
        this.ID = ID;
        this.address = address;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
