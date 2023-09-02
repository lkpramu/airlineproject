package com.jsp.airlines.Controller;

import java.io.Console;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.airlines.dto.AirlineInformationDto;
import com.jsp.airlines.dto.BookingInformationDto;
import com.jsp.airlines.dto.CheckInDto;
import com.jsp.airlines.dto.FarTableDto;
import com.jsp.airlines.dto.FlightDto;
import com.jsp.airlines.dto.FlightInformationDto;
import com.jsp.airlines.dto.InventoryDto;
import com.jsp.airlines.dto.PassengerDto;
import com.jsp.airlines.dto.UserDto;
import com.jsp.airlines.service.AdminService;

import lombok.var;

@RestController
@RequestMapping("/admincon/v1")
public class AdminController {

	@Autowired
	private AdminService adminService;

	
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody UserDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body("int id is:"+adminService.addUser(dto)) ;
		
		/*System.out.println(dto);
		int id=adminService.addUser(dto);*/
		
	}
	
	@PostMapping("/addBookingInfo")
	public ResponseEntity<String> addBookingInformationDetails(@RequestBody BookingInformationDto dto1){
		
		System.out.println(dto1);
		int id1=adminService.addBookingInformationDetails(dto1);
		return ResponseEntity.status(HttpStatus.CREATED).body("id is:"+id1);
		
	}
	
	
	
	@PostMapping("/addSeatNo")
	public ResponseEntity<String> addSeatAndGateNo(@RequestBody CheckInDto dto2) {
		
		System.out.println(dto2);
		int id2=adminService.addSeatAndGateNo(dto2);
		return ResponseEntity.status(HttpStatus.CREATED).body("id is:"+id2);
	}
	
	
	
	@PostMapping("/addFarDet")
	public ResponseEntity<String> addFar(@RequestBody FarTableDto dto3) {
		
		System.out.println(dto3);
		int id4=adminService.addFar(dto3);
		return ResponseEntity.status(HttpStatus.CREATED).body("id is :"+id4);
		
	}
	
	
	//Creating An ApI To add Flight Information
	@PostMapping("/setFlightInfo/{id}")
	public ResponseEntity<String> setFlightInformation(@RequestBody FlightInformationDto dto4,@PathVariable("id")int id) {
		 
		
	/*	System.out.println(dto4);
		int id5=adminService.setFlightInformation(dto4);
		return ResponseEntity.status(HttpStatus.CREATED).body("id is:"+id5);*/
		return ResponseEntity.status(HttpStatus.CREATED).body("Flight Info Id is:"+adminService.setFlightInformation(dto4, id));

	}
	
	
	@GetMapping("/findAirline/{airlineId}")
	public ResponseEntity<AirlineInformationDto> findAirlineById(@PathVariable("airlineId") int airlineId) {
		if (adminService.findAirlineById(airlineId)!=null) {
			
			return ResponseEntity.status(HttpStatus.FOUND).body(adminService.findAirlineById(airlineId));
			
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
	}
	
	
	
	@PostMapping("/addAirline")
	public ResponseEntity<String> addAirLineInformation(@RequestBody AirlineInformationDto dto5) {
		System.out.println(dto5);
		int id6=adminService.addAirLineInformation(dto5);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("ID IS:"+id6);
		
	}
	
	
	
	@GetMapping("/bookingDetails/{bookingid}")
	public ResponseEntity<BookingInformationDto> findBookings(@PathVariable("bookingid") int bookingId)
	{
		if (adminService.findBookings(bookingId)!=null) {
			return ResponseEntity.status(HttpStatus.FOUND).body(adminService.findBookings(bookingId));
			
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		}
	}
	
	
	
	@GetMapping("allBookings")
	public ResponseEntity<List<BookingInformationDto>> getAllBooking()
	{
		List<BookingInformationDto> result=adminService.getAllBooking();
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
		
		
	}
	
	@PostMapping("/addInventory")
	public ResponseEntity<String> addInventoryDetails(@RequestBody InventoryDto dto6) {
		System.out.println(dto6);
		
		int id6=adminService.addInventoryDetails(dto6);
		return ResponseEntity.status(HttpStatus.CREATED).body("id is:"+id6);
	}
	
	//Creating An Api To add passengerDetails
	@PostMapping("/addPassenger/{idbk}/{idck}")
	public ResponseEntity<String> addPassengerDetails(@RequestBody PassengerDto dto7,@PathVariable("idbk") int idBk,@PathVariable("idck") int idCk) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body("id is:"+adminService.addPassengerDetails(dto7, idBk, idCk));
	}
	
	//@api to add The Flights
	@PostMapping("addFlights/{idfare}/{idfi}/{idIn}")
	public ResponseEntity<String> toaddTheFlights(@RequestBody FlightDto dto8, @PathVariable("idfare") int idFare,@PathVariable("idfi") int idFI,@PathVariable("idIn")int idIn)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body("id is:"+adminService.toaddTheFlights(dto8, idFare, idFI, idIn));
	}
	
/*	//To Delete The Airline Record ById
	@GetMapping("/deleteAir/{idA}")
	public ResponseEntity<AirlineInformationDto> todeteleTheAirlinesById(@PathVariable("idA") int idA)
	{
		if (adminService.todeleteTheAirlinesById(idA)!=null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(adminService.todeleteTheAirlinesById(idA));
			
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

		}
		
	}*/
	
	@GetMapping("findBymobilepassword/{mobile}/{password}")
	public List<UserDto> finddByMobileAndPassword(@PathVariable("mobile")String mobile,@PathVariable("password")String password){
		return adminService.loginUserByUsingMobileAndPassword(mobile, password);
		
	}
	
	@GetMapping("searchFlight/{cl}/{dest}/{ld}/{lt}")
	public ResponseEntity<List<FlightDto>> searchFlightByUsingLocDesFdFt 
	(@PathVariable("cl")String currentLocation,@PathVariable("dest")String destination,@PathVariable("ld")LocalDate flightDate,@PathVariable("lt")LocalTime flightTime){
		
		List<FlightDto> res=adminService.findTheFlightByUsingSLocDesDateTime(currentLocation, destination, flightDate, flightTime);
				
		return ResponseEntity.status(HttpStatus.FOUND).body(res);
 
		
	}
}
