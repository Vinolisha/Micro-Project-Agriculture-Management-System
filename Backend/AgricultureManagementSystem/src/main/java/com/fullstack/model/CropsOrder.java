package com.fullstack.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "Cropsorder_tbl")
public class CropsOrder {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private FarmerProduct farmerProduct;

	
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
