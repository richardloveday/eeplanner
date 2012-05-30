package com.eeplanner.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "camp")
@Entity
public class CampEntity {
    private int id;

    @Column(name = "ID")
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

    private Timestamp start;

    @Column(name = "start")
    @Basic
    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    private Timestamp end;

    @Column(name = "end")
    @Basic
    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    private int studentNumber;

    @Column(name = "studentNumber")
    @Basic
    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    private int contactId;

    @Column(name = "contactID")
    @Basic
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    private int teachersNeeded;

    @Column(name = "teachersNeeded")
    @Basic
    public int getTeachersNeeded() {
        return teachersNeeded;
    }

    public void setTeachersNeeded(int teachersNeeded) {
        this.teachersNeeded = teachersNeeded;
    }

    private int coordinatorsNeeded;

    @Column(name = "coordinatorsNeeded")
    @Basic
    public int getCoordinatorsNeeded() {
        return coordinatorsNeeded;
    }

    public void setCoordinatorsNeeded(int coordinatorsNeeded) {
        this.coordinatorsNeeded = coordinatorsNeeded;
    }

    private int dramaTeachersNeeded;

    @Column(name = "dramaTeachersNeeded")
    @Basic
    public int getDramaTeachersNeeded() {
        return dramaTeachersNeeded;
    }

    public void setDramaTeachersNeeded(int dramaTeachersNeeded) {
        this.dramaTeachersNeeded = dramaTeachersNeeded;
    }

    private int activityLeadersNeeded;

    @Column(name = "activityLeadersNeeded")
    @Basic
    public int getActivityLeadersNeeded() {
        return activityLeadersNeeded;
    }

    public void setActivityLeadersNeeded(int activityLeadersNeeded) {
        this.activityLeadersNeeded = activityLeadersNeeded;
    }

    private int legacyId;

    @Column(name = "legacyID")
    @Basic
    public int getLegacyId() {
        return legacyId;
    }

    public void setLegacyId(int legacyId) {
        this.legacyId = legacyId;
    }

    private int siblingNumber;

    @Column(name = "siblingNumber")
    @Basic
    public int getSiblingNumber() {
        return siblingNumber;
    }

    public void setSiblingNumber(int siblingNumber) {
        this.siblingNumber = siblingNumber;
    }

    private Timestamp forwardingDate;

    @Column(name = "forwardingDate")
    @Basic
    public Timestamp getForwardingDate() {
        return forwardingDate;
    }

    public void setForwardingDate(Timestamp forwardingDate) {
        this.forwardingDate = forwardingDate;
    }

    private Timestamp deliveryDate;

    @Column(name = "deliveryDate")
    @Basic
    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    private int studentLevel1;

    @Column(name = "studentLevel1")
    @Basic
    public int getStudentLevel1() {
        return studentLevel1;
    }

    public void setStudentLevel1(int studentLevel1) {
        this.studentLevel1 = studentLevel1;
    }

    private int studentLevel2;

    @Column(name = "studentLevel2")
    @Basic
    public int getStudentLevel2() {
        return studentLevel2;
    }

    public void setStudentLevel2(int studentLevel2) {
        this.studentLevel2 = studentLevel2;
    }

    private int studentLevel3;

    @Column(name = "studentLevel3")
    @Basic
    public int getStudentLevel3() {
        return studentLevel3;
    }

    public void setStudentLevel3(int studentLevel3) {
        this.studentLevel3 = studentLevel3;
    }

    private int studentLevel4;

    @Column(name = "studentLevel4")
    @Basic
    public int getStudentLevel4() {
        return studentLevel4;
    }

    public void setStudentLevel4(int studentLevel4) {
        this.studentLevel4 = studentLevel4;
    }

    private int studentLevel5;

    @Column(name = "studentLevel5")
    @Basic
    public int getStudentLevel5() {
        return studentLevel5;
    }

    public void setStudentLevel5(int studentLevel5) {
        this.studentLevel5 = studentLevel5;
    }

    private int studentLevel6;

    @Column(name = "studentLevel6")
    @Basic
    public int getStudentLevel6() {
        return studentLevel6;
    }

    public void setStudentLevel6(int studentLevel6) {
        this.studentLevel6 = studentLevel6;
    }

    private int studentLevel7;

    @Column(name = "studentLevel7")
    @Basic
    public int getStudentLevel7() {
        return studentLevel7;
    }

    public void setStudentLevel7(int studentLevel7) {
        this.studentLevel7 = studentLevel7;
    }

