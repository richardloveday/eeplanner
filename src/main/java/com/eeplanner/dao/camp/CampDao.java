package com.eeplanner.dao.camp;

import com.eeplanner.datastructures.Camp;
import com.eeplanner.datastructures.CampStaff;

import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 11-Jan-2010
 * Time: 15:11:13
 * To change this template use File | Settings | File Templates.
 */
public interface CampDao {

    public Camp getCampByID(int id);
    public CampStaff getCampStaff(int campId, int staffId);
    public List<Camp> getCampList(String orderBy, boolean includeDeleted);
    public List<Camp> getCampListWithStaff(String orderBy, boolean includeDeleted);
    public List<Camp> getCampListWithStaffWithYear(String orderBy, boolean includeDeleted, int theYear);
    public List<Camp> getCampsByName(String name);
    public List<Camp> getCampsByStaffMemberID(int staffMemberID, String orderBy);
    public List<Camp> getCampsForFlight(int flightID, String orderBy);
    public List<Camp> getCampsForTransfer(int transferID, String orderBy);
    public List<Camp> getAvailableCampsForFlight(int flightID, String orderBy, boolean includeDeleted);
    public List<Camp> getAvailableCampsForTransfer(int transferID, String orderBy, boolean includeDeleted);
    public Camp storeCamp(Camp camp);
    public boolean setDeleted(int id, boolean isDeleted);
    public boolean removeAllCampStaffMembers(int campID);
    public boolean removeCampStaffMember(int campID, int staffMemberID);
    public boolean addCampStaffMember(int campID, int staffMemberID);
    public boolean editCampStaffMember(CampStaff campStaff);

    public HashMap<String, Object> getCampSearchData(int campID, String orderBy);
}
