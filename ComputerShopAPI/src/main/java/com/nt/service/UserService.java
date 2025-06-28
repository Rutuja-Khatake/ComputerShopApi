package com.nt.service;



import com.nt.dto.UserLoginReqDTO;
import com.nt.dto.UserReqDTO;


public interface UserService {

	String SignUpForm(UserReqDTO dto);

	String loginPage(UserLoginReqDTO reqDto);

	
}
