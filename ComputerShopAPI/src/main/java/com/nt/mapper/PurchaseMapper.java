package com.nt.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nt.dto.PurchaseReqDto;
import com.nt.dto.PurchaseRespDto;
import com.nt.entity.Product;
import com.nt.entity.Purchase;
import com.nt.entity.Vendor;

@Component
public class PurchaseMapper {

    public Purchase toEntity(PurchaseReqDto dto, Vendor vendor, Product product) {
        Purchase purchase = new Purchase();
        purchase.setPurchaseId(dto.getPurchaseId());
        purchase.setVendor(vendor);
        purchase.setProduct(product);
        purchase.setQuantity(dto.getQuantity());
        purchase.setRate(dto.getRate());
        purchase.setTotal(dto.getTotal());
        purchase.setPurchaseDate(dto.getPurchaseDate());
        return purchase;
    }

    public PurchaseRespDto toDto(Purchase purchase) {
        return new PurchaseRespDto(
            purchase.getPurchaseId(),
            purchase.getVendor().getvendorId(),
            purchase.getVendor().getVendorName(),
            purchase.getProduct().getproductId(),
            purchase.getProduct().getProductName(),
            purchase.getQuantity(),
            purchase.getRate(),
            purchase.getTotal(),
            purchase.getPurchaseDate()
        );
    }

    public List<PurchaseRespDto> toDto2(List<Purchase> list) {
        List<PurchaseRespDto> dtoList = new ArrayList<>();

        for (Purchase purchase : list) {
            if (purchase.getVendor() == null || purchase.getProduct() == null) {
                continue;
            }

            PurchaseRespDto dto = new PurchaseRespDto();
            dto.setVendorId(purchase.getVendor().getvendorId());
            dto.setVendorName(purchase.getVendor().getVendorName());
            dto.setProductId(purchase.getProduct().getproductId());
            dto.setProductName(purchase.getProduct().getProductName());
            dto.setPurchaseId(purchase.getPurchaseId());
            dto.setQuantity(purchase.getQuantity());
            dto.setRate(purchase.getRate());
            dto.setTotal(purchase.getTotal());
            dto.setPurchaseDate(purchase.getPurchaseDate());

            dtoList.add(dto);
        }

        return dtoList;
    }

    public PurchaseRespDto toDto3(Purchase purchase) {
        PurchaseRespDto dto = new PurchaseRespDto();
        dto.setPurchaseId(purchase.getPurchaseId());
        dto.setVendorId(purchase.getVendor().getvendorId());
        dto.setVendorName(purchase.getVendor().getVendorName());
        dto.setProductId(purchase.getProduct().getproductId());
        dto.setProductName(purchase.getProduct().getProductName());
        dto.setQuantity(purchase.getQuantity());
        dto.setRate(purchase.getRate());
        dto.setTotal(purchase.getTotal());
        dto.setPurchaseDate(purchase.getPurchaseDate());
        return dto;
    }
}
