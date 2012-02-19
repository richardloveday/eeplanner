package com.eeplanner.datastructures;

import java.util.Date;


public class Template {

	protected int ID;
	protected String type;
	protected String text;
	protected Date editedDate;

    public Template(){}

    public Template(int ID, TemplateType type, String text, Date editedDate) {
        this.ID = ID;
        this.type = type.name();
        this.text = text;
        this.editedDate = editedDate;
    }
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getEditedDate() {
		return editedDate;
	}

	public void setEditedDate(Date editedDate) {
		this.editedDate = editedDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
}
