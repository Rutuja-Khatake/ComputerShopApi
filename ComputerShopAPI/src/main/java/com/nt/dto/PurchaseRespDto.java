package com.nt.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

import com.nt.entity.Product;
import com.nt.entity.Vendor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRespDto {

	private int purchaseId;
	 @Min(value = 1, message = "Vendor ID must not be 0")
    private int vendorId;
    private String vendorName;
    private int productId;
    private String productName;
    private int quantity;
    private BigDecimal rate;
    private BigDecimal total;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate purchaseDate;
	
}
