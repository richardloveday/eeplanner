package com.eeplanner.web.template;

import com.eeplanner.datastructures.Template;

public class TemplateUploadBean extends Template {

	private byte[] file;
	
	public TemplateUploadBean() {
	}

	public TemplateUploadBean(Template template) {
		this.ID = template.getID();
		this.type = template.getType();
		this.text = template.getText();
		this.editedDate = template.getEditedDate();
	}

    public void setFile(byte[] file) {
        this.file = file;
    }

    public byte[] getFile() {
        return file;
    }
}
