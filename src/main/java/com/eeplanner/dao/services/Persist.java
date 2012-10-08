package com.eeplanner.dao.services;

import com.eeplanner.datastructures.*;

public interface Persist {

    public StaffMember storeStaffMember(StaffMember staffMember) throws Exception;
    public Camp storeCamp(Camp camp) throws Exception;
    public Flight storeFlight(Flight flight) throws Exception;
    
    public StaffMember updateBackStaffMember(StaffMember staffMember) throws Exception;
}
