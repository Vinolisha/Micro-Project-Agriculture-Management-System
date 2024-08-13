package com.fullstack.service;

import java.util.Optional;

import com.fullstack.model.Seller;

public interface SellerService {
	
	public boolean addSeller(Seller seller);

	public Optional<Seller> findByemail(String email);

	public Optional<Seller> sellerLogin(String email, String password);

}
