package com.nt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRespDto {
	public ProductRespDto(int id2, String string) {
		// TODO Auto-generated constructor stub
	}

	private int id;
	private String product_Name;
	private String category;
	private String brand;
	private Float purchase_rate;
	private Float selling_rate;
	private int stock;
}
