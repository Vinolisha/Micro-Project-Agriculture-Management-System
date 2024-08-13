package com.fullstack.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import com.fullstack.dao.SellerDao;
import com.fullstack.model.Seller;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SellerServiceImpl implements SellerService{
	
	@Autowired
	SellerDao dao;
	

	@Override
	public boolean addSeller(Seller seller) {
		dao.addSeller(seller);
		return true;
		
	}

	@Override
	public Optional<Seller> findByemail(String email) {
		return this.dao.findByemail(email);

	}

	@Override
	public Optional<Seller> sellerLogin(String email, String password) {
		return dao.findByemail(email);

	}

}
