package com.orhanea.Controller;

import com.orhanea.Entities.FlightData;
import com.orhanea.Services.FlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/flight")
@Api(value = "Flight API Documentation")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/search")
    @ApiOperation(value = "Search flights", notes = "Search for flights based on departure, arrival, and dates")
    public ResponseEntity<List<FlightData>> searchFlights(
            @RequestParam String departureAirport,
            @RequestParam String arrivalAirport,
            @RequestParam LocalDateTime departureDate,
            @RequestParam(required = false) LocalDateTime returnDate) {
        if (returnDate != null) {
            return ResponseEntity.ok(flightService.searchFlights(departureAirport, arrivalAirport, departureDate, returnDate));
        }
        // If returnDate is null return an empty list
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/all")
    @ApiOperation(value = "Get all flights", notes = "Get a list of all flights")
    public ResponseEntity<List<FlightData>> getAllFlights(){
        System.out.println("Received request to get all flights.");
        List<FlightData> allFlights = flightService.getAllFlights();
        System.out.println("Number of flights retrieved: " + allFlights.size());
        return new ResponseEntity<>(allFlights,HttpStatus.CREATED);
    }
    @GetMapping("/{flight_ID}")
    @ApiOperation(value = "Get flight by its ID", notes = "Get flight information by its ID")
    public ResponseEntity<FlightData> getFlightId(@PathVariable("flight_ID") int id){
        FlightData flightById = flightService.getFlightByID(id);
        return new ResponseEntity<>(flightById,HttpStatus.CREATED);
    }

    @DeleteMapping("/{flight_ID}")
    @ApiOperation(value = "Delete flight by its ID", notes = "Delete a flight by its ID")
    public ResponseEntity<Void> deleteFlightById(@PathVariable("flight_ID") int id){
        flightService.deleteFlightByID(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
