package com.jsp.airlines.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.airlines.dto.AirlineInformationDto;
import com.jsp.airlines.dto.BookingInformationDto;
import com.jsp.airlines.dto.CheckInDto;
import com.jsp.airlines.dto.FarTableDto;
import com.jsp.airlines.dto.FlightDto;
import com.jsp.airlines.dto.FlightInformationDto;
import com.jsp.airlines.dto.InventoryDto;
import com.jsp.airlines.dto.PassengerDto;
import com.jsp.airlines.dto.UserDto;
import com.jsp.airlines.entity.AirlineInformation;
import com.jsp.airlines.entity.BookingInformation;
import com.jsp.airlines.entity.CheckIn;
import com.jsp.airlines.entity.FarTable;
import com.jsp.airlines.entity.Flight;
import com.jsp.airlines.entity.FlightInformation;
import com.jsp.airlines.entity.Inventory;
import com.jsp.airlines.entity.Passenger;
import com.jsp.airlines.entity.User;
import com.jsp.airlines.repository.AirlineRepository;
import com.jsp.airlines.repository.BookingRepository;
import com.jsp.airlines.repository.CheckInRepository;
import com.jsp.airlines.repository.FarRepository;
import com.jsp.airlines.repository.FlightInformationRepository;
import com.jsp.airlines.repository.FlightRepository;
import com.jsp.airlines.repository.InventoryRepository;
import com.jsp.airlines.repository.PassengerRepository;
import com.jsp.airlines.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private CheckInRepository checkInRepository;

	@Autowired
	private FarRepository farRepository;

	@Autowired
	private FlightInformationRepository flightInformationRepository;

	@Autowired
	private AirlineRepository airlineRepository;

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private FlightRepository flightRepository;

	// To Register The User Information
	@Override
	public int addUser(UserDto dto) {
		User u1 = userRepository.save(
				User.builder().firstName(dto.getFirstName()).lastName(dto.getFirstName()).mobileNo(dto.getMobileNo())
						.gender(dto.getGender()).userName(dto.getUserName()).password(dto.getPassword()).build());
		return u1.getUserId();
	}

	@Override
	public int addBookingInformationDetails(BookingInformationDto dto1) {
		BookingInformation b1 = bookingRepository.save(BookingInformation.builder().bookingDate(dto1.getBookingDate())
				.destination(dto1.getDestination()).fare(dto1.getFare()).flyingDate(dto1.getFlyingDate())
				.flightNumber(dto1.getFlightNumber()).status(dto1.getStatus()).flightTime(dto1.getFlightTime())
				.currentCity(dto1.getCurrentCity()).build());
		return b1.getBookingId();
	}

	@Override
	public int addSeatAndGateNo(CheckInDto dto2) {
		CheckIn c1 = checkInRepository
				.save(CheckIn.builder().seatNum(dto2.getSeatNum()).gateNum(dto2.getGateNum()).build());
		return c1.getCheckinId();
	}

	@Override
	public int addFar(FarTableDto dto3) {
		FarTable f1 = farRepository
				.save(FarTable.builder().currency(dto3.getCurrency()).amount(dto3.getAmount()).build());
		return f1.getFarId();
	}

	@Override
	public int setFlightInformation(FlightInformationDto dto4, int id) {
		// add The airLine Fk From Db
		Optional<AirlineInformation> optional = airlineRepository.findById(id);
		if (optional.isPresent()) {

			// to add data
			FlightInformation infor = flightInformationRepository
					.save(FlightInformation.builder().flightNum(dto4.getFlightNum()).flightTime(dto4.getFlightTime())
							.flightType(dto4.getFlightType()).airlineInformation(optional.get()).build());
			return infor.getFlightInfoId();
		} else {
			return 0;
		}
	}

	// Fetch AitlineInfo By AirlineId
	@Override
	public AirlineInformationDto findAirlineById(int airlineId) {
		Optional<AirlineInformation> airline = airlineRepository.findById(airlineId);

		if (airline.isPresent()) {
			AirlineInformation a2 = airline.get();

			AirlineInformationDto aDto = AirlineInformationDto.builder().airlineName(a2.getAirlineName()).build();
			return aDto;

		} else {
			return null;
		}

	}

//To set The AirlineInfo In Database
	@Override
	public int addAirLineInformation(AirlineInformationDto dto5) {
		AirlineInformation airlineInformation = airlineRepository
				.save(AirlineInformation.builder().airlineName(dto5.getAirlineName()).build());

		return airlineInformation.getAirlineId();
	}

	// To get Booking Details bY using Id
	@Override
	public BookingInformationDto findBookings(int bookingId) {
		Optional<BookingInformation> dtoBook = bookingRepository.findById(bookingId);

		if (dtoBook.isPresent()) {

			BookingInformation b2 = dtoBook.get();

			BookingInformationDto dtos = BookingInformationDto.builder()

					.bookingDate(b2.getBookingDate()).destination(b2.getDestination()).fare(b2.getFare())

					.flyingDate(b2.getFlyingDate()).flightNumber(b2.getFlightNumber()).status(b2.getStatus())

					.flightTime(b2.getFlightTime()).currentCity(b2.getCurrentCity()).build();

			return dtos;
		} else {
			return null;
		}

	}

