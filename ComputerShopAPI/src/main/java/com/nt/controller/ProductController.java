package com.nt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.dto.ProductReqDto;
import com.nt.dto.ProductRespDto;
import com.nt.entity.Product;
import com.nt.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
	@Autowired
	ProductService productService;

	@PostMapping("/addAllProduct")
	public String addProductPage(@RequestBody ProductReqDto reqDto) {

		String added = productService.addproduct(reqDto);
		return added;

	}

	@GetMapping("/showAllList")
	public List<ProductRespDto> showAllProduct() {

		return productService.showAllProduct();
	}

	@GetMapping("/fetchData/{id}")
	public ResponseEntity<?> fetchDataPage(@PathVariable int id) {
	    ProductRespDto productRespDto = productService.fetchproduct(id);
	    if (productRespDto == null) {
	        return ResponseEntity.status(404).body("Product with ID " + id + " not found.");
	    }
	    return ResponseEntity.ok(productRespDto);
	}
	
	
	@PostMapping("/updateProduct")
	public String updateProduct(@RequestBody ProductReqDto reqDto) {

		String isUpdate = productService.updateProduct(reqDto);
		return isUpdate;
	}
	
	@GetMapping("/deleteData/{id}")
	public ResponseEntity<?> deleteDataPage(@PathVariable int id) {
	    ProductRespDto productRespDto = productService.deleteproduct(id);
	    if (productRespDto == null) {
	        return ResponseEntity.status(404).body("Product with ID " + id + " not found.");
	    }
	    return ResponseEntity.ok(productRespDto);
	}

}
