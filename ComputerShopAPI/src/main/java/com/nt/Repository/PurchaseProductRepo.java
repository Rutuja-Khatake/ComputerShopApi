package com.nt.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.dto.PurchaseRespDto;
import com.nt.entity.PurchaseProduct;

@Repository
public interface PurchaseProductRepo extends JpaRepository<PurchaseProduct, Integer> {

	PurchaseProduct save(PurchaseProduct product);

}
