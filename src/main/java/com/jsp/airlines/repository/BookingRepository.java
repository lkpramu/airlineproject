package com.jsp.airlines.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.airlines.entity.BookingInformation;

public interface BookingRepository extends JpaRepository<BookingInformation, Integer>{

}
