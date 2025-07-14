package com.nt.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repository.ProductRepo;
import com.nt.dto.ProductReqDto;
import com.nt.dto.ProductRespDto;
import com.nt.entity.Product;
import com.nt.mapper.ProductMapper;

import com.nt.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepo productRepo;

	@Autowired
	ProductMapper productMapper;

	@Override
	public String addproduct(ProductReqDto reqDto) {
		Product product = productMapper.toEntity(reqDto);

		Product productAdded = productRepo.save(product);

		return null;
	}

	@Override
	public List<ProductRespDto> showAllProduct() {

		List<Product> list = productRepo.findAll();

		return productMapper.toDto(list);

	}

	@Override

	public ProductRespDto fetchproduct(int id) {
		Optional<Product> optionalProduct = productRepo.findById(id);

		if (optionalProduct.isPresent()) {
			Product product = optionalProduct.get();
			ProductRespDto dto = productMapper.toDto2(product);
			return dto;
		}

		return null;
	}



	@Override
	public String updateProduct(ProductReqDto reqDto) {
		Product product = productMapper.toEntity(reqDto);
		Product productUpdate = productRepo.save(product);

		return null;
	}

	@Override
	public ProductRespDto deleteproduct(int id) {
		productRepo.deleteById(id);

		return null;
	}

}
