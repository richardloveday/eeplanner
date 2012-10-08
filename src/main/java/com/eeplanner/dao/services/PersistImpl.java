package com.eeplanner.dao.services;

import org.apache.log4j.Logger;

import com.eeplanner.dao.camp.CampDao;
import com.eeplanner.dao.contact.ContactDao;
import com.eeplanner.dao.email.EmailDao;
import com.eeplanner.dao.flight.FlightDao;
import com.eeplanner.dao.itinerary.ItineraryDao;
import com.eeplanner.dao.note.NoteDao;
import com.eeplanner.dao.phone.PhoneDao;
import com.eeplanner.dao.staff.StaffDao;
import com.eeplanner.dao.staffavailability.StaffAvailabilityDao;
import com.eeplanner.dao.transfer.TransferDao;
import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.Contact;
import com.eeplanner.datastructures.ContactType;
import com.eeplanner.datastructures.Flight;
import com.eeplanner.datastructures.StaffMember;

public class PersistImpl implements Persist {

    private StaffDao staffDao;
    private PhoneDao phoneDao;
    private EmailDao emailDao;
    private NoteDao noteDao;
    private ContactDao contactDao;
    private CampDao campDao;
    private FlightDao flightDao;
    private TransferDao transferDao;
    private StaffAvailabilityDao staffAvailabilityDao;
    private ItineraryDao itineraryDao;

    Logger log = Logger.getLogger(PersistImpl.class);

    private void removeContactEmailsPhonesNotes(int contactID) {
        contactDao.removeContactEmails(contactID);
        contactDao.removeContactPhoneNumbers(contactID);
        contactDao.removeContactNotes(contactID);
    }

    public StaffMember storeStaffMember(StaffMember staffMember) throws Exception {

        try {
            staffMember.getContact().setType(ContactType.staff.getName());
            Contact c = contactDao.storeContact(staffMember.getContact());


            // remove the current ones before adding new ones
            removeContactEmailsPhonesNotes(c.getID());
            // add new ones

            c.setPhoneNumbers(phoneDao.storePhoneNumbers(c));
            c.setEmails(emailDao.storeEmails(c));
            c.setNotes(noteDao.storeNotes(c));
            staffMember.setContact(c);

            if (staffMember.getID() == 0) {
            	staffMember = staffDao.storeStaffMember(staffMember);
            	staffMember.getStaffAvailability().setID(staffMember.getID());
            	for (int theYear=2010;theYear<2020;theYear++){
            		staffAvailabilityDao.createNewStaffAvailabilityForStaff(staffMember.getID(), theYear);
            	}
            } else {
            	staffMember = staffDao.storeStaffMember(staffMember);
            }
            staffAvailabilityDao.storeStaffAvailability(staffMember.getStaffAvailability());


            return staffMember;
        }
        catch (Exception e) {
            log.fatal(e.getMessage());
        }

        return staffMember;
    }
    
