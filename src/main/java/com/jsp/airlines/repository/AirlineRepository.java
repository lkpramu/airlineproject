package com.jsp.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airlines.entity.AirlineInformation;

public interface AirlineRepository extends JpaRepository<AirlineInformation, Integer>{

}
