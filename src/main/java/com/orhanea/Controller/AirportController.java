package com.orhanea.Controller;

import com.orhanea.Entities.AirportData;
import com.orhanea.Services.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/airport")
@RestController
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAirport(){
        return ResponseEntity.ok(airportService.getAllAirports());
    }

    @PostMapping
    public ResponseEntity<?> addAirport(@RequestBody AirportData airport){
        return ResponseEntity.ok(airportService.createAirport(airport));
    }

    @PutMapping
    public ResponseEntity<?> updateAirportByAirportCode(@RequestParam int airportID,@RequestBody AirportData airport){
        return ResponseEntity.ok(airportService.updateAirportByAirportID(airportID,airport));
    }

}