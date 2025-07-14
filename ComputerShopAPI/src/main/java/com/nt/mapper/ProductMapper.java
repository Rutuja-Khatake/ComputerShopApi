package com.nt.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.nt.dto.ProductReqDto;
import com.nt.dto.ProductRespDto;
import com.nt.entity.Product;

@Component
public class ProductMapper {

	public Product toEntity(ProductReqDto reqDto) {

		return new Product(reqDto.getProductId(), reqDto.getProductName(), reqDto.getCategory(), reqDto.getBrand(),
				reqDto.getPurchase_rate(), reqDto.getSelling_rate(), reqDto.getStock());
	}

	public List<ProductRespDto> toDto(List<Product> list) {
		List<ProductRespDto> dtoList = new ArrayList<>();

		for (Product product : list) {
			ProductRespDto dto = new ProductRespDto();
			dto.setProductId(product.getproductId());
			dto.setProductName(product.getProductName());
			dto.setCategory(product.getCategory());
			dto.setBrand(product.getBrand());
			dto.setPurchase_rate(product.getPurchase_rate());
			dto.setSelling_rate(product.getSelling_rate());
			dto.setStock(product.getStock());
			dtoList.add(dto);
		}

		return dtoList;

	}

	public ProductRespDto toDto2(Product product) {
		return new ProductRespDto(product.getproductId(), product.getProductName(), product.getCategory(), product.getBrand(),
				product.getPurchase_rate(), product.getSelling_rate(), product.getStock());
	}

}
