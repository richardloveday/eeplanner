package com.eeplanner.domain;

import javax.persistence.*;

@IdClass(com.eeplanner.domain.StaffavailabilityEntityPK.class)
@Table(name = "staffavailability")
@Entity
public class StaffavailabilityEntity {
    private int staffId;

    @Column(name = "staffID")
    @Id
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    private int years;

    @Column(name = "years")
    @Id
    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    private byte available1;

    @Column(name = "available1")
    @Basic
    public byte getAvailable1() {
        return available1;
    }

    public void setAvailable1(byte available1) {
        this.available1 = available1;
    }

    private byte available2;

    @Column(name = "available2")
    @Basic
    public byte getAvailable2() {
        return available2;
    }

    public void setAvailable2(byte available2) {
        this.available2 = available2;
    }

    private byte available3;

    @Column(name = "available3")
    @Basic
    public byte getAvailable3() {
        return available3;
    }

    public void setAvailable3(byte available3) {
        this.available3 = available3;
    }

    private byte available4;

    @Column(name = "available4")
    @Basic
    public byte getAvailable4() {
        return available4;
    }

    public void setAvailable4(byte available4) {
        this.available4 = available4;
    }

    private byte available5;

    @Column(name = "available5")
    @Basic
    public byte getAvailable5() {
        return available5;
    }

    public void setAvailable5(byte available5) {
        this.available5 = available5;
    }

    private byte available6;

    @Column(name = "available6")
    @Basic
    public byte getAvailable6() {
        return available6;
    }

    public void setAvailable6(byte available6) {
        this.available6 = available6;
    }

    private byte available7;

    @Column(name = "available7")
    @Basic
    public byte getAvailable7() {
        return available7;
    }

    public void setAvailable7(byte available7) {
        this.available7 = available7;
    }

    private String note;

    @Column(name = "note")
    @Basic
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaffavailabilityEntity that = (StaffavailabilityEntity) o;

        if (available1 != that.available1) return false;
        if (available2 != that.available2) return false;
        if (available3 != that.available3) return false;
        if (available4 != that.available4) return false;
        if (available5 != that.available5) return false;
        if (available6 != that.available6) return false;
        if (available7 != that.available7) return false;
        if (staffId != that.staffId) return false;
        if (years != that.years) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = staffId;
        result = 31 * result + years;
        result = 31 * result + (int) available1;
        result = 31 * result + (int) available2;
        result = 31 * result + (int) available3;
        result = 31 * result + (int) available4;
        result = 31 * result + (int) available5;
        result = 31 * result + (int) available6;
        result = 31 * result + (int) available7;
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
