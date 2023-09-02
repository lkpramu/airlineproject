package com.jsp.airlines.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "flight_table")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int flightId;
	private String destination;
    private LocalDate flightDate;
    
    private String flightNum;
    private LocalTime flightTime;
    private String currentLocation;
    
    //To create Fk In Flight Table
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(name = "far_id") 
    private FarTable fartable;
    
    //To create Fk
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_infoId_fk")
    private FlightInformation flightInformation;
    
    //To create FK
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "Inventory_id_fk")
    private Inventory inventory;
    
   
    
}
