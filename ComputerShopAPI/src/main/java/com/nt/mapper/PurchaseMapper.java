package com.nt.mapper;



import org.springframework.stereotype.Component;


import com.nt.dto.PurchaseReqDto;
import com.nt.dto.PurchaseRespDto;

import com.nt.entity.PurchaseProduct;

@Component
public class PurchaseMapper {

	public PurchaseProduct toEntity(PurchaseReqDto dto) {
		return new PurchaseProduct(dto.getPurchaseId(), dto.getVendorName(), dto.getProductName(), dto.getProductId(),
				dto.getQuantity(), dto.getRate(), dto.getTotal(), dto.getPurchaseDate());

	}

	public PurchaseRespDto toDto(PurchaseProduct productUpdate) {
		
		return new PurchaseRespDto(productUpdate.getPurchaseId(), productUpdate.getVendor_name(), productUpdate.getProductName(), productUpdate.getProductId(),
				productUpdate.getQuantity(), productUpdate.getRate(), productUpdate.getTotal(), productUpdate.getPurchaseDate());
	
	}
}
