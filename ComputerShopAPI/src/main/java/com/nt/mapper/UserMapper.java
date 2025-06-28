package com.nt.mapper;

import org.springframework.stereotype.Component;

import com.nt.dto.ProductReqDto;
import com.nt.dto.UserLoginReqDTO;
import com.nt.dto.UserReqDTO;
import com.nt.entity.User;
import com.nt.entity.Product;

@Component
public class UserMapper {

	public User toEntity(UserReqDTO dto) {
		return new User(0, dto.getUsername(), dto.getEmailaddress(), dto.getPassword(), dto.getRole());

	}

	public User toEntityLogin(UserLoginReqDTO reqDto) {

		return new User(reqDto.getUsername(), reqDto.getPassword());
	}

	
	
	

}
