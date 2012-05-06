package com.eeplanner.datastructures;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 23-Dec-2009
 * Time: 16:49:10
 * To change this template use File | Settings | File Templates.
 */
public class Camp {

    private int ID;
    private String name;
    private Date start;
    private Date end;
    private int studentNumber;
    private int coordinatorsNeeded;
    private int teachersNeeded;
    private int dramaTeachersNeeded;
    private int activityLeadersNeeded;
    private int activityCoordinatorsNeeded;
    private int dptCoordinatorsNeeded;
    private int courseSpecialistsNeeded;
    private int splitRoleNeeded;
    private int coordinatorsStillNeeded;
    private int teachersStillNeeded;
    private int dramaTeachersStillNeeded;
    private int activityLeadersStillNeeded;
    private int activityCoordinatorsStillNeeded;
    private int dptCoordinatorsStillNeeded;
    private int courseSpecialistsStillNeeded;
    
    private Contact schoolContact = new Contact();
    private int schoolContactID;
    private Contact contact = new Contact();
    private int contactID;
    private int staffMembersCount;
    private List<StaffMember> staffMembers;
    private int legacyID;
    private int siblingNumber;
    private Date deliveryDate;
    private Date forwardingDate;
    private boolean deleted;
    private int predictedStudents;
    private int studentRegistrations;
    private int students2Week;
    private int students1week;
    private Date dateStamp;
    private int dailyHours;
    private String presentationTime;
    private int materialsSent;
    private String itemsSent;
    private String timeReceived;
    private String signature;   
    private int schoolPhone;
    private int schoolFax;
    private String schoolEmail;
    
    private String otherNotes;

	private String headTeacher;
    private String adminSchoolName;
    private String adminSchoolAddress;
    private String timetablingNotes;
    private int finalRegLastYear;
    private int finalRegCurrentYear;
    private int studentLevel1;
    private int studentLevel2;
    private int studentLevel3;
    private int studentLevel4;
    private int studentLevel5;
    private int studentLevel6;
    private int studentLevel7;
    private int studentLevel8;
    
    
    public Camp(){}

    public Camp(int ID, String name, Date start, Date end, int studentNumber, int coordinatorsNeeded, int teachersNeeded, int dramaTeachersNeeded, int activityLeadersNeeded, String ageRange, Contact contact) {
        this.ID = ID;
        this.name = name;
        this.start = start;
        this.end = end;
        this.studentNumber = studentNumber;
        this.coordinatorsNeeded = coordinatorsNeeded;
        this.teachersNeeded = teachersNeeded;
        this.dramaTeachersNeeded = dramaTeachersNeeded;
        this.activityLeadersNeeded = activityLeadersNeeded;
        this.contact = contact;
    }

