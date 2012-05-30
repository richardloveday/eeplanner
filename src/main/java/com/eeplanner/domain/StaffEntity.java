package com.eeplanner.domain;

import javax.persistence.*;

/**
 * User: iviec01
 * Date: 30/05/2012
 * Time: 16:17
 */
@Table(name = "staff")
@Entity
public class StaffEntity {
    private int id;

    @Column(name = "ID")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int parentId;

    @Column(name = "parentID")
    @Basic
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    private String hash;

    @Column(name = "hash")
    @Basic
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
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

    private String job;

    @Column(name = "job")
    @Basic
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    private byte teacher;

    @Column(name = "teacher")
    @Basic
    public byte getTeacher() {
        return teacher;
    }

    public void setTeacher(byte teacher) {
        this.teacher = teacher;
    }

    private byte coordinator;

    @Column(name = "coordinator")
    @Basic
    public byte getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(byte coordinator) {
        this.coordinator = coordinator;
    }

    private byte drama;

    @Column(name = "drama")
    @Basic
    public byte getDrama() {
        return drama;
    }

    public void setDrama(byte drama) {
        this.drama = drama;
    }

    private byte activityleader;

    @Column(name = "activityleader")
    @Basic
    public byte getActivityleader() {
        return activityleader;
    }

    public void setActivityleader(byte activityleader) {
        this.activityleader = activityleader;
    }

    private String kinName;

    @Column(name = "kinName")
    @Basic
    public String getKinName() {
        return kinName;
    }

    public void setKinName(String kinName) {
        this.kinName = kinName;
    }

    private String kinNumber;

    @Column(name = "kinNumber")
    @Basic
    public String getKinNumber() {
        return kinNumber;
    }

    public void setKinNumber(String kinNumber) {
        this.kinNumber = kinNumber;
    }

    private String archivePassword;

    @Column(name = "archivePassword")
    @Basic
    public String getArchivePassword() {
        return archivePassword;
    }

    public void setArchivePassword(String archivePassword) {
        this.archivePassword = archivePassword;
    }

    private byte existing;

    @Column(name = "existing")
    @Basic
    public byte getExisting() {
        return existing;
    }

    public void setExisting(byte existing) {
        this.existing = existing;
    }

    private String status;

    @Column(name = "status")
    @Basic
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    private byte activityCoordinator;

    @Column(name = "activityCoordinator")
    @Basic
    public byte getActivityCoordinator() {
        return activityCoordinator;
    }

    public void setActivityCoordinator(byte activityCoordinator) {
        this.activityCoordinator = activityCoordinator;
    }

    private byte dptCoordinator;

    @Column(name = "dptCoordinator")
    @Basic
    public byte getDptCoordinator() {
        return dptCoordinator;
    }

    public void setDptCoordinator(byte dptCoordinator) {
        this.dptCoordinator = dptCoordinator;
    }

    private byte courseSpecialist;

    @Column(name = "courseSpecialist")
    @Basic
    public byte getCourseSpecialist() {
        return courseSpecialist;
    }

    public void setCourseSpecialist(byte courseSpecialist) {
        this.courseSpecialist = courseSpecialist;
    }

    private String profile;

    @Column(name = "profile")
    @Basic
    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    private String medical;

    @Column(name = "medical")
    @Basic
    public String getMedical() {
        return medical;
    }

    public void setMedical(String medical) {
        this.medical = medical;
    }

    private String dietary;

    @Column(name = "dietary")
    @Basic
    public String getDietary() {
        return dietary;
    }

    public void setDietary(String dietary) {
        this.dietary = dietary;
    }

    private byte applied;

    @Column(name = "applied")
    @Basic
    public byte getApplied() {
        return applied;
    }

    public void setApplied(byte applied) {
        this.applied = applied;
    }

    private byte interviewed;

    @Column(name = "interviewed")
    @Basic
    public byte getInterviewed() {
        return interviewed;
    }

