package com.orhanea.Services;

import com.orhanea.Entities.FlightData;
import com.orhanea.Exception.FlightNotFound;
import com.orhanea.Repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class FlightService implements FlightInterface {

    // Access the data
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    // Search for one-way flights
    public List<FlightData> searchOneWayFlights(String departureAirport, String arrivalAirport, LocalDateTime departureDatetime) {
        return flightRepository.DepartureAirportAndArrivalAirportAndDepartureDatetime(
                departureAirport, arrivalAirport, departureDatetime);
    }

    // Search for round-trip flights
    public List<FlightData> searchRoundTripFlights(String departureAirport, String arrivalAirport, LocalDateTime departureDatetime, LocalDateTime returnDatetime) {
        return flightRepository.DepartureAirportAndArrivalAirportAndDepartureDatetimeAndReturnDatetime(
                departureAirport, arrivalAirport, departureDatetime, returnDatetime);
    }

    // Get all flights
    @Override
    public List<FlightData> getAllFlights() {
        return flightRepository.findAll();
    }

    // Create flights
    @Override
    public FlightData createFlight(FlightData flightdata) {
        return flightRepository.save(flightdata);
    }

    // Search all flights
    @Override
    public List<FlightData> searchFlights(String departureAirport, String arrivalAirport, LocalDateTime departureDateTime, LocalDateTime returnDateTime) {
        if (returnDateTime == null) {
            return searchOneWayFlights(departureAirport,
                    arrivalAirport,
                    departureDateTime);
        } else {
            return searchRoundTripFlights(departureAirport,
                    arrivalAirport,
                    departureDateTime,
                    returnDateTime);

        }
    }

    // Update flight by ID
    @Override
    public FlightData updateFlightByID(int flightID, FlightData updatedFlight) {
        FlightData existingFlight = flightRepository.findById(flightID).orElse(null);
        if (existingFlight != null) {
            // Update fields
            existingFlight.setDepartureAirport(updatedFlight.getDepartureAirport());
            existingFlight.setArrivalAirport(updatedFlight.getArrivalAirport());
            existingFlight.setDepartureDatetime(updatedFlight.getDepartureDatetime());
            existingFlight.setReturnDatetime(updatedFlight.getReturnDatetime());
            existingFlight.setPrice(updatedFlight.getPrice());
            // Save and return the updated flight
            return flightRepository.save(existingFlight);
        }
        return null;
    }

    // Get a specific flight
    @Override
    public FlightData getFlightByID(int flightID) {
        return flightRepository.findById(flightID)
                .orElseThrow(() -> new FlightNotFound("Flight not found with given id: " + flightID));
    }

    // Delete a specific flight
    @Override
    public void deleteFlightByID(int flightID) {
        FlightData flight = getFlightByID(flightID);
        flightRepository.deleteById(flight.getFlightID());
    }

}
