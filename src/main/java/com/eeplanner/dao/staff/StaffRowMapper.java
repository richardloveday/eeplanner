package com.eeplanner.dao.staff;

import com.eeplanner.dao.staffavailability.StaffAvailabilityRowMapper;
import com.eeplanner.datastructures.Contact;
import com.eeplanner.datastructures.StaffAvailability;
import com.eeplanner.datastructures.StaffMember;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffRowMapper implements RowMapper {
	
	StaffAvailabilityRowMapper availabilityRowMapper = new StaffAvailabilityRowMapper();
	
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        StaffMember staffMember = new StaffMember();
        staffMember.setID(rs.getInt("ID"));
        staffMember.setTeacher(rs.getBoolean("teacher"));
        staffMember.setCoordinator(rs.getBoolean("coordinator"));
        staffMember.setDrama(rs.getBoolean("drama"));
        staffMember.setActivityleader(rs.getBoolean("activityleader"));
        staffMember.setActivityCoordinator(rs.getBoolean("activityCoordinator"));
        staffMember.setDptCoordinator(rs.getBoolean("dptCoordinator"));
        staffMember.setCourseSpecialist(rs.getBoolean("courseSpecialist"));
        staffMember.setKinName(rs.getString("kinName"));
        staffMember.setKinNumber(rs.getString("kinNumber"));
        staffMember.setArchivePassword(rs.getString("archivePassword"));
        staffMember.setExisting(rs.getBoolean("existing"));
        staffMember.setApplied(rs.getBoolean("applied"));
        staffMember.setInterviewed(rs.getBoolean("interviewed"));
        staffMember.setApproved(rs.getBoolean("approved"));
        staffMember.setStatus(rs.getString("status"));
        staffMember.setDeleted(rs.getBoolean("deleted"));
        staffMember.setProfile(rs.getString("profile"));
        staffMember.setMedical(rs.getString("medical"));
        staffMember.setDietary(rs.getString("dietary"));
        staffMember.setTravelOutside(rs.getBoolean("travelOutside"));
        staffMember.setTravelWithinLondon(rs.getBoolean("travelWithinLondon"));
        staffMember.setOfficeNotes(rs.getString("officeNotes"));
        staffMember.setMixedRole(rs.getBoolean("mixedRole"));
        staffMember.setPrefAgeAny(rs.getBoolean("prefAgeAny"));
        staffMember.setPrefAgeGroup1(rs.getBoolean("prefAgeGroup1"));
        staffMember.setPrefAgeGroup2(rs.getBoolean("prefAgeGroup2"));
        staffMember.setPrefActivityArt(rs.getInt("prefActivityArt"));
        staffMember.setPrefActivitySport(rs.getInt("prefActivitySport"));
        staffMember.setPrefActivityDrama(rs.getInt("prefActivityDrama"));
        staffMember.setPrefActivityAny(rs.getInt("prefActivityAny"));
        staffMember.setStaffNotes(rs.getString("staffNotes"));
        staffMember.setHash(rs.getString("hash"));
        staffMember.setParentID(rs.getInt("parentID"));
        
        Contact contact = new Contact();
        contact.setID(rs.getInt("contactID"));
        contact.setFirstNames(rs.getString("firstNames"));
        contact.setSecondName(rs.getString("secondName"));
        contact.setAdd1(rs.getString("add1"));
        contact.setAdd2(rs.getString("add2"));
        contact.setAdd3(rs.getString("add3"));
        contact.setAdd4(rs.getString("add4"));
        contact.setPostCode(rs.getString("postCode"));
        contact.setDob(rs.getTimestamp("dob"));
        contact.setSex(rs.getString("sex"));
        contact.setAccountHolderName(rs.getString("accountHolderName"));
        contact.setAccountNumber(rs.getString("accountNumber"));
        contact.setAccountSortCode(rs.getString("accountSortCode"));
        contact.setNationalInsuranceNumber(rs.getString("nationalInsuranceNumber"));
        
        staffMember.setContact(contact);
        
        StaffAvailability staffAvailability = null;
        try {
        	staffAvailability = availabilityRowMapper.mapRow(rs, rowNum);
        	staffMember.setStaffAvailability(staffAvailability);
        }catch(SQLException exception) {
        	//ignore
        }
        
        return staffMember;
    }
}
