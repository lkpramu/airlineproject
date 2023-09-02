package com.jsp.airlines.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.airlines.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Query("SELECT r1 FROM Flight r1 WHERE r1.currentLocation=:currentLocation AND r1.destination=:destination AND r1.flightDate=:flightDate AND r1.flightTime=:flightTime")
	List<Flight> searchFlightByUsingLocDesFdFt 
	(@Param("currentLocation") String currentLocation,@Param("destination") String destination,@Param("flightDate") LocalDate flightDate,@Param("flightTime") LocalTime flightTime);
	
}
