package com.orhanea.ResponseAndRequests;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FlightRequest(LocalDateTime departureDateTime,
                            LocalDateTime arrivalDateTime,
                            Double price,
                            String departureAirportCode,
                            String arrivalAirportCode) {
}
