package com.orhanea.ResponseAndRequests;

import com.orhanea.Entities.FlightData;

import java.util.List;

public record FlightResponse(List<FlightData> departureFlights, List<FlightData> returnFlights) {
}