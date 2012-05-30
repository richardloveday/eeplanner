package com.eeplanner.domain;

import javax.persistence.*;
import java.io.Serializable;


public class StaffavailabilityEntityPK implements Serializable {
    private int staffId;

    @Id
    @Column(name = "staffID")
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    private int years;

    @Id
    @Column(name = "years")
    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaffavailabilityEntityPK that = (StaffavailabilityEntityPK) o;

        if (staffId != that.staffId) return false;
        if (years != that.years) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = staffId;
        result = 31 * result + years;
        return result;
    }
}
