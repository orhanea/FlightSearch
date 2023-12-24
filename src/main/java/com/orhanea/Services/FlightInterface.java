package com.orhanea.Services;

import com.orhanea.Entities.FlightData;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightInterface {

    List<FlightData> getAllFlights();

    FlightData createFlight(FlightData flightdata);

    List<FlightData> searchFlights(String departureAirport,
                                       String arrivalAirport,
                                       LocalDateTime departureDateTime,
                                       LocalDateTime returnDateTime);
    FlightData updateFlightByID(int flightID, FlightData updatedFlight);

    FlightData getFlightByID(int flightID);

    void deleteFlightByID(int flightID);

}
