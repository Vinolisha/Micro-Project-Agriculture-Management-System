package com.fullstack.controller;

import java.util.HashMap;
import java.util.List;
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

import com.fullstack.dao.FarmerDao;
import com.fullstack.model.Customer;
import com.fullstack.model.Farmer;
import com.fullstack.service.FarmerService;




@RestController
@CrossOrigin("*")
public class FarmerController {
	
	@Autowired
	private FarmerService service ;
	
	@PostMapping("/registerFarmer")
    public ResponseEntity<String> register(@RequestBody Farmer farmer) {
        try {
            
            if (farmer.getEmail() == null || farmer.getPassword() == null || farmer.getPhoneNo() == null  || farmer.getFarmerName() == null) {
                return ResponseEntity.badRequest().body("All fields are required.");
            }
 
            
            service.addFarmer(farmer);
 
            return ResponseEntity.ok("Farmer registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error occurred during registration: " + e.getMessage());
        }
    }
 
    @PostMapping("/loginFarmer")
    public ResponseEntity<?> login(@RequestBody Farmer farmer) {
        try {
            // Find the  by email
            Optional<Farmer> farmerOptional = service.findbyemail(farmer.getEmail());
            if (!farmerOptional.isPresent()) {
                return ResponseEntity.badRequest().body("Invalid email");
            }
 
            Farmer farmerFound = farmerOptional.get();
            Map<String, Long> map=new HashMap<>();
            map.put("farmerId", farmerFound.getFarmerId());
 
            // Check if password matches
            if (!farmer.getPassword().equals(farmerFound.getPassword())) {
                return ResponseEntity.badRequest().body("Invalid password");
            }
 
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error occurred during login: " + e.getMessage());
        }
    }
    
    @GetMapping("/farmerLogin/{email}/{password}	")
	public ResponseEntity<?>  validateLogin(@PathVariable("email") String email, @PathVariable("password") String password) {
		try {
			Optional<Farmer> user=service.farmerLogin(email, password);
			if(user != null) {
				return ResponseEntity.ok(user);
			}
		} catch (Exception e) {
			
		}
		
		return (ResponseEntity<?>) ResponseEntity.badRequest();
	}
	@GetMapping("/fingAllFarmer")
	public List<Farmer> findAllFarmer() {
		return service.findAllFarmer();
	}
}