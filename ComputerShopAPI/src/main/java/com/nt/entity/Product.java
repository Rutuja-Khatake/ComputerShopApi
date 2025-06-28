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
	private int id;
	private String product_Name;
	private String category;
	private String brand;
	private Float purchase_rate;
	private Float selling_rate;
	private int stock;

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getProduct_Name() {
		return product_Name;
	}



	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
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



	public Product(int id, String product_Name, String category, String brand, Float purchase_rate,
			Float selling_rate, int stock) {
		super();
		this.id = id;
		this.product_Name = product_Name;
		this.category = category;
		this.brand = brand;
		this.purchase_rate = purchase_rate;
		this.selling_rate = selling_rate;
		this.stock = stock;
	}



	public Product() {};
	
	

}
