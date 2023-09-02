package com.jsp.airlines.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class BookingInformationDto {

	private LocalDate bookingDate;
	private String destination;
	private double fare;
	private LocalDate flyingDate;
	private String flightNumber;
	private String status;
	private LocalTime flightTime;
	private String currentCity;
}
