package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.ProductReqDto;
import com.nt.dto.VendorReqDto;
import com.nt.dto.VendorRespDto;
import com.nt.service.VendorService;

@RestController
@RequestMapping("/vendorApi")
public class VendorController {
	@Autowired
	VendorService vendorService;

	@PostMapping("/addVendors")
	public String addVendorPage(@RequestBody VendorReqDto dto) {
		String added=vendorService.addVendorPage(dto);
		return added;
	}
	
//	@GetMapping("/getAllvendors")
//	public List<VendorRespDto> getAllVendors() {
//		return vendorService.getAll();
//	}
	@GetMapping("/getAllvendors")
	public ResponseEntity<List<VendorRespDto>> getAllVendors() {
	    try {
	        List<VendorRespDto> list = vendorService.getAll();
	        return ResponseEntity.ok(list);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.internalServerError().build();
	    }
	}

	
	

	@GetMapping("/fetchData/{id}")
	public ResponseEntity<?> fetchDataPage(@PathVariable int id) {
		VendorRespDto vendorRespDto = vendorService.fetchData(id);
	    if (vendorRespDto == null) {
	        return ResponseEntity.status(404).body("Product with ID " + id + " not found.");
	    }
	    return ResponseEntity.ok(vendorRespDto);
	}
	
	@PostMapping("/updateVendor")
	public String updateProduct(@RequestBody VendorReqDto reqDto) {

		String isUpdate = vendorService.updateVendorData(reqDto);
		return isUpdate;
	}
}
