package com.fullstack.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "SellerProduct_table")
public class SellerProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	
	@Lob
	@Column(name="imageproduct",length=1000)
	private byte[] imageProduct;
	
	private String imageName;
	private String imageType;
	
	private String category;
	
	private String productName;
	
	private String description;
	
	private String quantity;
	
	private int price;	
	
	@JsonIgnoreProperties("sellerProduct")
	@OneToMany(mappedBy = "sellerProduct",cascade = CascadeType.ALL)
	private List<SeedOrder> Orders;
	
	//@JsonIgnoreProperties("sellerProduct")
	@ManyToOne
	@JoinColumn(name="sellerId")
	private Seller seller;	
	
	
	
	
}
