package com.eeplanner.datastructures;

import java.util.List;

import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.Contact;
import com.eeplanner.datastructures.StaffAvailability;


/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 10-Dec-2009
 * Time: 14:52:08
 * To change this template use File | Settings | File Templates.
 */
public class StaffMember {

    private int ID;
    private int campID;
    private boolean accepted;
    private boolean offered;
    private boolean returned;
    private boolean teacher;
    private boolean coordinator;
    private boolean drama;
    private boolean activityleader;
    private boolean activityCoordinator;
    private boolean dptCoordinator;
    private boolean courseSpecialist;
    private String kinName;
    private String kinNumber;
    private String archivePassword;
    private boolean existing;
    private boolean applied;
    private boolean interviewed;
    private boolean approved;
    private String status;
    private boolean deleted;
    private StaffAvailability staffAvailability;

    private String profile;
    private String medical;
    private String dietary;
    
    private String job;
    private boolean infoSent;
    private boolean transferNeeded;
    private Contact contact = new Contact();
    private Camp camp = new Camp();
    
    private List<Itinerary> itineraries;
    
    private boolean travelOutside;
    private boolean travelWithinLondon;
    private String  officeNotes;
    private boolean mixedRole;
    private boolean prefAgeAny;
    private boolean prefAgeGroup1;
    private boolean prefAgeGroup2;
    private int prefActivityArt;
    private int prefActivitySport;
    private int prefActivityDrama;
    private int prefActivityAny;
    private String staffNotes;
    
    private int parentID;
    private String hash;

    public StaffMember(){}    
    
    public StaffMember(int iD, int campID, boolean accepted, boolean offered,
			String job, boolean infoSent, Contact contact, Camp camp) {
		this.ID = iD;
		this.campID = campID;
		this.accepted = accepted;
		this.offered = offered;
		this.job = job;
		this.infoSent = infoSent;
		this.contact = contact;
		this.camp = camp;
	}



	public StaffMember(int ID, int campID, boolean accepted, boolean offered, String job, Contact contact, Camp camp) {
        this.ID = ID;
        this.campID = campID;
        this.accepted = accepted;
        this.offered = offered;
        this.contact = contact;
        this.camp = camp;
        this.job = job;
    }

    public StaffMember(int ID, int campID, boolean accepted, boolean offered, String job) {
        this.ID = ID;
        this.campID = campID;
        this.accepted = accepted;
        this.offered = offered;
        this.job = job;
    }
    
    public StaffMember(int ID, int campID, boolean accepted, boolean offered, Contact contact, Camp camp) {
        this.ID = ID;
        this.campID = campID;
        this.accepted = accepted;
        this.offered = offered;
        this.contact = contact;
        this.camp = camp;
    }

    public StaffMember(int ID, int campID, boolean accepted, boolean offered) {
        this.ID = ID;
        this.campID = campID;
        this.accepted = accepted;
        this.offered = offered;
    }
    
    

    public boolean isReturned() {
		return returned;
	}



	public void setReturned(boolean returned) {
		this.returned = returned;
	}

	public boolean isDeleted() {
		return deleted;
	}

    public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
    
	public boolean isTransferNeeded() {
        return transferNeeded;
    }

    public void setTransferNeeded(boolean transferNeeded) {
        this.transferNeeded = transferNeeded;
    }

    public boolean isExisting() {
        return existing;
    }

