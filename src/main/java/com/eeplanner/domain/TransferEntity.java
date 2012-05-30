package com.eeplanner.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * User: iviec01
 * Date: 30/05/2012
 * Time: 16:17
 */
@Table(name = "transfer")
@Entity
public class TransferEntity {
    private int id;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String outboundType;

    @Column(name = "outbound_type")
    @Basic
    public String getOutboundType() {
        return outboundType;
    }

    public void setOutboundType(String outboundType) {
        this.outboundType = outboundType;
    }

    private String outboundReference;

    @Column(name = "outbound_reference")
    @Basic
    public String getOutboundReference() {
        return outboundReference;
    }

    public void setOutboundReference(String outboundReference) {
        this.outboundReference = outboundReference;
    }

    private Timestamp outboundDeparture;

    @Column(name = "outbound_departure")
    @Basic
    public Timestamp getOutboundDeparture() {
        return outboundDeparture;
    }

    public void setOutboundDeparture(Timestamp outboundDeparture) {
        this.outboundDeparture = outboundDeparture;
    }

    private String outboundDeparturePoint;

    @Column(name = "outbound_departure_point")
    @Basic
    public String getOutboundDeparturePoint() {
        return outboundDeparturePoint;
    }

    public void setOutboundDeparturePoint(String outboundDeparturePoint) {
        this.outboundDeparturePoint = outboundDeparturePoint;
    }

    private Timestamp outboundArrival;

    @Column(name = "outbound_arrival")
    @Basic
    public Timestamp getOutboundArrival() {
        return outboundArrival;
    }

    public void setOutboundArrival(Timestamp outboundArrival) {
        this.outboundArrival = outboundArrival;
    }

    private String outboundArrivalPoint;

    @Column(name = "outbound_arrival_point")
    @Basic
    public String getOutboundArrivalPoint() {
        return outboundArrivalPoint;
    }

    public void setOutboundArrivalPoint(String outboundArrivalPoint) {
        this.outboundArrivalPoint = outboundArrivalPoint;
    }

    private String outboundNotes;

    @Column(name = "outbound_notes")
    @Basic
    public String getOutboundNotes() {
        return outboundNotes;
    }

    public void setOutboundNotes(String outboundNotes) {
        this.outboundNotes = outboundNotes;
    }

    private String returnType;

    @Column(name = "return_type")
    @Basic
    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    private String returnReference;

    @Column(name = "return_reference")
    @Basic
    public String getReturnReference() {
        return returnReference;
    }

    public void setReturnReference(String returnReference) {
        this.returnReference = returnReference;
    }

    private Timestamp returnDeparture;

    @Column(name = "return_departure")
    @Basic
    public Timestamp getReturnDeparture() {
        return returnDeparture;
    }

    public void setReturnDeparture(Timestamp returnDeparture) {
        this.returnDeparture = returnDeparture;
    }

    private String returnDeparturePoint;

    @Column(name = "return_departure_point")
    @Basic
    public String getReturnDeparturePoint() {
        return returnDeparturePoint;
    }

    public void setReturnDeparturePoint(String returnDeparturePoint) {
        this.returnDeparturePoint = returnDeparturePoint;
    }

    private Timestamp returnArrival;

    @Column(name = "return_arrival")
    @Basic
    public Timestamp getReturnArrival() {
        return returnArrival;
    }

    public void setReturnArrival(Timestamp returnArrival) {
        this.returnArrival = returnArrival;
    }

    private String returnArrivalPoint;

    @Column(name = "return_arrival_point")
    @Basic
    public String getReturnArrivalPoint() {
        return returnArrivalPoint;
    }

    public void setReturnArrivalPoint(String returnArrivalPoint) {
        this.returnArrivalPoint = returnArrivalPoint;
    }

    private String returnNotes;

    @Column(name = "return_notes")
    @Basic
    public String getReturnNotes() {
        return returnNotes;
    }

    public void setReturnNotes(String returnNotes) {
        this.returnNotes = returnNotes;
    }

    private byte deleted;

    @Column(name = "deleted")
    @Basic
    public byte getDeleted() {
        return deleted;
    }

    public void setDeleted(byte deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransferEntity that = (TransferEntity) o;

        if (deleted != that.deleted) return false;
        if (id != that.id) return false;
        if (outboundArrival != null ? !outboundArrival.equals(that.outboundArrival) : that.outboundArrival != null)
            return false;
        if (outboundArrivalPoint != null ? !outboundArrivalPoint.equals(that.outboundArrivalPoint) : that.outboundArrivalPoint != null)
            return false;
        if (outboundDeparture != null ? !outboundDeparture.equals(that.outboundDeparture) : that.outboundDeparture != null)
            return false;
        if (outboundDeparturePoint != null ? !outboundDeparturePoint.equals(that.outboundDeparturePoint) : that.outboundDeparturePoint != null)
            return false;
        if (outboundNotes != null ? !outboundNotes.equals(that.outboundNotes) : that.outboundNotes != null)
            return false;
        if (outboundReference != null ? !outboundReference.equals(that.outboundReference) : that.outboundReference != null)
            return false;
        if (outboundType != null ? !outboundType.equals(that.outboundType) : that.outboundType != null) return false;
        if (returnArrival != null ? !returnArrival.equals(that.returnArrival) : that.returnArrival != null)
            return false;
        if (returnArrivalPoint != null ? !returnArrivalPoint.equals(that.returnArrivalPoint) : that.returnArrivalPoint != null)
            return false;
        if (returnDeparture != null ? !returnDeparture.equals(that.returnDeparture) : that.returnDeparture != null)
            return false;
        if (returnDeparturePoint != null ? !returnDeparturePoint.equals(that.returnDeparturePoint) : that.returnDeparturePoint != null)
            return false;
        if (returnNotes != null ? !returnNotes.equals(that.returnNotes) : that.returnNotes != null) return false;
        if (returnReference != null ? !returnReference.equals(that.returnReference) : that.returnReference != null)
            return false;
        if (returnType != null ? !returnType.equals(that.returnType) : that.returnType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (outboundType != null ? outboundType.hashCode() : 0);
        result = 31 * result + (outboundReference != null ? outboundReference.hashCode() : 0);
        result = 31 * result + (outboundDeparture != null ? outboundDeparture.hashCode() : 0);
        result = 31 * result + (outboundDeparturePoint != null ? outboundDeparturePoint.hashCode() : 0);
        result = 31 * result + (outboundArrival != null ? outboundArrival.hashCode() : 0);
        result = 31 * result + (outboundArrivalPoint != null ? outboundArrivalPoint.hashCode() : 0);
        result = 31 * result + (outboundNotes != null ? outboundNotes.hashCode() : 0);
        result = 31 * result + (returnType != null ? returnType.hashCode() : 0);
        result = 31 * result + (returnReference != null ? returnReference.hashCode() : 0);
        result = 31 * result + (returnDeparture != null ? returnDeparture.hashCode() : 0);
        result = 31 * result + (returnDeparturePoint != null ? returnDeparturePoint.hashCode() : 0);
        result = 31 * result + (returnArrival != null ? returnArrival.hashCode() : 0);
        result = 31 * result + (returnArrivalPoint != null ? returnArrivalPoint.hashCode() : 0);
        result = 31 * result + (returnNotes != null ? returnNotes.hashCode() : 0);
        result = 31 * result + (int) deleted;
        return result;
    }
}
