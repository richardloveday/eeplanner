package com.eeplanner.dao.transfer;

import java.util.List;

import com.eeplanner.datastructures.Flight;
import com.eeplanner.datastructures.Transfer;

public interface TransferDao {

    public List<Transfer> getTransferListByYear(String orderBy, boolean showDeleted, int year);
    public List<Transfer> getTransferList(String orderBy, boolean showDeleted);
	public Transfer storeTransfer(Transfer transfer);
	public List<Transfer> getTransfersByItineraryID(int itineraryID);
	public Transfer getTransferByID(int id);
    public boolean setDeleted(int id, boolean isDeleted);

}
