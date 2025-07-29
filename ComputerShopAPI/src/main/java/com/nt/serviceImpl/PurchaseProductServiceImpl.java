package com.nt.serviceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.nt.Repository.ProductRepo;
import com.nt.Repository.PurchaseRepo;
import com.nt.Repository.VendorRepo;
import com.nt.dto.ProductRespDto;
import com.nt.dto.PurchaseReqDto;
import com.nt.dto.PurchaseRespDto;
import com.nt.entity.Product;
import com.nt.entity.Purchase;
import com.nt.entity.Vendor;
import com.nt.mapper.PurchaseMapper;
import com.nt.service.PurchaseProductService;

@Service
public class PurchaseProductServiceImpl implements PurchaseProductService {
	@Autowired
	PurchaseRepo purchaseProductRepo;

	@Autowired
	PurchaseMapper purchaseMapper;

	@Autowired
	ProductRepo productRepo;

	@Autowired
	VendorRepo vendorRepo;

	@Transactional
	@Override
	public PurchaseRespDto addPurchasePage(PurchaseReqDto purchaseReqDto) {

		// Fetch vendor and product
		Vendor vendor = vendorRepo.findById(purchaseReqDto.getVendorId())
				.orElseThrow(() -> new RuntimeException("Vendor not found with ID: " + purchaseReqDto.getVendorId()));

		Product product = productRepo.findById(purchaseReqDto.getProductId())
				.orElseThrow(() -> new RuntimeException("Product not found with ID: " + purchaseReqDto.getProductId()));

		// Calculate total
		BigDecimal total = purchaseReqDto.getRate().multiply(BigDecimal.valueOf(purchaseReqDto.getQuantity()));
		purchaseReqDto.setTotal(total);

		// Map to entity
		Purchase purchase = purchaseMapper.toEntity(purchaseReqDto, vendor, product);

		// Save purchase
		Purchase savedPurchase = purchaseProductRepo.save(purchase);

		// Update product stock
		product.setStock(product.getStock() + purchaseReqDto.getQuantity());
		productRepo.save(product);

		// Return response DTO
		return purchaseMapper.toDto(savedPurchase);
	}

	@Override
	public List<PurchaseRespDto> showAllProduct() {
		List<Purchase> purchases = purchaseProductRepo.findAll();
		
		return purchaseMapper.toDto2(purchases);
	}

	@Override
	public PurchaseRespDto fetchpurchase(int purchaseId) {
		Optional<Purchase> optionalPurchaseProduct = purchaseProductRepo.findById(purchaseId);

		if (optionalPurchaseProduct.isPresent()) {
			Purchase purchase = optionalPurchaseProduct.get();
			PurchaseRespDto dto = purchaseMapper.toDto3(purchase);
			return dto;
		}

		return null;
	}
	
	@Override
	public PurchaseRespDto updatePurchase(PurchaseReqDto reqDto) {

		Vendor vendor = vendorRepo.findById(reqDto.getVendorId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Vendor not found with ID: " + reqDto.getVendorId()));

		Product product = productRepo.findById(reqDto.getProductId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"Product not found with ID: " + reqDto.getProductId()));
		
		
		BigDecimal total = reqDto.getRate().multiply(BigDecimal.valueOf(reqDto.getQuantity()));
		reqDto.setTotal(total);

		
		Purchase purchaseProduct = purchaseMapper.toEntity(reqDto, vendor, product);
		 Purchase updatedPurchase =purchaseProductRepo.save(purchaseProduct);

		return purchaseMapper.toDto(updatedPurchase);
	}

}