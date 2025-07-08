package com.nt.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.PurchaseReqDto;
import com.nt.dto.PurchaseRespDto;
import com.nt.service.PurchaseProductService;

@RestController
@RequestMapping("/api")
public class PurchaseController {
	@Autowired
	PurchaseProductService purchaseProductService;

//	@PostMapping("/updatePurchase")
//	public void	 updatePurchase(@RequestBody PurchaseReqDto purchaseReqDto) {
////	PurchaseRespDto respdto=purchaseProductService.updatePurchasePage(purchaseReqDto);
//	System.out.println("Returning response: " + purchaseReqDto);
////		return respdto;
//	}
	
	
	
//	 @PostMapping("/addPurchase")	
//		public PurchaseRespDto updatePurchase(@RequestBody PurchaseReqDto purchaseReqDto) {
//	       
//	            PurchaseRespDto respDto = purchaseProductService.updatePurchasePage(purchaseReqDto);
//	            System.out.println(respDto);
//	            return respDto;
//	            
//	 }
	
	@PostMapping("/addPurchase")	
    public ResponseEntity<PurchaseRespDto> updatePurchase(@RequestBody PurchaseReqDto purchaseReqDto) {
       
            PurchaseRespDto respDto = purchaseProductService.updatePurchasePage(purchaseReqDto);
            System.out.println(respDto);
            return ResponseEntity.ok(respDto);
            
 }
	
  
	
}
