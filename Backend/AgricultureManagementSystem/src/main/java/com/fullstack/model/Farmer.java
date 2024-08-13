package com.fullstack.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="farmer_tbl")
public class Farmer {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	
	private Long farmerId;
	
	private String farmerName;
	
	@Column(unique = true)
	private String email;
	
	private String phoneNo;
	
	private String password;
	

	
	@OneToMany(mappedBy = "farmer")
	private List<FarmerProduct>farmerProduct;



	
	
	
	
	
	
}
