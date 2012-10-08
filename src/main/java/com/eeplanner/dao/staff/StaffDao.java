package com.eeplanner.dao.staff;

import com.eeplanner.datastructures.*;

import java.util.List;

public interface StaffDao {
    public StaffMember getStaffMemberByID(int id);
    public StaffMember getStaffMemberByHash(String hash);
    public List<StaffMember> getStaffList(String orderBy, boolean showDeleted, String role);
    public List<StaffMember> getStaffList(String orderBy, boolean showDeleted, String role, int year);
    public List<StaffMember> getStaffByName(String name, String orderBy);
    public StaffMember storeStaffMember(StaffMember staffMember);
    public List<StaffMember> getAvailableStaffMembers(int campID,int theYear, String orderBy, boolean showDeleted);
    public List<StaffMember> getAvailableStaffMembersForCamp(Camp camp, String orderBy);
    public List<StaffMember> getStaffMembersForCamp(Camp camp, String orderBy);
    public int getStaffMembersCountForCamp(Camp camp);
    public List<StaffMember> getStaffMembersForFlight(Flight flight, String orderBy);
    public StaffMember getStaffMemberForFlight(Flight flight, int staffMemberID);
    public StaffMember getStaffMemberForCamp(int staffMemberID, int campID);
    public List<StaffMemberSearchData> getStaffMemberSearchData(int staffMemberID, String orderBy);
    public boolean setDeleted(int id, boolean isDeleted);
    public boolean delete(int id);
    public List<Itinerary> getListOfItinerariesForStaffMember(int staffID,int theYear);

}
