package com.nt.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Product;
import com.nt.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

	User findByUsername(String username);

	
	
	

	
}
