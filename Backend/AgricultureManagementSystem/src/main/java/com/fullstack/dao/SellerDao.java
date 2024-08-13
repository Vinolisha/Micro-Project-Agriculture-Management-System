package com.fullstack.dao;

import java.util.Optional;

import com.fullstack.model.Seller;

public interface SellerDao {
	
	public void addSeller(Seller seller);
	
	public Optional<Seller> findByemail(String email);

	public Seller sellerLogin(String email, String password);

	

}
