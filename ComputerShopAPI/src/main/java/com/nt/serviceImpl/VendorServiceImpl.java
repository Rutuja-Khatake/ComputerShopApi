package com.nt.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.VendorRepo;

import com.nt.dto.VendorReqDto;
import com.nt.dto.VendorRespDto;
import com.nt.entity.Product;
import com.nt.entity.Vendor;
import com.nt.mapper.VendorMapper;
import com.nt.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	VendorRepo vendorRepo;
	
	@Autowired
	VendorMapper vendorMapper;

	@Override
	public String addVendorPage(VendorReqDto dto) {
		
		Vendor vendor=vendorMapper.toEntity(dto);
		Vendor addedVendor=	vendorRepo.save(vendor);
		return null;
	}

	@Override
	public List getAll() {
		List<Vendor> list = vendorRepo.findAll();

		return vendorMapper.toDto(list);
	}

	@Override
	public VendorRespDto fetchData(int id) {
		Optional<Vendor> optionalData = vendorRepo.findById(id);

		if (optionalData.isPresent()) {
			Vendor  vendor = optionalData.get();
			VendorRespDto dto = vendorMapper.toDto2(vendor);
			return dto;
		}

		return null;
	}

	@Override
	public String updateVendorData(VendorReqDto reqDto) {
		Vendor vendor = vendorMapper.toEntity(reqDto);
		Vendor vendorUpdate = vendorRepo.save(vendor);

		return null;
	}

	

}
