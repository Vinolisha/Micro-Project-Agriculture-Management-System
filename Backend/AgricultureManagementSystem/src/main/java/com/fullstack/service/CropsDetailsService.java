package com.fullstack.service;

import java.util.List;

import com.fullstack.model.CropsDetails;


public interface CropsDetailsService {
	
	public void insertCropsDetails(CropsDetails details);
	public boolean updateCropsDetails(CropsDetails details);
	
	boolean deleteCropsDetails(Long cropsId);
	CropsDetails findCropsDetailsById(Long cropsId);
	List<CropsDetails> findAllCropsDetails();
}
