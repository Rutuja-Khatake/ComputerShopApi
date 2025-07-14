package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.dto.CustomerReqDto;
import com.nt.dto.CustomerRespDto;
import com.nt.entity.Customer;

@Service
public interface CustomerService {

	CustomerRespDto addCustomer(CustomerReqDto dto);

	List getAll();

	CustomerRespDto fetchCustomer(int id);

	String updateCustomers(CustomerReqDto reqDto);

}
