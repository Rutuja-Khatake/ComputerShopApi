package com.nt.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Customer name is required")
    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be exactly 10 digits")
    @Column(name = "mobileNumber", nullable = false, unique = true)
    private String mobileNumber;

    @NotBlank(message = "Address is required")
    @Column(name = "address", nullable = false)
    private String address;

    // --- Constructors ---
    public Customer() {
        // Default constructor
    }

    public Customer(Integer id, String customerName, String mobileNumber, String address) {
        this.id = id;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    // --- Getters and Setters ---
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
}
