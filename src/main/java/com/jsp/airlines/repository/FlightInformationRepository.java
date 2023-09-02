package com.jsp.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airlines.entity.FlightInformation;

public interface FlightInformationRepository extends JpaRepository<FlightInformation, Integer>{

}
