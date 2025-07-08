package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.dto.PurchaseReqDto;
import com.nt.dto.PurchaseRespDto;

@Service
public interface PurchaseProductService {

	PurchaseRespDto updatePurchasePage(PurchaseReqDto purchaseReqDto);

}