    public void setInterviewed(byte interviewed) {
        this.interviewed = interviewed;
    }

    private byte approved;

    @Column(name = "approved")
    @Basic
    public byte getApproved() {
        return approved;
    }

    public void setApproved(byte approved) {
        this.approved = approved;
    }

    private byte travelOutside;

    @Column(name = "travelOutside")
    @Basic
    public byte getTravelOutside() {
        return travelOutside;
    }

    public void setTravelOutside(byte travelOutside) {
        this.travelOutside = travelOutside;
    }

    private byte travelWithinLondon;

    @Column(name = "travelWithinLondon")
    @Basic
    public byte getTravelWithinLondon() {
        return travelWithinLondon;
    }

    public void setTravelWithinLondon(byte travelWithinLondon) {
        this.travelWithinLondon = travelWithinLondon;
    }

    private String officeNotes;

    @Column(name = "officeNotes")
    @Basic
    public String getOfficeNotes() {
        return officeNotes;
    }

    public void setOfficeNotes(String officeNotes) {
        this.officeNotes = officeNotes;
    }

    private byte mixedRole;

    @Column(name = "mixedRole")
    @Basic
    public byte getMixedRole() {
        return mixedRole;
    }

    public void setMixedRole(byte mixedRole) {
        this.mixedRole = mixedRole;
    }

    private byte prefAgeAny;

    @Column(name = "prefAgeAny")
    @Basic
    public byte getPrefAgeAny() {
        return prefAgeAny;
    }

    public void setPrefAgeAny(byte prefAgeAny) {
        this.prefAgeAny = prefAgeAny;
    }

    private byte prefAgeGroup1;

    @Column(name = "prefAgeGroup1")
    @Basic
    public byte getPrefAgeGroup1() {
        return prefAgeGroup1;
    }

    public void setPrefAgeGroup1(byte prefAgeGroup1) {
        this.prefAgeGroup1 = prefAgeGroup1;
    }

    private byte prefAgeGroup2;

    @Column(name = "prefAgeGroup2")
    @Basic
    public byte getPrefAgeGroup2() {
        return prefAgeGroup2;
    }

    public void setPrefAgeGroup2(byte prefAgeGroup2) {
        this.prefAgeGroup2 = prefAgeGroup2;
    }

    private int prefActivityArt;

    @Column(name = "prefActivityArt")
    @Basic
    public int getPrefActivityArt() {
        return prefActivityArt;
    }

    public void setPrefActivityArt(int prefActivityArt) {
        this.prefActivityArt = prefActivityArt;
    }

    private int prefActivitySport;

    @Column(name = "prefActivitySport")
    @Basic
    public int getPrefActivitySport() {
        return prefActivitySport;
    }

    public void setPrefActivitySport(int prefActivitySport) {
        this.prefActivitySport = prefActivitySport;
    }

    private int prefActivityDrama;

    @Column(name = "prefActivityDrama")
    @Basic
    public int getPrefActivityDrama() {
        return prefActivityDrama;
    }

    public void setPrefActivityDrama(int prefActivityDrama) {
        this.prefActivityDrama = prefActivityDrama;
    }

    private int prefActivityAny;

    @Column(name = "prefActivityAny")
    @Basic
    public int getPrefActivityAny() {
        return prefActivityAny;
    }

    public void setPrefActivityAny(int prefActivityAny) {
        this.prefActivityAny = prefActivityAny;
    }

    private String staffNotes;

    @Column(name = "staffNotes")
    @Basic
    public String getStaffNotes() {
        return staffNotes;
    }

