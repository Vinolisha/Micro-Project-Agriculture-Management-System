package com.fullstack.dao;

import java.util.List;

import com.fullstack.model.Cart;
import com.fullstack.model.SeedCart;

public interface SeedCartDao {
	
	public boolean validateCart(SeedCart cart);
	public SeedCart findCartById(Long cartId);
	public String updateCart(SeedCart cart);
	public String deleteOrder(Long cartId);
	public List<SeedCart> listAllCart();
	public void insertCart(SeedCart cart);

}
