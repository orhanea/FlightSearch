package com.orhanea.Repository;

import com.orhanea.Entities.AirportData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AirportRepository extends JpaRepository<AirportData, Integer> {
    Optional<AirportData> findByAirportID(int airportID);

    List<AirportData> findAllByCity(String city);

}