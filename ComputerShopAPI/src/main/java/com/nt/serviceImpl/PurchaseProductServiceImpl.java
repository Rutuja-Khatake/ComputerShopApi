package com.nt.serviceImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.Repository.ProductRepo;
import com.nt.Repository.PurchaseProductRepo;
import com.nt.dto.PurchaseReqDto;
import com.nt.dto.PurchaseRespDto;
import com.nt.entity.PurchaseProduct;
import com.nt.mapper.PurchaseMapper;
import com.nt.service.PurchaseProductService;


@Service
public class PurchaseProductServiceImpl implements PurchaseProductService {
	@Autowired
	PurchaseProductRepo purchaseProductRepo;
	
	@Autowired
	PurchaseMapper purchaseMapper;

	@Autowired
	ProductRepo productRepo;
	
	@Transactional
	@Override
	public PurchaseRespDto updatePurchasePage(PurchaseReqDto purchaseReqDto) {
		
		PurchaseProduct product = purchaseMapper.toEntity(purchaseReqDto);
		product.setTotal(purchaseReqDto.getRate().multiply(BigDecimal.valueOf(purchaseReqDto.getQuantity())));
		
		PurchaseProduct productUpdate = purchaseProductRepo.save(product);
		
		System.out.println("Incoming request: " + purchaseReqDto);
		System.out.println("Mapped entity: " + product);
		System.out.println("Saved entity: " + productUpdate);

		
		productRepo.findById(purchaseReqDto.getProductId()).ifPresent(prod -> {
            prod.setStock(prod.getStock() + purchaseReqDto.getQuantity());
            productRepo.save(prod);
        });

		return purchaseMapper.toDto(productUpdate);
	}

}