    public void setExisting(boolean existing) {
        this.existing = existing;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArchivePassword() {
        return archivePassword;
    }

    public void setArchivePassword(String archivePassword) {
        this.archivePassword = archivePassword;
    }

    public String getKinName() {
        return kinName;
    }

    public void setKinName(String kinName) {
        this.kinName = kinName;
    }

    public String getKinNumber() {
        return kinNumber;
    }

    public void setKinNumber(String kinNumber) {
        this.kinNumber = kinNumber;
    }

    public boolean isTeacher() {
        return teacher;
    }

    public void setTeacher(boolean teacher) {
        this.teacher = teacher;
    }

    public boolean isCoordinator() {
        return coordinator;
    }

    public void setCoordinator(boolean coordinator) {
        this.coordinator = coordinator;
    }

    public boolean isDrama() {
        return drama;
    }

    public void setDrama(boolean drama) {
        this.drama = drama;
    }

    public boolean isActivityleader() {
        return activityleader;
    }

    public void setActivityleader(boolean activityleader) {
        this.activityleader = activityleader;
    }

    public boolean isInfoSent() {
		return infoSent;
	}



	public void setInfoSent(boolean infoSent) {
		this.infoSent = infoSent;
	}



	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Camp getCamp() {
        return camp;
    }

    public void setCamp(Camp camp) {
        this.camp = camp;
    }

    public int getCampID() {
        return campID;
    }

    public void setCampID(int campID) {
        this.campID = campID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isOffered() {
        return offered;
    }

    public void setOffered(boolean offered) {
        this.offered = offered;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
    public int getContactID(){
    	return getContact().getID();
    }



	public boolean isActivityCoordinator() {
		return activityCoordinator;
	}



	public void setActivityCoordinator(boolean activityCoordinator) {
		this.activityCoordinator = activityCoordinator;
	}



	public boolean isDptCoordinator() {
		return dptCoordinator;
	}



	public void setDptCoordinator(boolean dptCoordinator) {
		this.dptCoordinator = dptCoordinator;
	}



	public boolean isCourseSpecialist() {
		return courseSpecialist;
	}



	public void setCourseSpecialist(boolean courseSpecialist) {
		this.courseSpecialist = courseSpecialist;
	}



	public StaffAvailability getStaffAvailability() {
		return staffAvailability;
	}



	public void setStaffAvailability(StaffAvailability staffAvailability) {
		this.staffAvailability = staffAvailability;
	}



	public String getProfile() {
		return profile;
	}



	public void setProfile(String profile) {
		this.profile = profile;
	}



	public String getMedical() {
		return medical;
	}



	public void setMedical(String medical) {
		this.medical = medical;
	}



	public String getDietary() {
		return dietary;
	}



	public void setDietary(String dietary) {
		this.dietary = dietary;
	}



	public boolean isApplied() {
		return applied;
	}



	public void setApplied(boolean applied) {
		this.applied = applied;
	}



	public boolean isInterviewed() {
		return interviewed;
	}



	public void setInterviewed(boolean interviewed) {
		this.interviewed = interviewed;
	}



	public boolean isApproved() {
		return approved;
	}



	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public void setItineraries(List<Itinerary> itineraries) {
		this.itineraries = itineraries;
	}

	public List<Itinerary> getItineraries() {
		return itineraries;
	}

	public boolean isTravelOutside() {
		return travelOutside;
	}

	public void setTravelOutside(boolean travelOutside) {
		this.travelOutside = travelOutside;
	}

	public boolean isTravelWithinLondon() {
		return travelWithinLondon;
	}

	public void setTravelWithinLondon(boolean travelWithinLondon) {
		this.travelWithinLondon = travelWithinLondon;
	}

	public String getOfficeNotes() {
		return officeNotes;
	}

	public void setOfficeNotes(String officeNotes) {
		this.officeNotes = officeNotes;
	}

	public boolean isMixedRole() {
		return mixedRole;
	}

	public void setMixedRole(boolean mixedRole) {
		this.mixedRole = mixedRole;
	}

	public boolean isPrefAgeAny() {
		return prefAgeAny;
	}

	public void setPrefAgeAny(boolean prefAgeAny) {
		this.prefAgeAny = prefAgeAny;
	}

	public boolean isPrefAgeGroup1() {
		return prefAgeGroup1;
	}

	public void setPrefAgeGroup1(boolean prefAgeGroup1) {
		this.prefAgeGroup1 = prefAgeGroup1;
	}

	public boolean isPrefAgeGroup2() {
		return prefAgeGroup2;
	}

	public void setPrefAgeGroup2(boolean prefAgeGroup2) {
		this.prefAgeGroup2 = prefAgeGroup2;
	}

	public int getPrefActivityArt() {
		return prefActivityArt;
	}

	public void setPrefActivityArt(int prefActivityArt) {
		this.prefActivityArt = prefActivityArt;
	}

	public int getPrefActivitySport() {
		return prefActivitySport;
	}

	public void setPrefActivitySport(int prefActivitySport) {
		this.prefActivitySport = prefActivitySport;
	}

	public int getPrefActivityDrama() {
		return prefActivityDrama;
	}

	public void setPrefActivityDrama(int prefActivityDrama) {
		this.prefActivityDrama = prefActivityDrama;
	}

	public int getPrefActivityAny() {
		return prefActivityAny;
	}

	public void setPrefActivityAny(int prefActivityAny) {
		this.prefActivityAny = prefActivityAny;
	}

	public String getStaffNotes() {
		return staffNotes;
	}

	public void setStaffNotes(String staffNotes) {
		this.staffNotes = staffNotes;
	}

	public int getParentID() {
		return parentID;
	}

	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

}
