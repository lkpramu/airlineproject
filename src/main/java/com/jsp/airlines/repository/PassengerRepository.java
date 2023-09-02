package com.jsp.airlines.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airlines.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

	//Optional<Passenger> findById(int idBk, int idCk);

}