    private int studentLevel8;

    @Column(name = "studentLevel8")
    @Basic
    public int getStudentLevel8() {
        return studentLevel8;
    }

    public void setStudentLevel8(int studentLevel8) {
        this.studentLevel8 = studentLevel8;
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

    private int activityCoordinatorsNeeded;

    @Column(name = "activityCoordinatorsNeeded")
    @Basic
    public int getActivityCoordinatorsNeeded() {
        return activityCoordinatorsNeeded;
    }

    public void setActivityCoordinatorsNeeded(int activityCoordinatorsNeeded) {
        this.activityCoordinatorsNeeded = activityCoordinatorsNeeded;
    }

    private int dptCoordinatorsNeeded;

    @Column(name = "dptCoordinatorsNeeded")
    @Basic
    public int getDptCoordinatorsNeeded() {
        return dptCoordinatorsNeeded;
    }

    public void setDptCoordinatorsNeeded(int dptCoordinatorsNeeded) {
        this.dptCoordinatorsNeeded = dptCoordinatorsNeeded;
    }

    private int courseSpecialistsNeeded;

    @Column(name = "courseSpecialistsNeeded")
    @Basic
    public int getCourseSpecialistsNeeded() {
        return courseSpecialistsNeeded;
    }

    public void setCourseSpecialistsNeeded(int courseSpecialistsNeeded) {
        this.courseSpecialistsNeeded = courseSpecialistsNeeded;
    }

    private int predictedStudents;

    @Column(name = "predictedStudents")
    @Basic
    public int getPredictedStudents() {
        return predictedStudents;
    }

    public void setPredictedStudents(int predictedStudents) {
        this.predictedStudents = predictedStudents;
    }

    private int studentRegistrations;

    @Column(name = "studentRegistrations")
    @Basic
    public int getStudentRegistrations() {
        return studentRegistrations;
    }

    public void setStudentRegistrations(int studentRegistrations) {
        this.studentRegistrations = studentRegistrations;
    }

    private Timestamp dateStamp;

    @Column(name = "dateStamp")
    @Basic
    public Timestamp getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(Timestamp dateStamp) {
        this.dateStamp = dateStamp;
    }

    private int students2Week;

    @Column(name = "students2Week")
    @Basic
    public int getStudents2Week() {
        return students2Week;
    }

    public void setStudents2Week(int students2Week) {
        this.students2Week = students2Week;
    }

    private int students1Week;

    @Column(name = "students1week")
    @Basic
    public int getStudents1Week() {
        return students1Week;
    }

    public void setStudents1Week(int students1Week) {
        this.students1Week = students1Week;
    }

    private String presentationTime;

    @Column(name = "presentationTime")
    @Basic
    public String getPresentationTime() {
        return presentationTime;
    }

    public void setPresentationTime(String presentationTime) {
        this.presentationTime = presentationTime;
    }

    private String itemsSent;

    @Column(name = "itemsSent")
    @Basic
    public String getItemsSent() {
        return itemsSent;
    }

    public void setItemsSent(String itemsSent) {
        this.itemsSent = itemsSent;
    }

    private String timeReceived;

    @Column(name = "timeReceived")
    @Basic
    public String getTimeReceived() {
        return timeReceived;
    }

    public void setTimeReceived(String timeReceived) {
        this.timeReceived = timeReceived;
    }

    private String signature;

    @Column(name = "signature")
    @Basic
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    private int schoolPhone;

    @Column(name = "schoolPhone")
    @Basic
    public int getSchoolPhone() {
        return schoolPhone;
    }

    public void setSchoolPhone(int schoolPhone) {
        this.schoolPhone = schoolPhone;
    }

    private int schoolFax;

    @Column(name = "schoolFax")
    @Basic
    public int getSchoolFax() {
        return schoolFax;
    }

    public void setSchoolFax(int schoolFax) {
        this.schoolFax = schoolFax;
    }

    private String schoolEmail;

    @Column(name = "schoolEmail")
    @Basic
    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    private int schoolContactId;

    @Column(name = "schoolContactID")
    @Basic
    public int getSchoolContactId() {
        return schoolContactId;
    }

    public void setSchoolContactId(int schoolContactId) {
        this.schoolContactId = schoolContactId;
    }

    private int splitRoleNeeded;

    @Column(name = "splitRoleNeeded")
    @Basic
    public int getSplitRoleNeeded() {
        return splitRoleNeeded;
    }

    public void setSplitRoleNeeded(int splitRoleNeeded) {
        this.splitRoleNeeded = splitRoleNeeded;
    }

    private int finalRegCurrentYear;

    @Column(name = "finalRegCurrentYear")
    @Basic
    public int getFinalRegCurrentYear() {
        return finalRegCurrentYear;
    }

    public void setFinalRegCurrentYear(int finalRegCurrentYear) {
        this.finalRegCurrentYear = finalRegCurrentYear;
    }

    private int finalRegLastYear;

    @Column(name = "finalRegLastYear")
    @Basic
    public int getFinalRegLastYear() {
        return finalRegLastYear;
    }

    public void setFinalRegLastYear(int finalRegLastYear) {
        this.finalRegLastYear = finalRegLastYear;
    }

    private String timetablingNotes;

    @Column(name = "timetablingNotes")
    @Basic
    public String getTimetablingNotes() {
        return timetablingNotes;
    }

    public void setTimetablingNotes(String timetablingNotes) {
        this.timetablingNotes = timetablingNotes;
    }

    private String adminSchoolAddress;

    @Column(name = "adminSchoolAddress")
    @Basic
    public String getAdminSchoolAddress() {
        return adminSchoolAddress;
    }

    public void setAdminSchoolAddress(String adminSchoolAddress) {
        this.adminSchoolAddress = adminSchoolAddress;
    }

    private String adminSchoolName;

    @Column(name = "adminSchoolName")
    @Basic
    public String getAdminSchoolName() {
        return adminSchoolName;
    }

    public void setAdminSchoolName(String adminSchoolName) {
        this.adminSchoolName = adminSchoolName;
    }

    private String headTeacher;

    @Column(name = "headTeacher")
    @Basic
    public String getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(String headTeacher) {
        this.headTeacher = headTeacher;
    }

    private String otherNotes;

    @Column(name = "otherNotes")
    @Basic
    public String getOtherNotes() {
        return otherNotes;
    }

    public void setOtherNotes(String otherNotes) {
        this.otherNotes = otherNotes;
    }

    private String dailyHours;

    @Column(name = "dailyHours")
    @Basic
    public String getDailyHours() {
        return dailyHours;
    }

    public void setDailyHours(String dailyHours) {
        this.dailyHours = dailyHours;
    }

    private String materialsSent;

    @Column(name = "materialsSent")
    @Basic
    public String getMaterialsSent() {
        return materialsSent;
    }

    public void setMaterialsSent(String materialsSent) {
        this.materialsSent = materialsSent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CampEntity that = (CampEntity) o;

        if (activityCoordinatorsNeeded != that.activityCoordinatorsNeeded) return false;
        if (activityLeadersNeeded != that.activityLeadersNeeded) return false;
        if (contactId != that.contactId) return false;
        if (coordinatorsNeeded != that.coordinatorsNeeded) return false;
        if (courseSpecialistsNeeded != that.courseSpecialistsNeeded) return false;
        if (deleted != that.deleted) return false;
        if (dptCoordinatorsNeeded != that.dptCoordinatorsNeeded) return false;
        if (dramaTeachersNeeded != that.dramaTeachersNeeded) return false;
        if (finalRegCurrentYear != that.finalRegCurrentYear) return false;
        if (finalRegLastYear != that.finalRegLastYear) return false;
        if (id != that.id) return false;
        if (legacyId != that.legacyId) return false;
        if (predictedStudents != that.predictedStudents) return false;
        if (schoolContactId != that.schoolContactId) return false;
        if (schoolFax != that.schoolFax) return false;
        if (schoolPhone != that.schoolPhone) return false;
        if (siblingNumber != that.siblingNumber) return false;
        if (splitRoleNeeded != that.splitRoleNeeded) return false;
        if (studentLevel1 != that.studentLevel1) return false;
        if (studentLevel2 != that.studentLevel2) return false;
        if (studentLevel3 != that.studentLevel3) return false;
        if (studentLevel4 != that.studentLevel4) return false;
        if (studentLevel5 != that.studentLevel5) return false;
        if (studentLevel6 != that.studentLevel6) return false;
        if (studentLevel7 != that.studentLevel7) return false;
        if (studentLevel8 != that.studentLevel8) return false;
        if (studentNumber != that.studentNumber) return false;
        if (studentRegistrations != that.studentRegistrations) return false;
        if (students1Week != that.students1Week) return false;
        if (students2Week != that.students2Week) return false;
        if (teachersNeeded != that.teachersNeeded) return false;
        if (adminSchoolAddress != null ? !adminSchoolAddress.equals(that.adminSchoolAddress) : that.adminSchoolAddress != null)
            return false;
        if (adminSchoolName != null ? !adminSchoolName.equals(that.adminSchoolName) : that.adminSchoolName != null)
            return false;
        if (dailyHours != null ? !dailyHours.equals(that.dailyHours) : that.dailyHours != null) return false;
        if (dateStamp != null ? !dateStamp.equals(that.dateStamp) : that.dateStamp != null) return false;
        if (deliveryDate != null ? !deliveryDate.equals(that.deliveryDate) : that.deliveryDate != null) return false;
        if (end != null ? !end.equals(that.end) : that.end != null) return false;
        if (forwardingDate != null ? !forwardingDate.equals(that.forwardingDate) : that.forwardingDate != null)
            return false;
        if (headTeacher != null ? !headTeacher.equals(that.headTeacher) : that.headTeacher != null) return false;
        if (itemsSent != null ? !itemsSent.equals(that.itemsSent) : that.itemsSent != null) return false;
        if (materialsSent != null ? !materialsSent.equals(that.materialsSent) : that.materialsSent != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (otherNotes != null ? !otherNotes.equals(that.otherNotes) : that.otherNotes != null) return false;
        if (presentationTime != null ? !presentationTime.equals(that.presentationTime) : that.presentationTime != null)
            return false;
        if (schoolEmail != null ? !schoolEmail.equals(that.schoolEmail) : that.schoolEmail != null) return false;
        if (signature != null ? !signature.equals(that.signature) : that.signature != null) return false;
        if (start != null ? !start.equals(that.start) : that.start != null) return false;
        if (timeReceived != null ? !timeReceived.equals(that.timeReceived) : that.timeReceived != null) return false;
        if (timetablingNotes != null ? !timetablingNotes.equals(that.timetablingNotes) : that.timetablingNotes != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + studentNumber;
        result = 31 * result + contactId;
        result = 31 * result + teachersNeeded;
        result = 31 * result + coordinatorsNeeded;
        result = 31 * result + dramaTeachersNeeded;
        result = 31 * result + activityLeadersNeeded;
        result = 31 * result + legacyId;
        result = 31 * result + siblingNumber;
        result = 31 * result + (forwardingDate != null ? forwardingDate.hashCode() : 0);
        result = 31 * result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
        result = 31 * result + studentLevel1;
        result = 31 * result + studentLevel2;
        result = 31 * result + studentLevel3;
        result = 31 * result + studentLevel4;
        result = 31 * result + studentLevel5;
        result = 31 * result + studentLevel6;
        result = 31 * result + studentLevel7;
        result = 31 * result + studentLevel8;
        result = 31 * result + (int) deleted;
        result = 31 * result + activityCoordinatorsNeeded;
        result = 31 * result + dptCoordinatorsNeeded;
        result = 31 * result + courseSpecialistsNeeded;
        result = 31 * result + predictedStudents;
        result = 31 * result + studentRegistrations;
        result = 31 * result + (dateStamp != null ? dateStamp.hashCode() : 0);
        result = 31 * result + students2Week;
        result = 31 * result + students1Week;
        result = 31 * result + (presentationTime != null ? presentationTime.hashCode() : 0);
        result = 31 * result + (itemsSent != null ? itemsSent.hashCode() : 0);
        result = 31 * result + (timeReceived != null ? timeReceived.hashCode() : 0);
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        result = 31 * result + schoolPhone;
        result = 31 * result + schoolFax;
        result = 31 * result + (schoolEmail != null ? schoolEmail.hashCode() : 0);
        result = 31 * result + schoolContactId;
        result = 31 * result + splitRoleNeeded;
        result = 31 * result + finalRegCurrentYear;
        result = 31 * result + finalRegLastYear;
        result = 31 * result + (timetablingNotes != null ? timetablingNotes.hashCode() : 0);
        result = 31 * result + (adminSchoolAddress != null ? adminSchoolAddress.hashCode() : 0);
        result = 31 * result + (adminSchoolName != null ? adminSchoolName.hashCode() : 0);
        result = 31 * result + (headTeacher != null ? headTeacher.hashCode() : 0);
        result = 31 * result + (otherNotes != null ? otherNotes.hashCode() : 0);
        result = 31 * result + (dailyHours != null ? dailyHours.hashCode() : 0);
        result = 31 * result + (materialsSent != null ? materialsSent.hashCode() : 0);
        return result;
    }
}
