package com.eeplanner.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: iviec01
 * Date: 30/05/2012
 * Time: 16:17
 */
public class TransfercampEntityPK implements Serializable {
    private int transferId;

    @Id
    @Column(name = "transferID")
    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    private int campId;

    @Id
    @Column(name = "campID")
    public int getCampId() {
        return campId;
    }

    public void setCampId(int campId) {
        this.campId = campId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransfercampEntityPK that = (TransfercampEntityPK) o;

        if (campId != that.campId) return false;
        if (transferId != that.transferId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transferId;
        result = 31 * result + campId;
        return result;
    }
}
