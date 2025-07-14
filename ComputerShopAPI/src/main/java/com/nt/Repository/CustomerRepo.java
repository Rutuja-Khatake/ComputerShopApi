package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.dto.CustomerRespDto;
import com.nt.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	Customer save(Customer customer);

}
