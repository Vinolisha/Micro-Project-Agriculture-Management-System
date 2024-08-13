package com.fullstack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="CropsDetails_table")
public class CropsDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cropsId;
	private String cropsName;
	
	@Lob
	@Column(name="cropsimage",length=1000)
	private byte[] cropsImage;
	
	private String imageName;
	private String imageType;
	
	
	private String cropsBenefits;
	private String description; 
	
	
	
	
	
}
