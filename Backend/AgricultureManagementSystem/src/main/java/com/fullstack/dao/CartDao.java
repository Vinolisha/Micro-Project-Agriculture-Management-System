package com.fullstack.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.model.Cart;
import com.fullstack.model.CropsOrder;



public interface CartDao {

	public boolean validateCart(Cart cart);
	public Cart findCartById(Long cartId);
	public String updateCart(Cart cart);
	public String deleteOrder(Long cartId);
	public List<Cart> listAllCart();
	public void insertCart(Cart cart);

	

}
