package com.eeplanner.domain;


import javax.persistence.*;
import java.sql.Date;


@IdClass(com.eeplanner.domain.CampstaffEntityPK.class)
@Table(name = "campstaff")
@Entity
public class CampstaffEntity {
    private int staffId;

    @Column(name = "staffID")
    @Id
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    private int campId;

    @Column(name = "campID")
    @Id
    public int getCampId() {
        return campId;
    }

    public void setCampId(int campId) {
        this.campId = campId;
    }

    private int offered;

    @Column(name = "offered")
    @Basic
    public int getOffered() {
        return offered;
    }

    public void setOffered(int offered) {
        this.offered = offered;
    }

    private int accepted;

    @Column(name = "accepted")
    @Basic
    public int getAccepted() {
        return accepted;
    }

    public void setAccepted(int accepted) {
        this.accepted = accepted;
    }

    private String job;

    @Column(name = "job")
    @Basic
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    private int returned;

    @Column(name = "returned")
    @Basic
    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    private Date contractDate;

    @Column(name = "contract_date")
    @Basic
    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CampstaffEntity that = (CampstaffEntity) o;

        if (accepted != that.accepted) return false;
        if (campId != that.campId) return false;
        if (offered != that.offered) return false;
        if (returned != that.returned) return false;
        if (staffId != that.staffId) return false;
        if (contractDate != null ? !contractDate.equals(that.contractDate) : that.contractDate != null) return false;
        if (job != null ? !job.equals(that.job) : that.job != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = staffId;
        result = 31 * result + campId;
        result = 31 * result + offered;
        result = 31 * result + accepted;
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + returned;
        result = 31 * result + (contractDate != null ? contractDate.hashCode() : 0);
        return result;
    }
}