//To get All Booking Details.............
	@Override
	public List<BookingInformationDto> getAllBooking() {
		List<BookingInformation> bookings = bookingRepository.findAll();

		if (bookings.size() > 0) {
			List<BookingInformationDto> dtoss = bookings.stream()
					.map(t -> BookingInformationDto.builder().bookingDate(t.getBookingDate())
							.destination(t.getDestination()).fare(t.getFare()).flyingDate(t.getFlyingDate())
							.flightNumber(t.getFlightNumber()).status(t.getStatus()).flightTime(t.getFlightTime())
							.currentCity(t.getCurrentCity()).build())
					.collect(Collectors.toList());

			return dtoss;
		} else {
			return null;

		}

	}

	// To Create The Inventory Table Data

	@Override
	public int addInventoryDetails(InventoryDto dto6) {
		Inventory inventory = inventoryRepository.save(Inventory.builder().count(dto6.getCount()).build());
		return inventory.getInventoryId();
	}

//To add The Foreign Keys Of The Tables BookingId And CheckingId

	@Override
	public int addPassengerDetails(PassengerDto dto7, int idBk, int idCk) {
		Optional<BookingInformation> bookInfo = bookingRepository.findById(idBk);
		Optional<CheckIn> checkInfo = checkInRepository.findById(idCk);

		if (bookInfo.isPresent() && checkInfo.isPresent()) {

			Passenger passenger = passengerRepository.save(Passenger.builder().emailId(dto7.getEmailId())
					.firstname(dto7.getFirstname()).gender(dto7.getGender()).lastName(dto7.getLastName())
					.mobileNo(dto7.getMobileNo()).bookinginfo(bookInfo.get()).checking(checkInfo.get()).build());
			return passenger.getPassengerId();
		} else {
			return 0;
		}

	}

	@Override
	public int toaddTheFlights(FlightDto dto8, int idFare, int idFI, int idIn) {
		Optional<FarTable> optional5 = farRepository.findById(idFare);
		Optional<FlightInformation> optional6 = flightInformationRepository.findById(idFI);
		Optional<Inventory> optional7 = inventoryRepository.findById(idIn);

		if (optional5.isPresent() && optional6.isPresent() && optional7.isPresent()) {

			Flight flight = flightRepository.save(Flight.builder()

					.destination(dto8.getDestination()).flightDate(dto8.getFlightDate()).flightNum(dto8.getFlightNum())
					.flightTime(dto8.getFlightTime()).currentLocation(dto8.getCurrentLocation())

					.fartable(optional5.get()).flightInformation(optional6.get()).inventory(optional7.get()).build());
			return flight.getFlightId();

		} else {
			return 0;
		}

	}

	/*
	 * @Override public AirlineInformationDto todeleteTheAirlinesById(int idA) {
	 * Optional<AirlineInformation> air=airlineRepository.deleteById(idA); if
	 * (air.isPresent()) { AirlineInformation airid=air.get(); AirlineInformationDto
	 * dtoAir=AirlineInformationDto.builder()
	 * .airlineName(airid.getAirlineName()).build(); return dtoAir; } else { return
	 * null; }
	 * 
	 * }
	 */

	@Override
	public List<UserDto> loginUserByUsingMobileAndPassword(String mobileNo, String password) {
		List<User> user = userRepository.finddByMobileAndPassword(mobileNo, password);
		if (user.isEmpty()) {
			return null;

		} else {
			// To transfer Data From UserTo UserDto
			List<UserDto> userDtO = user.stream()
					.map(t -> UserDto.builder().firstName(t.getFirstName()).lastName(t.getFirstName())
							.mobileNo(t.getMobileNo()).gender(t.getGender()).userName(t.getUserName())
							.password(t.getPassword()).build())
					.collect(Collectors.toList());
			return userDtO;

		}

	}

	// Creating An Api to Search Flights Based On Loc, Dest, FT,FD

	@Override
	public List<FlightDto> findTheFlightByUsingSLocDesDateTime(String currentLocation, String destination,
			LocalDate flightDate, LocalTime flightTime) {

		List<Flight> flights = flightRepository.searchFlightByUsingLocDesFdFt(currentLocation, destination, flightDate,
				flightTime);

		if (flights.isEmpty()) {
			return null;

		} else {

			// To Transfer Data From flight To FlightDto
			List<FlightDto> flight2Dto = flights.stream()
					.map(t -> FlightDto.builder().currentLocation(t.getCurrentLocation())
							.destination(t.getDestination()).flightDate(t.getFlightDate()).flightTime(t.getFlightTime())
							.build())
					.collect(Collectors.toList());

			return flight2Dto;

		}

	}  
	
	
	

}
