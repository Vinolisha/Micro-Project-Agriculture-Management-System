package com.fullstack.service;

import java.util.List;

import com.fullstack.model.Cart;
import com.fullstack.model.SeedCart;

public interface SeedCartService {


	public boolean validateCart(SeedCart details);

	public boolean updateCrops(SeedCart details);

	boolean deleteCart(Long cartId);

	SeedCart findCartById(Long cartId);

	List<SeedCart> findAllCart();
	
	public void insertCart(SeedCart cart);

}
