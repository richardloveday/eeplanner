package com.eeplanner.datastructures;

import java.sql.Date;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 11-Dec-2009
 * Time: 12:47:26
 * To change this template use File | Settings | File Templates.
 */
public class Note {

    private int ID;
    private String name;
    private String text;
    private String type;
    private int contactID;
    private Date editedDate;

    public Note(){}

    public Note(int ID, String name, String text, String type, Date editedDate) {
        this.ID = ID;
        this.name = name;
        this.text = text;
        this.type = type;
        this.editedDate = editedDate;
    }

    public Note(int ID, String name, String text, String type, int contactID, Date editedDate) {
        this.ID = ID;
        this.name = name;
        this.text = text;
        this.type = type;
        this.contactID = contactID;
        this.editedDate = editedDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    

    public int getContactID() {
		return contactID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public Date getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(Date editedDate) {
        this.editedDate = editedDate;
    }
}
