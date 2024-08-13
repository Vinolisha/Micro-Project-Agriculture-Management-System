package com.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.dao.CropsDetailsDao;
import com.fullstack.model.CropsDetails;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CropsDetailsServiceImpl implements CropsDetailsService{
	
	@Autowired
	CropsDetailsDao dao;
	

	@Override
	public void insertCropsDetails(CropsDetails details) {
		dao.addCropDetails(details);
	
	}

	@Override
	public boolean updateCropsDetails(CropsDetails details) {
		dao.updateCropDetails(details);
		return true;
	}

	@Override
	public List<CropsDetails> findAllCropsDetails() {
		return this.dao.listAllCropDetails();
	}

	@Override
	public boolean deleteCropsDetails(Long cropsId) {
		dao.deleteCropDetails(cropsId);
		return true;
	}

	@Override
	public CropsDetails findCropsDetailsById(Long cropsId) {
		return dao.findCropDetails(cropsId);
		
	}

}
