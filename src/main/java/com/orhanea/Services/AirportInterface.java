package com.orhanea.Services;

import com.orhanea.Entities.AirportData;

import java.util.List;

public interface AirportInterface {

    AirportData updateAirportByAirportID(int airportID, AirportData city);

    AirportData getAirportByAirportID(int airportID);

    List<AirportData> getAirportByCity(String city);

    AirportData createAirport(AirportData airport);

    List<AirportData> getAllAirports();

    void deleteAirportByAirportID(int airportID);
}
