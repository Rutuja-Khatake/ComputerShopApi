package com.nt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRespDto {
    	private int id;
		private String customerName;
		private String mobileNumber;
		private String address;
		
}

