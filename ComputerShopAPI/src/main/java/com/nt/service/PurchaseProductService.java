package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.dto.ProductRespDto;
import com.nt.dto.PurchaseReqDto;
import com.nt.dto.PurchaseRespDto;

@Service
public interface PurchaseProductService {

	PurchaseRespDto addPurchasePage(PurchaseReqDto purchaseReqDto);

	List<PurchaseRespDto> showAllProduct();

	PurchaseRespDto fetchpurchase(int purchaseId);

	PurchaseRespDto updatePurchase(PurchaseReqDto reqDto);

}
