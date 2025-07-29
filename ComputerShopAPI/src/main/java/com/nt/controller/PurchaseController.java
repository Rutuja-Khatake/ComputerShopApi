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
import com.nt.dto.ProductRespDto;
import com.nt.dto.PurchaseReqDto;
import com.nt.dto.PurchaseRespDto;
import com.nt.service.PurchaseProductService;

	
@RestController
@RequestMapping("/parchecs")
public class PurchaseController {
	@Autowired
	PurchaseProductService purchaseProductService;

	@PostMapping("/addPurchase")
	public ResponseEntity<?> addPurchasePage(@RequestBody PurchaseReqDto purchaseReqDto) {
	    try {
	        System.out.println("Product ID received: " + purchaseReqDto.getProductId());
	        PurchaseRespDto respDto = purchaseProductService.addPurchasePage(purchaseReqDto);
	        System.out.println(respDto);
	        return ResponseEntity.ok(respDto);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(500).body("Error processing purchase: " + e.getMessage());
	    }
	}
	
	
	@GetMapping("/showAllPurchaseList")
	public List<PurchaseRespDto> showAllProduct() {
	    return purchaseProductService.showAllProduct();
	}
	
	@GetMapping("/fetchDataApi/{purchaseId}")
	public ResponseEntity<?> fetchData(@PathVariable int purchaseId) {
		 PurchaseRespDto purchaseRespDto = purchaseProductService.fetchpurchase(purchaseId);
		    if (purchaseRespDto == null) {
		        return ResponseEntity.status(404).body("Product with ID " + purchaseId + " not found.");
		    }
		    return ResponseEntity.ok(purchaseRespDto);
	}
	
	
//	@PostMapping("/updatePurchase")
//	public ResponseEntity<String> updateForm(@RequestBody PurchaseReqDto reqDto) {
//	    PurchaseRespDto isUpdated = purchaseProductService.updatePurchase(reqDto);
//      System.out.println("i am dooeing some work ");
//	  return  ResponseEntity.ok("API is working");
//	}
	
	@PostMapping("/updatePurchase")
	public ResponseEntity<?> updateForm(@RequestBody PurchaseReqDto reqDto) {
	    try {
	        System.out.println("Received request: " + reqDto);
	        PurchaseRespDto respDto = purchaseProductService.updatePurchase(reqDto);
	        
	        if (respDto == null) {
	            return ResponseEntity.status(500).body("Update failed: service returned null");
	        }

	        return ResponseEntity.ok("Update successful");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
	    }
	}

	
//	
//	@PostMapping("/updatePurchase")
//	public ResponseEntity<?> updateForm(@RequestBody PurchaseReqDto reqDto) {
//	    if (reqDto.getVendorId() == 0) {
//	        throw new IllegalArgumentException("Vendor ID must not be 0");
//	    }
//	    purchaseProductService.updatePurchase(reqDto);
//	    return ResponseEntity.ok("Update successful");
//	}




}
