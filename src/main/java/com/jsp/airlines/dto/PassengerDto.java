package com.jsp.airlines.dto;

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
public class PassengerDto {

	private String emailId;
	private String firstname;
	private String gender;
	private String lastName;
	private String mobileNo;
}
