package com.nt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Vendor;

public interface VendorRepo extends JpaRepository<Vendor, Integer>{

}
