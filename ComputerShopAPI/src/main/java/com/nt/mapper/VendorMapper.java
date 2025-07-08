package com.nt.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nt.dto.ProductRespDto;
import com.nt.dto.VendorReqDto;
import com.nt.dto.VendorRespDto;
import com.nt.entity.Product;
import com.nt.entity.Vendor;

@Component
public class VendorMapper {

	public Vendor toEntity(VendorReqDto dto) {
		return new Vendor(dto.getId(),dto.getVendorName(),dto.getMobileNumber(),dto.getAddress());
	}

	public List toDto(List<Vendor> list) {
		// TODO Auto-generated method stub
		List<VendorRespDto> dtoList = new ArrayList<>();

		for (Vendor vendor : list) {
			VendorRespDto dto = new VendorRespDto();
			dto.setId(vendor.getId());
			dto.setVendorName(vendor.getVendorName());
			dto.setMobileNumber(vendor.getMobileNumber());
			dto.setAddress(vendor.getAddress());
			
			dtoList.add(dto);
		}

		return dtoList;

	}

	public VendorRespDto toDto2(Vendor vendor) {
		return new VendorRespDto(vendor.getId(),vendor.getVendorName(),vendor.getMobileNumber(),vendor.getAddress());
	}
}
