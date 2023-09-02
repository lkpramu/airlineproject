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
public class UserDto {

	private String firstName;
	private String lastName;
	private String mobileNo;
	private String gender;
	
	private String userName;
	private String password;
}
