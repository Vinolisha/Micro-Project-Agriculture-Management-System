package com.fullstack.dao;

import java.util.List;

import com.fullstack.model.CropsDetails;

public interface CropsDetailsDao {
	public String addCropDetails(CropsDetails details);
	public CropsDetails findCropDetails(Long cropsId);
	public String updateCropDetails(CropsDetails details);
	public String deleteCropDetails(Long cropsId);
	public List<CropsDetails> listAllCropDetails();
}
