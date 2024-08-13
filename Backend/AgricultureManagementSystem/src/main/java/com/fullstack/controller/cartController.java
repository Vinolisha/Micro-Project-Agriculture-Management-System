package com.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.model.Cart;
import com.fullstack.service.CartService;

@RestController
@CrossOrigin("*")
public class cartController {

	@Autowired
	CartService service;

	@PostMapping("/addCart")
	public ResponseEntity<String> insertCart(@RequestBody Cart cart) {

		if (service.validateCart(cart)) {

			return ResponseEntity.badRequest().body("item already added");

		} else {
			service.insertCart(cart);
			return ResponseEntity.ok("added");
		}

	}

//	@PostMapping("/add-to-cart")
//    public void addToCart(@RequestBody Cart cartRequest) {
//		service.addToCart(cartRequest);
//    }

	@DeleteMapping("/deleteCart/{cartId}")
	public void deleteCart(@PathVariable("cartId") Long cartId) {

		service.deleteCart(cartId);

	}

	@GetMapping("/findCartId/{cartId}")
	public Cart doFindByCartId(@PathVariable("cartId") Long cartId) {
		return service.findCartById(cartId);
	}

	@GetMapping("/findAllCart")
	public List<Cart> findAllCart() {
		return service.findAllCart();
	}

	@PutMapping("/updateCartDetails")
	public ResponseEntity<String> updateCartDetails(@RequestBody Cart newCart) {
		try {
			service.updateCrops(newCart);
			return ResponseEntity.ok("updated successfully");

		} catch (Exception e) {
			return ResponseEntity.badRequest().body("updated");

		}

	}

}
