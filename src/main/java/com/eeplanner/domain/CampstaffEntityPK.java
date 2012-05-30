package com.eeplanner.domain;

import javax.persistence.*;
import java.io.Serializable;

public class CampstaffEntityPK implements Serializable {
    private int staffId;

    @Id
    @Column(name = "staffID")
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    private int campId;

    @Id
    @Column(name = "campID")
    public int getCampId() {
        return campId;
    }

    public void setCampId(int campId) {
        this.campId = campId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CampstaffEntityPK that = (CampstaffEntityPK) o;

        if (campId != that.campId) return false;
        if (staffId != that.staffId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = staffId;
        result = 31 * result + campId;
        return result;
    }
}
