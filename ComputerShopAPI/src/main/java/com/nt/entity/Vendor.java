package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "vendor")
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vendorId;

	@NotBlank(message = "Vendor name is required")
	@Column(name = "vendorName", nullable = false)
	private String vendorName;

	@NotBlank(message = "Mobile number is required")
	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be exactly 10 digits")
	@Column(name = "mobileNumber", nullable = false, unique = true)
	private String mobileNumber;

	@NotBlank(message = "Address is required")
	@Column(nullable = false)
	private String address;

	// --- Getters and Setters ---

	public Integer getvendorId() {
		return vendorId;
	}

	public void setId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Vendor(Integer vendorId, @NotBlank(message = "Vendor name is required") String vendorName,

			@NotBlank(message = "Mobile number is required") @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be exactly 10 digits") String mobileNumber,
			@NotBlank(message = "Address is required") String address) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	public Vendor() {

	}
}
