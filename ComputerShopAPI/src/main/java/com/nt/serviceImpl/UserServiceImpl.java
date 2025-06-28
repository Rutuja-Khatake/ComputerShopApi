package com.nt.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.nt.Repository.UserRepo;
import com.nt.dto.UserLoginReqDTO;
import com.nt.dto.UserReqDTO;
import com.nt.entity.User;
import com.nt.mapper.UserMapper;
import com.nt.service.UserService;

@Service

public class UserServiceImpl implements UserService {
	@Autowired

	UserRepo userrepo;

	@Autowired
	UserMapper usermapper;

	@Override
	public String SignUpForm(UserReqDTO dto) {
		User user = usermapper.toEntity(dto);
		User userAdded = userrepo.save(user);

		if (userAdded != null) {
			System.out.println(userAdded.getUsername());
			return "login";
		}

		return "sign_up";

	}

	@Override
	public String loginPage(UserLoginReqDTO reqDto) {
		User user = userrepo.findByUsername(reqDto.getUsername());
//		User user = usermapper.toEntityLogin(reqDto);

		if (user != null) {
			if (reqDto.getUsername().equals(user.getUsername()) && reqDto.getPassword().equals(user.getPassword())) {
				return user.getRole();
			}
		}
		return null;
	}

}
