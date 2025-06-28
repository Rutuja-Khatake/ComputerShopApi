package com.nt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRespDto {
	private int id;
	private String product_Name;
	private String category;
	private String brand;
	private Float purchase_rate;
	private Float selling_rate;
	private int stock;
}
