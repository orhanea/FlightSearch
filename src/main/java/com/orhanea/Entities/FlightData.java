package com.orhanea.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="flights")
@ToString
public class FlightData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private int flightID;
    @Column(name="departure_airport")
    private String departureAirport;
    @Column(name="arrival_airport")
    private String arrivalAirport;
    @Column(name="departure_datetime")
    private LocalDateTime departureDatetime;
    @Column(name="return_datetime")
    private LocalDateTime returnDatetime;
    @Column(name="price")
    private Double price;

    public FlightData(int flightID, String departureAirport, String arrivalAirport, LocalDateTime departureDatetime, LocalDateTime returnDatetime, double price) {
        this.flightID = flightID;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDatetime = departureDatetime;
        this.returnDatetime = returnDatetime;
        this.price = price;
    }

    public FlightData() {

    }

    public Integer getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getDepartureDatetime() {
        return departureDatetime;
    }

    public void setDepartureDatetime(LocalDateTime departureDatetime) {
        this.departureDatetime = departureDatetime;
    }
    public LocalDateTime getReturnDatetime() {
        return returnDatetime;
    }

    public void setReturnDatetime(LocalDateTime returnDatetime) {
        this.returnDatetime = returnDatetime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
