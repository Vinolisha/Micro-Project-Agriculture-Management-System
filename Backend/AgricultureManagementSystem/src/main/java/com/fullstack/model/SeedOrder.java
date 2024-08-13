package com.fullstack.model;

import jakarta.persistence.Column;
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
@Table(name = "Seedordertable")
public class SeedOrder {
	
	

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long orderId;

		
		
		@ManyToOne
		@JoinColumn(name = "farmerId")
		private Farmer farmer;

		
		
		@ManyToOne
		@JoinColumn(name = "productId")
		private SellerProduct sellerProduct;

		
		@Column(name = "order_date")
		private String orderDate;
		
		private String userName;
		private String buildingName;
		private String colonyName;
		private String cityName;
		private String stateName;
		private Long contactNumber;
		
		private Long cardNum;
		private int exp;
		private int cvv;


}
