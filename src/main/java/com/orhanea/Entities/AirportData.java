package com.orhanea.Entities;

import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@Table(name="airports")
@ToString
public class AirportData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="airport_id")
    private int airportID;
    @Column(name="city")
    private String city;

    public AirportData(int airportID, String city) {
        this.airportID = airportID;
        this.city = city;
    }

    public AirportData() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}