    public StaffMember updateBackStaffMember(StaffMember hashedStaffMember) throws Exception {

        try {
        	
			StaffMember parent = staffDao.getStaffMemberByID(hashedStaffMember.getParentID());
			
			Contact previousContact = parent.getContact();
			parent.setContact(hashedStaffMember.getContact());
			parent.setParentID(-1);
			
			parent.setStaffAvailability(hashedStaffMember.getStaffAvailability());
			parent.getStaffAvailability().setID(parent.getID());
			
			// Copy fields
			parent.setMedical(hashedStaffMember.getMedical());
			parent.setDietary(hashedStaffMember.getDietary());
			parent.setKinName(hashedStaffMember.getKinName());
			parent.setKinNumber(hashedStaffMember.getKinNumber());
			parent.setTeacher(hashedStaffMember.isTeacher());
			parent.setActivityleader(hashedStaffMember.isActivityleader());
			parent.setDrama(hashedStaffMember.isDrama());
			parent.setCoordinator(hashedStaffMember.isCoordinator());
			parent.setTravelWithinLondon(hashedStaffMember.isTravelWithinLondon());
			parent.setTravelOutside(hashedStaffMember.isTravelOutside());
			parent.setProfile(hashedStaffMember.getProfile());
			parent.setPrefAgeGroup1(hashedStaffMember.isPrefAgeGroup1());
			parent.setPrefAgeGroup2(hashedStaffMember.isPrefAgeGroup2());
			parent.setPrefAgeAny(hashedStaffMember.isPrefAgeAny());
			parent.setPrefActivityAny(hashedStaffMember.getPrefActivityAny());
			parent.setPrefActivityArt(hashedStaffMember.getPrefActivityArt());
			parent.setPrefActivityDrama(hashedStaffMember.getPrefActivityDrama());
			parent.setPrefActivitySport(hashedStaffMember.getPrefActivitySport());
			parent.setStaffNotes(hashedStaffMember.getStaffNotes());
			parent.setMixedRole(hashedStaffMember.isMixedRole());
			
			this.storeStaffMember(parent);
			
            removeContactEmailsPhonesNotes(previousContact.getID());
            contactDao.removeContact(previousContact.getID());
            staffDao.delete(hashedStaffMember.getID());
            staffAvailabilityDao.deleteAvailabilityForStaff(hashedStaffMember.getID());
            
            return parent;
        }
        catch (Exception e) {
            log.fatal(e.getMessage());
        }

        return hashedStaffMember;
    }

    public Flight storeFlight(Flight flight) throws Exception {

        try {
            flight = flightDao.storeFlight(flight);
            return flight;
        }
        catch (Exception e) {
            log.fatal(e.getMessage());
        }

        return flight;
    }

    public Camp storeCamp(Camp camp) throws Exception {

        try {
            camp.getContact().setType(ContactType.coordinator.getName());

            Contact c = contactDao.storeContact(camp.getContact());


            // remove the current ones before adding new ones
            removeContactEmailsPhonesNotes(c.getID());
            // add new ones

            c.setPhoneNumbers(phoneDao.storePhoneNumbers(c));
            c.setEmails(emailDao.storeEmails(c));
            c.setNotes(noteDao.storeNotes(c));
            camp.setContact(c);
            camp.setContactID(c.getID());

            camp.getSchoolContact().setType(ContactType.school.getName());

            Contact sc = contactDao.storeContact(camp.getSchoolContact());


            // remove the current ones before adding new ones
            removeContactEmailsPhonesNotes(sc.getID());
            // add new ones

            sc.setPhoneNumbers(phoneDao.storePhoneNumbers(sc));
            sc.setEmails(emailDao.storeEmails(sc));
            sc.setNotes(noteDao.storeNotes(sc));
            camp.setSchoolContact(sc);
            camp.setSchoolContactID(sc.getID());


            camp = campDao.storeCamp(camp);

            return camp;
        }
        catch (Exception e) {
            log.fatal(e.getMessage());
        }

        return camp;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    public void setPhoneDao(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    public void setEmailDao(EmailDao emailDao) {
        this.emailDao = emailDao;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public void setCampDao(CampDao campDao) {
        this.campDao = campDao;
    }

    public void setFlightDao(FlightDao flightDao) {
        this.flightDao = flightDao;
    }

	public void setStaffAvailabilityDao(StaffAvailabilityDao staffAvailabilityDao) {
		this.staffAvailabilityDao = staffAvailabilityDao;
	}

	public void setItineraryDao(ItineraryDao itineraryDao) {
		this.itineraryDao = itineraryDao;
	}

	public ItineraryDao getItineraryDao() {
		return itineraryDao;
	}

	public void setTransferDao(TransferDao transferDao) {
		this.transferDao = transferDao;
	}

	public TransferDao getTransferDao() {
		return transferDao;
	}

}
