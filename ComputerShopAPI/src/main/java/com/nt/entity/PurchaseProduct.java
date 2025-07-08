		package com.nt.entity;
		
		import java.math.BigDecimal;
		import java.time.LocalDate;
		
		import javax.persistence.*;
		
		
		@Entity
		@Table(name = "purchases")
		public class PurchaseProduct {
		
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    @Column(name = "purchase_id")
		    private int purchaseId;
		
		    @Column(name = "vendor_name")
		    private String vendor_name;
		
		    @Column(name = "product_name")
		    private String productName;
		
		    @Column(name = "productId")
		    private int productId;
		
		    @Column(name = "quantity")
		    private int quantity;
		
		    @Column(name = "rate")
		    private BigDecimal rate;
		
		    @Column(name = "total")
		    private BigDecimal total;
		
		    @Column(name = "purchase_date")
		    private LocalDate purchaseDate;
		
			public int getPurchaseId() {
				return purchaseId;
			}
		
			public void setPurchaseId(int purchaseId) {
				this.purchaseId = purchaseId;
			}
		
			public String getVendor_name() {
				return vendor_name;
			}
		
			public void setVendor_name(String vendor_name) {
				this.vendor_name = vendor_name;
			}
		
			public String getProductName() {
				return productName;
			}
		
			public void setProductName(String productName) {
				this.productName = productName;
			}
		
			public int getProductId() {
				return productId;
			}
		
			public void setProductId(int productId) {
				this.productId = productId;
			}
		
			public int getQuantity() {
				return quantity;
			}
		
			public void setQuantity(int quantity) {
				this.quantity = quantity;
			}
		
			public BigDecimal getRate() {
				return rate;
			}
		
			public void setRate(BigDecimal rate) {
				this.rate = rate;
			}
		
			public BigDecimal getTotal() {
				return total;
			}
		
			public void setTotal(BigDecimal total) {
				this.total = total;
			}
		
			public LocalDate getPurchaseDate() {
				return purchaseDate;
			}
		
			public void setPurchaseDate(LocalDate purchaseDate) {
				this.purchaseDate = purchaseDate;
			}
		
			public PurchaseProduct(int purchaseId, String vendor_name, String productName, int productId, int quantity,
					BigDecimal rate, BigDecimal total, LocalDate purchaseDate) {
				super();
				this.purchaseId = purchaseId;
				this.vendor_name = vendor_name;
				this.productName = productName;
				this.productId = productId;
				this.quantity = quantity;
				this.rate = rate;
				this.total = total;
				this.purchaseDate = purchaseDate;
			}
		
		    // Getters and Setters
		    public PurchaseProduct() {
		    	
		    }
		
			
		    
		
		}