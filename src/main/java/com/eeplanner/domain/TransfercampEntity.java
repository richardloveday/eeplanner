package com.eeplanner.domain;

import javax.persistence.*;

/**
 * User: iviec01
 * Date: 30/05/2012
 * Time: 16:17
 */
@IdClass(com.eeplanner.domain.TransfercampEntityPK.class)
@Table(name = "transfercamp")
@Entity
public class TransfercampEntity {
    private int transferId;

    @Column(name = "transferID")
    @Id
    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    private int campId;

    @Column(name = "campID")
    @Id
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

        TransfercampEntity that = (TransfercampEntity) o;

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
