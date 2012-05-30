package com.eeplanner.domain;

import javax.persistence.*;
import java.sql.Timestamp;


@Table(name = "contact")
@Entity
public class ContactEntity {
    private int id;

    @Column(name = "ID")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String firstNames;

    @Column(name = "firstNames")
    @Basic
    public String getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(String firstNames) {
        this.firstNames = firstNames;
    }

    private String secondName;

    @Column(name = "secondName")
    @Basic
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    private String orgName;

    @Column(name = "orgName")
    @Basic
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    private String add1;

    @Column(name = "add1")
    @Basic
    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    private String add2;

    @Column(name = "add2")
    @Basic
    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    private String add3;

    @Column(name = "add3")
    @Basic
    public String getAdd3() {
        return add3;
    }

    public void setAdd3(String add3) {
        this.add3 = add3;
    }

    private String add4;

    @Column(name = "add4")
    @Basic
    public String getAdd4() {
        return add4;
    }

    public void setAdd4(String add4) {
        this.add4 = add4;
    }

    private String postCode;

    @Column(name = "postCode")
    @Basic
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
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

    private Timestamp dob;

    @Column(name = "dob")
    @Basic
    public Timestamp getDob() {
        return dob;
    }

    public void setDob(Timestamp dob) {
        this.dob = dob;
    }

    private int relatedId;

    @Column(name = "relatedID")
    @Basic
    public int getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(int relatedId) {
        this.relatedId = relatedId;
    }

    private String sex;

    @Column(name = "sex")
    @Basic
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String accountHolderName;

    @Column(name = "accountHolderName")
    @Basic
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    private String accountNumber;

    @Column(name = "accountNumber")
    @Basic
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    private String accountSortCode;

    @Column(name = "accountSortCode")
    @Basic
    public String getAccountSortCode() {
        return accountSortCode;
    }

    public void setAccountSortCode(String accountSortCode) {
        this.accountSortCode = accountSortCode;
    }

    private String nationalInsuranceNumber;

    @Column(name = "nationalInsuranceNumber")
    @Basic
    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

    public void setNationalInsuranceNumber(String nationalInsuranceNumber) {
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    private byte student;

    @Column(name = "student")
    @Basic
    public byte getStudent() {
        return student;
    }

    public void setStudent(byte student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactEntity that = (ContactEntity) o;

        if (id != that.id) return false;
        if (relatedId != that.relatedId) return false;
        if (student != that.student) return false;
        if (accountHolderName != null ? !accountHolderName.equals(that.accountHolderName) : that.accountHolderName != null)
            return false;
        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;
        if (accountSortCode != null ? !accountSortCode.equals(that.accountSortCode) : that.accountSortCode != null)
            return false;
        if (add1 != null ? !add1.equals(that.add1) : that.add1 != null) return false;
        if (add2 != null ? !add2.equals(that.add2) : that.add2 != null) return false;
        if (add3 != null ? !add3.equals(that.add3) : that.add3 != null) return false;
        if (add4 != null ? !add4.equals(that.add4) : that.add4 != null) return false;
        if (dob != null ? !dob.equals(that.dob) : that.dob != null) return false;
        if (firstNames != null ? !firstNames.equals(that.firstNames) : that.firstNames != null) return false;
        if (nationalInsuranceNumber != null ? !nationalInsuranceNumber.equals(that.nationalInsuranceNumber) : that.nationalInsuranceNumber != null)
            return false;
        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
        if (postCode != null ? !postCode.equals(that.postCode) : that.postCode != null) return false;
        if (secondName != null ? !secondName.equals(that.secondName) : that.secondName != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstNames != null ? firstNames.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (add1 != null ? add1.hashCode() : 0);
        result = 31 * result + (add2 != null ? add2.hashCode() : 0);
        result = 31 * result + (add3 != null ? add3.hashCode() : 0);
        result = 31 * result + (add4 != null ? add4.hashCode() : 0);
        result = 31 * result + (postCode != null ? postCode.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (dob != null ? dob.hashCode() : 0);
        result = 31 * result + relatedId;
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (accountHolderName != null ? accountHolderName.hashCode() : 0);
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (accountSortCode != null ? accountSortCode.hashCode() : 0);
        result = 31 * result + (nationalInsuranceNumber != null ? nationalInsuranceNumber.hashCode() : 0);
        result = 31 * result + (int) student;
        return result;
    }
}
