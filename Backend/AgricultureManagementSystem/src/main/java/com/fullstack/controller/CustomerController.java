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

import com.fullstack.dao.CustomerDao;
import com.fullstack.model.Cart;
import com.fullstack.model.Customer;
import com.fullstack.service.CustomerService;

@RestController
@CrossOrigin("*")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping("/registerCustomer")
    public ResponseEntity<String> register(@RequestBody Customer customer) {
        try {
            
            if (customer.getEmail() == null || customer.getPassword() == null || customer.getPhoneNo() == null || customer.getCustomerName() == null) {
                return ResponseEntity.badRequest().body("All fields are required.");
            }
 
            
            service.addCustomer(customer);
 
            return ResponseEntity.ok("Customer registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error occurred during registration: " + e.getMessage());
        }
    }
	
	@PostMapping("/loginCustomer")
    public ResponseEntity<?> login(@RequestBody Customer customer) {
        try {
            // Find the  by email
            Optional<Customer> customerOptional = service.findbyemail(customer.getEmail());
            
            if (!customerOptional.isPresent()) {
                return ResponseEntity.badRequest().body("InValid email");
            }
 
            Customer customerFound = customerOptional.get();
            Map<String, Long> map=new HashMap<>();
            map.put("customerId", customerFound.getCustomerId());
 
            // Check if password matches
            if (!customer.getPassword().equals(customerFound.getPassword())) {
                return ResponseEntity.badRequest().body("Invalid password");
            }
 
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error occurred during login: " + e.getMessage());
        }
    }
	
	
	@GetMapping("/customerLogin/{email}/{password}	")
		public ResponseEntity<?>  validateLogin(@PathVariable("email") String email, @PathVariable("password") String password) {
			try {
				Optional<Customer> user=service.customerLogin(email, password);
				if(user != null) {
					return ResponseEntity.ok(user);
				}
			} catch (Exception e) {
				
			}
			
			return (ResponseEntity<?>) ResponseEntity.badRequest();
		}
	
	@GetMapping("/fingAllCustomer")
	public List<Customer> findAllCustomers() {
		return service.findAllCustomer();
	}
	
	
	

}
