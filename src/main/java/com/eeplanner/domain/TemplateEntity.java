package com.eeplanner.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * User: iviec01
 * Date: 30/05/2012
 * Time: 16:17
 */
@Table(name = "template")
@Entity
public class TemplateEntity {
    private int id;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String type;

    @Column(name = "type")
    @Basic
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String text;

    @Column(name = "text")
    @Basic
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private Timestamp editedDate;

    @Column(name = "edited_date")
    @Basic
    public Timestamp getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(Timestamp editedDate) {
        this.editedDate = editedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemplateEntity that = (TemplateEntity) o;

        if (id != that.id) return false;
        if (editedDate != null ? !editedDate.equals(that.editedDate) : that.editedDate != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (editedDate != null ? editedDate.hashCode() : 0);
        return result;
    }
}
