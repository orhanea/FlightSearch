package com.orhanea.Repository;

import com.orhanea.Entities.FlightData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<FlightData, Integer> {

    List<FlightData> DepartureAirportAndArrivalAirportAndDepartureDatetime(
            String departureAirport, String arrivalAirport, LocalDateTime departureDatetime);

    List<FlightData> DepartureAirportAndArrivalAirportAndDepartureDatetimeAndReturnDatetime(
            String departureAirport, String arrivalAirport, LocalDateTime departureDatetime, LocalDateTime returnDatetime);
}
