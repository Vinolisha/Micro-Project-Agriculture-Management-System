package com.fullstack.model;

import java.util.List;

import org.hibernate.annotations.Collate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Seller_tbl")
public class Seller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sellerId;
	private String sellerName;
	
	@Column(unique = true)
	private String email;
	private String phoneNo;
	private String password;
	
	
	@OneToMany(mappedBy = "seller")
	private List<SellerProduct>sellerProduct;
	
	
	
}
