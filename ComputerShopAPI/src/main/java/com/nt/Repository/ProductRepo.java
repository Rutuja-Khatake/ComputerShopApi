package com.nt.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.dto.ProductReqDto;
import com.nt.dto.ProductRespDto;
import com.nt.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
//	List<Product> findAll();
//
//	ProductReqDto save(int id);
//
//	void save(PurchaseProduct prod);

	

}
