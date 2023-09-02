package com.jsp.airlines.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "passenger_table")
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int passengerId;
	private String emailId;
	private String firstname;
	private String gender;
	private String lastName;
	private String mobileNo;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "booking_Id")
	private  BookingInformation bookinginfo;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER) 
	@JoinColumn(name = "checkin_Id")
	private CheckIn checking;
}
