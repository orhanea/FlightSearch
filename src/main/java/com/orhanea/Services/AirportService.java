package com.orhanea.Services;

import com.orhanea.Entities.AirportData;
import com.orhanea.Exception.AirportNotFound;
import com.orhanea.Repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public  class AirportService implements AirportInterface {

    @Autowired
    private AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }
    @Override
    public AirportData updateAirportByAirportID(int airportID, AirportData city) {
        AirportData existingAirport = airportRepository.findById(airportID).orElse(null);
        if (existingAirport != null) {
            // Update fields
            existingAirport.setCity(city.getCity());
            // Save and return the updated airport
            return airportRepository.save(existingAirport);

        }
        return null;
    }

    @Override
    public AirportData getAirportByAirportID(int airportID) {
        return airportRepository.findByAirportID(airportID).orElseThrow(() -> new AirportNotFound("Airport not found with given airport code: " + airportID));
    }

    @Override
    public List<AirportData> getAirportByCity(String city) {
        return airportRepository.findAllByCity(city);
    }

    @Override
    public AirportData createAirport(AirportData airport) {
        return airportRepository.save(airport);
    }

    @Override
    public List<AirportData> getAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public void deleteAirportByAirportID(int airportID) {
        airportRepository.deleteById(airportID);
    }
}