    public Camp(String name, Date start, Date end, int studentNumber, String ageRange, Contact contact) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.studentNumber = studentNumber;
        this.contact = contact;
    }

    public Camp(int ID, String name, Date start, Date end, int studentNumber, String ageRange, Contact contact) {
        this.ID = ID;
        this.name = name;
        this.start = start;
        this.end = end;
        this.studentNumber = studentNumber;
        this.contact = contact;
    }

    public Camp(int ID, String name, Date start, Date end, int studentNumber, String ageRange, Contact contact, int contactID, List<StaffMember> staffMembers) {
        this.ID = ID;
        this.name = name;
        this.start = start;
        this.end = end;
        this.studentNumber = studentNumber;
        this.contact = contact;
        this.contactID = contactID;
        this.staffMembers = staffMembers;
    }

    public Camp(String name, Date start, Date end, int studentNumber, String ageRange, Contact contact, int contactID, List<StaffMember> staffMembers) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.studentNumber = studentNumber;
        this.contact = contact;
        this.contactID = contactID;
        this.staffMembers = staffMembers;
    }

    
    
    public Contact getSchoolContact() {
		return schoolContact;
	}

	public void setSchoolContact(Contact schoolContact) {
		this.schoolContact = schoolContact;
	}

	public int getSchoolContactID() {
		return schoolContactID;
	}

	public void setSchoolContactID(int schoolContactID) {
		this.schoolContactID = schoolContactID;
	}

	public int getSchoolPhone() {
		return schoolPhone;
	}

	public void setSchoolPhone(int schoolPhone) {
		this.schoolPhone = schoolPhone;
	}

	public int getSchoolFax() {
		return schoolFax;
	}

	public void setSchoolFax(int schoolFax) {
		this.schoolFax = schoolFax;
	}

	public String getSchoolEmail() {
		return schoolEmail;
	}

	public void setSchoolEmail(String schoolEmail) {
		this.schoolEmail = schoolEmail;
	}

	public int getDailyHours() {
		return dailyHours;
	}

	public void setDailyHours(int dailyHours) {
		this.dailyHours = dailyHours;
	}

	public String getPresentationTime() {
		return presentationTime;
	}

	public void setPresentationTime(String presentationTime) {
		this.presentationTime = presentationTime;
	}

	public int getMaterialsSent() {
		return materialsSent;
	}

	public void setMaterialsSent(int materialsSent) {
		this.materialsSent = materialsSent;
	}

	public String getItemsSent() {
		return itemsSent;
	}

	public void setItemsSent(String itemsSent) {
		this.itemsSent = itemsSent;
	}

	public String getTimeReceived() {
		return timeReceived;
	}

	public void setTimeReceived(String timeReceived) {
		this.timeReceived = timeReceived;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public int getPredictedStudents() {
		return predictedStudents;
	}

	public void setPredictedStudents(int predictedStudents) {
		this.predictedStudents = predictedStudents;
	}

	public int getStudentRegistrations() {
		return studentRegistrations;
	}

	public void setStudentRegistrations(int studentRegistrations) {
		this.studentRegistrations = studentRegistrations;
	}

	public int getStudents2Week() {
		return students2Week;
	}

	public void setStudents2Week(int students2Week) {
		this.students2Week = students2Week;
	}

	public int getStudents1week() {
		return students1week;
	}

	public void setStudents1week(int students1week) {
		this.students1week = students1week;
	}

	public Date getDateStamp() {
		return dateStamp;
	}

	public void setDateStamp(Date dateStamp) {
		this.dateStamp = dateStamp;
	}

	public int getCoordinatorsStillNeeded() {
		return coordinatorsStillNeeded;
	}

	public void setCoordinatorsStillNeeded(int coordinatorsStillNeeded) {
		this.coordinatorsStillNeeded = coordinatorsStillNeeded;
	}

	public int getTeachersStillNeeded() {
		return teachersStillNeeded;
	}

	public void setTeachersStillNeeded(int teachersStillNeeded) {
		this.teachersStillNeeded = teachersStillNeeded;
	}

	public int getDramaTeachersStillNeeded() {
		return dramaTeachersStillNeeded;
	}

	public void setDramaTeachersStillNeeded(int dramaTeachersStillNeeded) {
		this.dramaTeachersStillNeeded = dramaTeachersStillNeeded;
	}

	public int getActivityLeadersStillNeeded() {
		return activityLeadersStillNeeded;
	}

	public void setActivityLeadersStillNeeded(int activityLeadersStillNeeded) {
		this.activityLeadersStillNeeded = activityLeadersStillNeeded;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

    public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getForwardingDate() {
		return forwardingDate;
	}

	public void setForwardingDate(Date forwardingDate) {
		this.forwardingDate = forwardingDate;
	}

	public int getLegacyID() {
        return legacyID;
    }

    public void setLegacyID(int legacyID) {
        this.legacyID = legacyID;
    }

    public int getSiblingNumber() {
        return siblingNumber;
    }

    public void setSiblingNumber(int siblingNumber) {
        this.siblingNumber = siblingNumber;
    }

    public int getStaffMembersCount() {
        return staffMembersCount;
    }

    public void setStaffMembersCount(int staffMembersCount) {
        this.staffMembersCount = staffMembersCount;
    }

    public int getCoordinatorsNeeded() {
        return coordinatorsNeeded;
    }

    public void setCoordinatorsNeeded(int coordinatorsNeeded) {
        this.coordinatorsNeeded = coordinatorsNeeded;
    }

    public int getTeachersNeeded() {
        return teachersNeeded;
    }

    public void setTeachersNeeded(int teachersNeeded) {
        this.teachersNeeded = teachersNeeded;
    }

    public int getDramaTeachersNeeded() {
        return dramaTeachersNeeded;
    }

    public void setDramaTeachersNeeded(int dramaTeachersNeeded) {
        this.dramaTeachersNeeded = dramaTeachersNeeded;
    }

    public int getActivityLeadersNeeded() {
        return activityLeadersNeeded;
    }

    public void setActivityLeadersNeeded(int activityLeadersNeeded) {
        this.activityLeadersNeeded = activityLeadersNeeded;
    }

    public List<StaffMember> getStaffMembers() {
        return staffMembers;
    }

    public void setStaffMembers(List<StaffMember> staffMembers) {
        this.staffMembers = staffMembers;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }



	public int getDptCoordinatorsNeeded() {
		return dptCoordinatorsNeeded;
	}

	public void setDptCoordinatorsNeeded(int dptCoordinatorsNeeded) {
		this.dptCoordinatorsNeeded = dptCoordinatorsNeeded;
	}

	public int getCourseSpecialistsNeeded() {
		return courseSpecialistsNeeded;
	}

	public void setCourseSpecialistsNeeded(int courseSpecialistsNeeded) {
		this.courseSpecialistsNeeded = courseSpecialistsNeeded;
	}



	public int getDptCoordinatorsStillNeeded() {
		return dptCoordinatorsStillNeeded;
	}

	public void setDptCoordinatorsStillNeeded(int dptCoordinatorsStillNeeded) {
		this.dptCoordinatorsStillNeeded = dptCoordinatorsStillNeeded;
	}

	public int getCourseSpecialistsStillNeeded() {
		return courseSpecialistsStillNeeded;
	}

	public void setCourseSpecialistsStillNeeded(int courseSpecialistsStillNeeded) {
		this.courseSpecialistsStillNeeded = courseSpecialistsStillNeeded;
	}

	public int getActivityCoordinatorsNeeded() {
		return activityCoordinatorsNeeded;
	}

	public void setActivityCoordinatorsNeeded(int activityCoordinatorsNeeded) {
		this.activityCoordinatorsNeeded = activityCoordinatorsNeeded;
	}

	public int getActivityCoordinatorsStillNeeded() {
		return activityCoordinatorsStillNeeded;
	}

	public void setActivityCoordinatorsStillNeeded(
			int activityCoordinatorsStillNeeded) {
		this.activityCoordinatorsStillNeeded = activityCoordinatorsStillNeeded;
	}

	public String getOtherNotes() {
		return otherNotes;
	}

	public void setOtherNotes(String otherNotes) {
		this.otherNotes = otherNotes;
	}

	public String getHeadTeacher() {
		return headTeacher;
	}

	public void setHeadTeacher(String headTeacher) {
		this.headTeacher = headTeacher;
	}

	public String getAdminSchoolName() {
		return adminSchoolName;
	}

	public void setAdminSchoolName(String adminSchoolName) {
		this.adminSchoolName = adminSchoolName;
	}

	public String getAdminSchoolAddress() {
		return adminSchoolAddress;
	}

	public void setAdminSchoolAddress(String adminSchoolAddress) {
		this.adminSchoolAddress = adminSchoolAddress;
	}
    
    public String getTimetablingNotes() {
		return timetablingNotes;
	}

	public void setTimetablingNotes(String timetablingNotes) {
		this.timetablingNotes = timetablingNotes;
	}

	public int getSplitRoleNeeded() {
		return splitRoleNeeded;
	}

	public void setSplitRoleNeeded(int splitRoleNeeded) {
		this.splitRoleNeeded = splitRoleNeeded;
	}

	public int getFinalRegLastYear() {
		return finalRegLastYear;
	}

	public void setFinalRegLastYear(int finalRegLastYear) {
		this.finalRegLastYear = finalRegLastYear;
	}

	public int getFinalRegCurrentYear() {
		return finalRegCurrentYear;
	}

	public void setFinalRegCurrentYear(int finalRegCurrentYear) {
		this.finalRegCurrentYear = finalRegCurrentYear;
	}

	public int getStudentLevel1() {
		return studentLevel1;
	}

	public void setStudentLevel1(int studentLevel1) {
		this.studentLevel1 = studentLevel1;
	}

	public int getStudentLevel2() {
		return studentLevel2;
	}

	public void setStudentLevel2(int studentLevel2) {
		this.studentLevel2 = studentLevel2;
	}

	public int getStudentLevel3() {
		return studentLevel3;
	}

	public void setStudentLevel3(int studentLevel3) {
		this.studentLevel3 = studentLevel3;
	}

	public int getStudentLevel4() {
		return studentLevel4;
	}

	public void setStudentLevel4(int studentLevel4) {
		this.studentLevel4 = studentLevel4;
	}

	public int getStudentLevel5() {
		return studentLevel5;
	}

	public void setStudentLevel5(int studentLevel5) {
		this.studentLevel5 = studentLevel5;
	}

	public int getStudentLevel6() {
		return studentLevel6;
	}

	public void setStudentLevel6(int studentLevel6) {
		this.studentLevel6 = studentLevel6;
	}

	public int getStudentLevel7() {
		return studentLevel7;
	}

	public void setStudentLevel7(int studentLevel7) {
		this.studentLevel7 = studentLevel7;
	}

	public int getStudentLevel8() {
		return studentLevel8;
	}

	public void setStudentLevel8(int studentLevel8) {
		this.studentLevel8 = studentLevel8;
	}

}
