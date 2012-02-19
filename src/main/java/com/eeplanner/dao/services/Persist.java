package com.eeplanner.dao.services;

import com.eeplanner.datastructures.*;

/**
 * Created by IntelliJ IDEA.
 * User: IvieC
 * Date: 11-Dec-2009
 * Time: 15:59:31
 * To change this template use File | Settings | File Templates.
 */

public interface Persist {

    public StaffMember storeStaffMember(StaffMember staffMember) throws Exception;
    public Camp storeCamp(Camp camp) throws Exception;
    public Flight storeFlight(Flight flight) throws Exception;
    
    public StaffMember updateBackStaffMember(StaffMember staffMember) throws Exception;
}
