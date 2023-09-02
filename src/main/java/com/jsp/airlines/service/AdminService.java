package com.jsp.airlines.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.jsp.airlines.dto.AirlineInformationDto;
import com.jsp.airlines.dto.BookingInformationDto;
import com.jsp.airlines.dto.CheckInDto;
import com.jsp.airlines.dto.FarTableDto;
import com.jsp.airlines.dto.FlightDto;
import com.jsp.airlines.dto.FlightInformationDto;
import com.jsp.airlines.dto.InventoryDto;
import com.jsp.airlines.dto.PassengerDto;
import com.jsp.airlines.dto.UserDto;

public interface AdminService {

	int addUser(UserDto dto);
	
	int addBookingInformationDetails(BookingInformationDto dto1);
	
	int addSeatAndGateNo(CheckInDto dto2);
	
	int addFar(FarTableDto dto3);
	
	int setFlightInformation(FlightInformationDto dto4,int ids);
	
	AirlineInformationDto findAirlineById(int airlineId);
	
	int addAirLineInformation(AirlineInformationDto dto5);
	
	BookingInformationDto findBookings(int bookingId);
	
	List<BookingInformationDto> getAllBooking();
	
	int addInventoryDetails(InventoryDto dto6);
	
	int addPassengerDetails(PassengerDto dto7,int idBk,int idCk);
	
	int toaddTheFlights(FlightDto dto8,int idFare,int idFI,int idIn);
	
	//AirlineInformationDto todeleteTheAirlinesById(int idA);
	
	List<UserDto> loginUserByUsingMobileAndPassword(String mobileNo,String password);
	
	//find the Flight by using SLocation, Destination,FlightDate,FlightTime
	
	List<FlightDto> findTheFlightByUsingSLocDesDateTime
	(String currentLocation,String destination,LocalDate flightDate,LocalTime flightTime);
	
	//List<FlightDto> getAllFlights();
	
	
	
	
	
	
	
	
	
}
