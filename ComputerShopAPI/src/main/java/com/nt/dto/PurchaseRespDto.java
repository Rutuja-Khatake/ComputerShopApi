package com.nt.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRespDto {

	private int purchaseId;
	private String vendorName;
	private String productName;
	private int productId;
	private int quantity;
	private BigDecimal rate;
	private BigDecimal total;
	 @DateTimeFormat(pattern = "yyyy-MM-dd") 
	private LocalDate purchaseDate;

}
