package com.fullstack.model;

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
@Table(name="seedCart_tbl")
public class SeedCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CartId;
	
	@ManyToOne
	@JoinColumn(name="farmerId")
	private Farmer farmer;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private SellerProduct sellerProduct;
	
	
	private int totalPrice;
	
	private int quantity;

	
	
}
