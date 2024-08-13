package com.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.model.SeedCart;
import com.fullstack.service.SeedCartService;

@RestController
@CrossOrigin("*")
@RequestMapping("/seedCart")
public class SeedCartController {
	@Autowired
	SeedCartService service;

	@PostMapping("/addSeedCart")
	public ResponseEntity<String> insertCart(@RequestBody SeedCart cart) {

		System.out.println(service.validateCart(cart));
		if (service.validateCart(cart)) {

			return ResponseEntity.badRequest().body("item already added");

		} else {
			service.insertCart(cart);
			return ResponseEntity.ok("added");

		}

	}

	@GetMapping("/findAllCart")
	public List<SeedCart> findAllCart() {
		return service.findAllCart();
	}
	
	@DeleteMapping("/deleteCart/{cartId}")
	public ResponseEntity<String> deleteCart(@PathVariable("cartId") Long cartId) {
		try {
			service.deleteCart(cartId);
			return ResponseEntity.ok("Deletion Success");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Deletion Failure");
		}
	}
	
	

}
