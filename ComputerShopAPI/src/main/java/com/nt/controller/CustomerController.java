package com.nt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.CustomerReqDto;
import com.nt.dto.CustomerRespDto;
import com.nt.dto.ProductRespDto;
import com.nt.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;


	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerReqDto dto, BindingResult result) {
	    if (result.hasErrors()) {
	        return ResponseEntity.badRequest().body(result.getAllErrors());
	    }
	    CustomerRespDto resp = customerService.addCustomer(dto);
	    return ResponseEntity.ok(resp);
	}
	
	@GetMapping("/getAllList")
	public List getAll() {
		return customerService.getAll();
	}
	


	@GetMapping("/fetchCustomerData/{id}")
	public ResponseEntity<?> fetchCustomer(@PathVariable int id) {
	    CustomerRespDto customerRespDto = customerService.fetchCustomer(id);
	    if (customerRespDto == null) {
	        return ResponseEntity.status(404).body("Customer with ID " + id + " not found.");
	    }
	    return ResponseEntity.ok(customerRespDto);
	}
	
	@PostMapping("/updateCustomer")
	public String updateCustomer(@RequestBody CustomerReqDto reqDto) {

		String isUpdate = customerService.updateCustomers(reqDto);
		return isUpdate;
	}

}
