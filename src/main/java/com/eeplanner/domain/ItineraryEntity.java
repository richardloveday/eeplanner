package com.eeplanner.domain;

import javax.persistence.*;


@Table(name = "itinerary")
@Entity
public class ItineraryEntity {
    private int id;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    @Column(name = "name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int staffId;

    @Column(name = "staff_id")
    @Basic
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    private int year;

    @Column(name = "year")
    @Basic
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private byte deleted;

    @Column(name = "deleted")
    @Basic
    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    private int campId;

    @Column(name = "camp_id")
    @Basic
    public int getCampId() {
        return campId;
    }

    public void setCampId(int campId) {
        this.campId = campId;
    }

    private int flightId;

    @Column(name = "flight_id")
    @Basic
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    private String notes;

    @Column(name = "notes")
    @Basic
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItineraryEntity that = (ItineraryEntity) o;

        if (campId != that.campId) return false;
        if (deleted != that.deleted) return false;
        if (flightId != that.flightId) return false;
        if (id != that.id) return false;
        if (staffId != that.staffId) return false;
        if (year != that.year) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + staffId;
        result = 31 * result + year;
        result = 31 * result + (int) deleted;
        result = 31 * result + campId;
        result = 31 * result + flightId;
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
