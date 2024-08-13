package com.fullstack.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Cart_tbl")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CartId;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="productId")
	private FarmerProduct farmerProduct;
	
	
	private int totalPrice;
	
	private int quantity;
	
	
	
	
	
	
}
