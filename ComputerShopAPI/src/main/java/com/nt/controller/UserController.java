package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.UserLoginReqDTO;
import com.nt.dto.UserReqDTO;
import com.nt.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userservice;
	
	@PostMapping("/addUserSignUp")
	public ResponseEntity<String> signUpPage(@RequestBody UserReqDTO dto) {
	    if (dto == null) {
	        return ResponseEntity.badRequest().body("false");
	    }

	   String isAdded = userservice.SignUpForm(dto);
	    return ResponseEntity.ok("is added");
	}


	
	@PostMapping("/username")
	public String LoginPage(@RequestBody UserLoginReqDTO reqDto) {
		
		String role=userservice.loginPage(reqDto);
		
		return role;
	}
}
