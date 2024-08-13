package com.fullstack.service;

import java.util.List;

import com.fullstack.model.Cart;
import com.fullstack.model.CropsDetails;

public interface CartService {

	public boolean validateCart(Cart details);

	public boolean updateCrops(Cart details);

	boolean deleteCart(Long cartId);

	Cart findCartById(Long cartId);

	List<Cart> findAllCart();
	
	public void insertCart(Cart cart);

	

}