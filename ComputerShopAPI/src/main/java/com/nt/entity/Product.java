package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private String productName;
	private String category;
	private String brand;
	private Float purchase_rate;
	private Float selling_rate;
	private int stock;

	
	
	public int getproductId() {
		return productId;
	}



	public void setproductId(int productId) {
		this.productId = productId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public Float getPurchase_rate() {
		return purchase_rate;
	}



	public void setPurchase_rate(Float purchase_rate) {
		this.purchase_rate = purchase_rate;
	}



	public Float getSelling_rate() {
		return selling_rate;
	}



	public void setSelling_rate(Float selling_rate) {
		this.selling_rate = selling_rate;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}



	public Product(int productId, String productName, String category, String brand, Float purchase_rate,
			Float selling_rate, int stock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.brand = brand;
		this.purchase_rate = purchase_rate;
		this.selling_rate = selling_rate;
		this.stock = stock;
	}



	public Product() {};
	
	

}
