package com.nt.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReqDTO {

	private String username;
	private String emailaddress;
	private String password;
	private String role;

}
