package com.eeplanner.datastructures;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 11-Dec-2009
 * Time: 12:31:26
 * To change this template use File | Settings | File Templates.
 */
public class Phone {
    private int ID;
    private String number;
    private int contactID;
    private String name;

    public Phone() {
    }

    public Phone(int ID, String number, int contactID, String name) {
        this.ID = ID;
        this.number = number;
        this.contactID = contactID;
        this.name = name;
    }

    public Phone(int ID, String number, String name) {
        this.ID = ID;
        this.number = number;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
