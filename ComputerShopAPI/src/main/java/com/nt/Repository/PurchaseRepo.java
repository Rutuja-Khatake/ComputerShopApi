package com.nt.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Purchase;


public interface PurchaseRepo extends JpaRepository<Purchase, Integer>{


}
