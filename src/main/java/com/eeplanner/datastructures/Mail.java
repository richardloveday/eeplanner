package com.eeplanner.datastructures;

public class Mail {
    private int ID;
    private String subject;
    private String message;
    private boolean deleted;
    private String status;
    private String contacts;
	
    public Mail() {
    	super();
    }
    
	public Mail(int iD, String subject, String message) {
		super();
		ID = iD;
		this.subject = subject;
		this.message = message;
	}

	public Mail(int iD, String subject, String message, boolean deleted,
			String status, String contacts) {
		super();
		ID = iD;
		this.subject = subject;
		this.message = message;
		this.deleted = deleted;
		this.status = status;
		this.contacts = contacts;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	public boolean isDeleted() {
		return deleted;
	}



	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
    
    
    
    
}
