package com.fullstack.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fullstack.model.Seller;
import com.fullstack.service.SellerService;

@RestController
@CrossOrigin("*")
public class SellerController {

	@Autowired
	private SellerService service;

	@PostMapping("/registerSeller")
	public ResponseEntity<String> register(@RequestBody Seller seller) {
		try {

			if (seller.getEmail() == null || seller.getPassword() == null || seller.getPhoneNo() == null
					|| seller.getSellerName() == null) {
				return ResponseEntity.badRequest().body("All fields are required.");
			}

			service.addSeller(seller);

			return ResponseEntity.ok("Seller registered successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error occurred during registration: " + e.getMessage());
		}
	}

	@PostMapping("/loginSeller")
	public ResponseEntity<?> login(@RequestBody Seller seller) {
		try {
			// Find the by email
			Optional<Seller> sellerOptional = service.findByemail(seller.getEmail());
			if (!sellerOptional.isPresent()) {
				return ResponseEntity.badRequest().body("Invalid email");
			}

			Seller sellerFound = sellerOptional.get();
			Map<String, Long> map=new HashMap<>();
            map.put("sellerId", sellerFound.getSellerId());

			// Check if password matches
			if (!seller.getPassword().equals(sellerFound.getPassword())) {
				return ResponseEntity.badRequest().body("Invalid password");
			}

			return ResponseEntity.ok(map);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error occurred during login: " + e.getMessage());
		}
	}
	
	@GetMapping("/sellerLogin/{email}/{password}	")
	public ResponseEntity<?>  validateLogin(@PathVariable("email") String email, @PathVariable("password") String password) {
		try {
			Optional<Seller>  user=service.sellerLogin(email, password);
			if(user != null) {
				return ResponseEntity.ok(user);
			}
		} catch (Exception e) {
			
		}
		
		return (ResponseEntity<?>) ResponseEntity.badRequest();
	}

}