    public void setStaffNotes(String staffNotes) {
        this.staffNotes = staffNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaffEntity that = (StaffEntity) o;

        if (activityCoordinator != that.activityCoordinator) return false;
        if (activityleader != that.activityleader) return false;
        if (applied != that.applied) return false;
        if (approved != that.approved) return false;
        if (contactId != that.contactId) return false;
        if (coordinator != that.coordinator) return false;
        if (courseSpecialist != that.courseSpecialist) return false;
        if (deleted != that.deleted) return false;
        if (dptCoordinator != that.dptCoordinator) return false;
        if (drama != that.drama) return false;
        if (existing != that.existing) return false;
        if (id != that.id) return false;
        if (interviewed != that.interviewed) return false;
        if (mixedRole != that.mixedRole) return false;
        if (parentId != that.parentId) return false;
        if (prefActivityAny != that.prefActivityAny) return false;
        if (prefActivityArt != that.prefActivityArt) return false;
        if (prefActivityDrama != that.prefActivityDrama) return false;
        if (prefActivitySport != that.prefActivitySport) return false;
        if (prefAgeAny != that.prefAgeAny) return false;
        if (prefAgeGroup1 != that.prefAgeGroup1) return false;
        if (prefAgeGroup2 != that.prefAgeGroup2) return false;
        if (teacher != that.teacher) return false;
        if (travelOutside != that.travelOutside) return false;
        if (travelWithinLondon != that.travelWithinLondon) return false;
        if (archivePassword != null ? !archivePassword.equals(that.archivePassword) : that.archivePassword != null)
            return false;
        if (dietary != null ? !dietary.equals(that.dietary) : that.dietary != null) return false;
        if (hash != null ? !hash.equals(that.hash) : that.hash != null) return false;
        if (job != null ? !job.equals(that.job) : that.job != null) return false;
        if (kinName != null ? !kinName.equals(that.kinName) : that.kinName != null) return false;
        if (kinNumber != null ? !kinNumber.equals(that.kinNumber) : that.kinNumber != null) return false;
        if (medical != null ? !medical.equals(that.medical) : that.medical != null) return false;
        if (officeNotes != null ? !officeNotes.equals(that.officeNotes) : that.officeNotes != null) return false;
        if (profile != null ? !profile.equals(that.profile) : that.profile != null) return false;
        if (staffNotes != null ? !staffNotes.equals(that.staffNotes) : that.staffNotes != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + parentId;
        result = 31 * result + (hash != null ? hash.hashCode() : 0);
        result = 31 * result + contactId;
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (int) teacher;
        result = 31 * result + (int) coordinator;
        result = 31 * result + (int) drama;
        result = 31 * result + (int) activityleader;
        result = 31 * result + (kinName != null ? kinName.hashCode() : 0);
        result = 31 * result + (kinNumber != null ? kinNumber.hashCode() : 0);
        result = 31 * result + (archivePassword != null ? archivePassword.hashCode() : 0);
        result = 31 * result + (int) existing;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (int) deleted;
        result = 31 * result + (int) activityCoordinator;
        result = 31 * result + (int) dptCoordinator;
        result = 31 * result + (int) courseSpecialist;
        result = 31 * result + (profile != null ? profile.hashCode() : 0);
        result = 31 * result + (medical != null ? medical.hashCode() : 0);
        result = 31 * result + (dietary != null ? dietary.hashCode() : 0);
        result = 31 * result + (int) applied;
        result = 31 * result + (int) interviewed;
        result = 31 * result + (int) approved;
        result = 31 * result + (int) travelOutside;
        result = 31 * result + (int) travelWithinLondon;
        result = 31 * result + (officeNotes != null ? officeNotes.hashCode() : 0);
        result = 31 * result + (int) mixedRole;
        result = 31 * result + (int) prefAgeAny;
        result = 31 * result + (int) prefAgeGroup1;
        result = 31 * result + (int) prefAgeGroup2;
        result = 31 * result + prefActivityArt;
        result = 31 * result + prefActivitySport;
        result = 31 * result + prefActivityDrama;
        result = 31 * result + prefActivityAny;
        result = 31 * result + (staffNotes != null ? staffNotes.hashCode() : 0);
        return result;
    }
}
