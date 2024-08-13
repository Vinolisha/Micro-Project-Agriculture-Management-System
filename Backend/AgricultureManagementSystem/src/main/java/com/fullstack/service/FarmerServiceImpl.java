package com.fullstack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.dao.FarmerDao;
import com.fullstack.model.Farmer;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FarmerServiceImpl implements FarmerService{

	@Autowired
	FarmerDao dao;
	
	@Override
	public boolean addFarmer(Farmer farmer) {
		dao.addFarmer(farmer);
		return true;
	}

	@Override
	public Optional<Farmer> findbyemail(String email) {
		return this.dao.findbyemail(email);

	}

	@Override
	public Optional<Farmer> farmerLogin(String email, String password) {
		return dao.findbyemail(email);

	}

	@Override
	public List<Farmer> findAllFarmer() {
		return this.dao.listAllFarmer();
	}

}
