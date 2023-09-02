package com.jsp.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airlines.entity.CheckIn;

public interface CheckInRepository extends JpaRepository<CheckIn, Integer>{

}
