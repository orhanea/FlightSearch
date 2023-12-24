package com.orhanea.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FlightDataSyncJob {
    private final FlightDataService flightDataService;

    @Autowired
    public FlightDataSyncJob(FlightDataService flightDataService) {
        this.flightDataService = flightDataService;
    }

    @Scheduled(cron = "0 0 0 * * ?") // Her gün saat 00:00'da çalışacak
    public void syncFlightData() {
        // Mock API isteği yapılıp uçuş bilgileri alınıp veritabanına kaydetmek istedim
        FlightData mockFlightData = MockApiService.getFlightData();
        flightDataService.saveFlightData(mockFlightData);
        System.out.println("Flight data synchronized at " + System.currentTimeMillis());
    }
}
