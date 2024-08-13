package com.fullstack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import com.fullstack.dao.CartDao;
import com.fullstack.dao.CartDaoImpl;
import com.fullstack.dao.CustomerDao;
import com.fullstack.dao.CustomerDaoImpl;
import com.fullstack.dao.FarmerProductDao;
import com.fullstack.dao.FarmerProductDaoImpl;
import com.fullstack.model.Cart;
import com.fullstack.model.Customer;
import com.fullstack.model.FarmerProduct;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	CartDaoImpl dao;
	
	
	
	@Override
	public boolean validateCart(Cart details) {
		return dao.validateCart(details);
		
		
	}

	@Override
	public boolean updateCrops(Cart details) {
		dao.updateCart(details);
		return true;
	}

	@Override
	public boolean deleteCart(Long CartId) {
		dao.deleteOrder(CartId);
		return true;
	}

	@Override
	public Cart findCartById(Long cartId) {
		// TODO Auto-generated method stub
		return dao.findCartById(cartId);
	}

	@Override
	public List<Cart> findAllCart() {
		return this.dao.listAllCart();
	}

	@Override
	public void insertCart(Cart cart) {
		dao.insertCart(cart);
		
	}
	
//	@Autowired
//	private CartDao cartDao;
//	
//	
//	@Autowired
//	private  CustomerDaoImpl customerDao;
//		
//	@Autowired
//	private FarmerProductDaoImpl productDao;
//	
//	public void addToCart(Cart cartRequest) {
//        // Check if the Cart request contains a valid User and GiftList
//        if (cartRequest.getCustomer() == null || cartRequest.getFarmerProduct() == null) {
//            throw new IllegalArgumentException("Customer or product is null in the cart request.");
//        }
//
//        // Extract information from CartRequest
//        Long customerId = cartRequest.getCustomer().getCustomerId();
//        Long productId = cartRequest.getFarmerProduct().getProductId();
//        int quant = cartRequest.getQuantity();
//
//        
//        // Retrieve user and gift from repositories
//        Customer customer = customerDao.findById(customerId);
////               .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + customerId));
//        FarmerProduct product = productDao.findProductById(productId);
////               .orElseThrow(() -> new IllegalArgumentException("GiftList not found with ID: " + productId));
//        
//        
//        // Check if the gift is already in the user's cart
////        Optional<Cart> userCarts = cartDao.findById(productId);
////        if (!userCarts.isEmpty()) {
////            throw new IllegalArgumentException("GiftList with ID: " + giftId + " is already added in the cart.");
////        }
//
//        // Calculate total price based on gift price and quantity
//        int totalPrice = product.getPrice() * quant;
//        // Total gifts is just the quantity
//       int totalProduct = quant;
//
//        // Create cart item
//        Cart cart = new Cart();
//        cart.setCustomer(customer);
//        cart.setFarmerProduct(product);
//        cart.setQuantity(quant);
//        cart.setTotalPrice(totalPrice);
//        cart.setTotalProduct(totalProduct);
//
//        // Save the cart item
//        cartDao.save(cart);
//    }

}
