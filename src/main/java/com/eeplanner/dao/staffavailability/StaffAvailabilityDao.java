package com.eeplanner.dao.staffavailability;

import com.eeplanner.datastructures.StaffAvailability;


public interface StaffAvailabilityDao {

	public StaffAvailability getStaffAvailabilityByIDAndYear(int staffID, int year);
	public void createNewStaffAvailabilityForStaff(int staffID, int theYear);
	public void storeStaffAvailability(StaffAvailability staffAvailability);
	public void deleteAvailabilityForStaff(int id);
	
}
