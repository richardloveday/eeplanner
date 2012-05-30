package com.eeplanner.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "flight")
@Entity
public class FlightEntity {
    private int id;

    @Column(name = "ID")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String carrier;

    @Column(name = "carrier")
    @Basic
    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    private String type;

    @Column(name = "type")
    @Basic
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String flightNumber;

    @Column(name = "flightNumber")
    @Basic
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    private String returnFlightNumber;

    @Column(name = "returnFlightNumber")
    @Basic
    public String getReturnFlightNumber() {
        return returnFlightNumber;
    }

    public void setReturnFlightNumber(String returnFlightNumber) {
        this.returnFlightNumber = returnFlightNumber;
    }

    private Timestamp outboundArrival;

    @Column(name = "outboundArrival")
    @Basic
    public Timestamp getOutboundArrival() {
        return outboundArrival;
    }

    public void setOutboundArrival(Timestamp outboundArrival) {
        this.outboundArrival = outboundArrival;
    }

    private Timestamp outboundDeparture;

    @Column(name = "outboundDeparture")
    @Basic
    public Timestamp getOutboundDeparture() {
        return outboundDeparture;
    }

    public void setOutboundDeparture(Timestamp outboundDeparture) {
        this.outboundDeparture = outboundDeparture;
    }

    private int cost;

    @Column(name = "cost")
    @Basic
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    private int campId;

    @Column(name = "campID")
    @Basic
    public int getCampId() {
        return campId;
    }

    public void setCampId(int campId) {
        this.campId = campId;
    }

    private String destination;

    @Column(name = "destination")
    @Basic
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    private int numberOfSeats;

    @Column(name = "numberOfSeats")
    @Basic
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    private String airport;

    @Column(name = "airport")
    @Basic
    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    private Timestamp returnArrival;

    @Column(name = "returnArrival")
    @Basic
    public Timestamp getReturnArrival() {
        return returnArrival;
    }

    public void setReturnArrival(Timestamp returnArrival) {
        this.returnArrival = returnArrival;
    }

    private Timestamp returnDeparture;

    @Column(name = "returnDeparture")
    @Basic
    public Timestamp getReturnDeparture() {
        return returnDeparture;
    }

    public void setReturnDeparture(Timestamp returnDeparture) {
        this.returnDeparture = returnDeparture;
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

    private String notes;

    @Column(name = "notes")
    @Basic
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightEntity that = (FlightEntity) o;

        if (campId != that.campId) return false;
        if (cost != that.cost) return false;
        if (deleted != that.deleted) return false;
        if (id != that.id) return false;
        if (numberOfSeats != that.numberOfSeats) return false;
        if (airport != null ? !airport.equals(that.airport) : that.airport != null) return false;
        if (carrier != null ? !carrier.equals(that.carrier) : that.carrier != null) return false;
        if (destination != null ? !destination.equals(that.destination) : that.destination != null) return false;
        if (flightNumber != null ? !flightNumber.equals(that.flightNumber) : that.flightNumber != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (outboundArrival != null ? !outboundArrival.equals(that.outboundArrival) : that.outboundArrival != null)
            return false;
        if (outboundDeparture != null ? !outboundDeparture.equals(that.outboundDeparture) : that.outboundDeparture != null)
            return false;
        if (returnArrival != null ? !returnArrival.equals(that.returnArrival) : that.returnArrival != null)
            return false;
        if (returnDeparture != null ? !returnDeparture.equals(that.returnDeparture) : that.returnDeparture != null)
            return false;
        if (returnFlightNumber != null ? !returnFlightNumber.equals(that.returnFlightNumber) : that.returnFlightNumber != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (carrier != null ? carrier.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (flightNumber != null ? flightNumber.hashCode() : 0);
        result = 31 * result + (returnFlightNumber != null ? returnFlightNumber.hashCode() : 0);
        result = 31 * result + (outboundArrival != null ? outboundArrival.hashCode() : 0);
        result = 31 * result + (outboundDeparture != null ? outboundDeparture.hashCode() : 0);
        result = 31 * result + cost;
        result = 31 * result + campId;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + numberOfSeats;
        result = 31 * result + (airport != null ? airport.hashCode() : 0);
        result = 31 * result + (returnArrival != null ? returnArrival.hashCode() : 0);
        result = 31 * result + (returnDeparture != null ? returnDeparture.hashCode() : 0);
        result = 31 * result + (int) deleted;
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
