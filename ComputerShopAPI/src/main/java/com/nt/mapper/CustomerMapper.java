package com.nt.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nt.dto.CustomerReqDto;
import com.nt.dto.CustomerRespDto;
import com.nt.dto.VendorRespDto;
import com.nt.entity.Customer;
import com.nt.entity.Vendor;

@Component
public class CustomerMapper {

	public Customer toEntity(CustomerReqDto dto) {
		// TODO Auto-generated method stub
		return new Customer(dto.getId(),dto.getCustomerName(),dto.getMobileNumber(),dto.getAddress());
	}

	public CustomerRespDto toDto(Customer addedCustomer) {
		// TODO Auto-generated method stub
		return new CustomerRespDto(addedCustomer.getId(),addedCustomer.getCustomerName(),addedCustomer.getMobileNumber(),addedCustomer.getAddress());
	}

	public List toDto(List<Customer> list) {
		List<CustomerRespDto> dtoList = new ArrayList<>();

		for (Customer customer : list) {
			CustomerRespDto dto = new CustomerRespDto();
			dto.setId(customer.getId());
			dto.setCustomerName(customer.getCustomerName());
			dto.setMobileNumber(customer.getMobileNumber());
			dto.setAddress(customer.getAddress());
			
			dtoList.add(dto);
		}

		return dtoList;
	}

	public CustomerRespDto toDto2(Customer customer) {
		// TODO Auto-generated method stub
		return new CustomerRespDto(customer.getId(),customer.getCustomerName(),customer.getMobileNumber(),customer.getAddress());
	}

	
}
