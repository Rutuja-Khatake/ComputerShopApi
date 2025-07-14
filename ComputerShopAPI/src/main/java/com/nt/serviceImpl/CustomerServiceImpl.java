package com.nt.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.CustomerRepo;
import com.nt.dto.CustomerReqDto;
import com.nt.dto.CustomerRespDto;
import com.nt.dto.ProductRespDto;
import com.nt.entity.Customer;
import com.nt.entity.Product;
import com.nt.entity.Vendor;
import com.nt.mapper.CustomerMapper;
import com.nt.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	CustomerMapper customerMapper;

	@Override
	public CustomerRespDto addCustomer(CustomerReqDto dto) {
		Customer customer=customerMapper.toEntity(dto);
		Customer addedCustomer=	customerRepo.save(customer);
		return  customerMapper.toDto(addedCustomer);
	}

	@Override
	public List getAll() {
		List<Customer> list = customerRepo.findAll();

		return customerMapper.toDto(list);
	}

	@Override
	public CustomerRespDto fetchCustomer(int id) {
		Optional<Customer> optionalProduct = customerRepo.findById(id);

		if (optionalProduct.isPresent()) {
			Customer customer = optionalProduct.get();
			CustomerRespDto dto = customerMapper.toDto2(customer);
			return dto;
		}

		return null;
	}

	@Override
	public String updateCustomers(CustomerReqDto reqDto) {
		Customer customer = customerMapper.toEntity(reqDto);
		Customer customerUpdate = customerRepo.save(customer);

		return null;
	}

}
