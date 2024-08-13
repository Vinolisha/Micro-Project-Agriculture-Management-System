package com.fullstack.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "FarmerProduct_table")
public class FarmerProduct {
	
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
	
//	@Lob
//	private byte[] productImage;
	
	@JsonIgnoreProperties("farmerProduct")
	@OneToMany(mappedBy = "farmerProduct",cascade = CascadeType.ALL)
	private List<CropsOrder> Orders;
	
//	@JsonManagedReference
//	@JsonBackReference
	
	
	@ManyToOne
	@JoinColumn(name="farmerId")
	private Farmer farmer;
	
	


}
