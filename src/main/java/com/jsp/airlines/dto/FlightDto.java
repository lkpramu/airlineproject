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
public class FlightDto {

	private String destination;
    private LocalDate flightDate;
    
    private String flightNum;
    private LocalTime flightTime;
    private String currentLocation;
}
