package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.dto.VendorReqDto;
import com.nt.dto.VendorRespDto;

@Service
public interface VendorService {

	String addVendorPage(VendorReqDto dto);

	List getAll();

	VendorRespDto fetchData(int id);

	String updateVendorData(VendorReqDto reqDto);

}
