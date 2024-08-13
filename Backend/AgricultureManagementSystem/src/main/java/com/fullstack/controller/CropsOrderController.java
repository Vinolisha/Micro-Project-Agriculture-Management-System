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

import com.fullstack.model.CropsOrder;

import com.fullstack.service.CropsOrderService;

@RestController
@CrossOrigin("*")
@RequestMapping("/CropsOrder")
public class CropsOrderController {
	
	@Autowired
	CropsOrderService service;
	
	@PostMapping("/insertCropsOrder")
	public ResponseEntity<String> insertorder(@RequestBody CropsOrder order) {
		try{
			service.insertOrder(order);
			return ResponseEntity.ok("order inserted successfully");
		}catch(Exception e){
			return ResponseEntity.badRequest().body("Insertion Failure");
		}
		
	}
	
	
	@DeleteMapping("/deleteOrder/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable("productId")Long orderId){
		try {
			service.deleteOrder(orderId);
			return ResponseEntity.ok("Deletion Success");
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Deletion Failure");
		}
	}
	
		@GetMapping("/findOrderById/{orderId}")
		public CropsOrder findByCropsOrder(@PathVariable("orderId")Long orderId) {
			return service.findOrderById(orderId);
		}

	@GetMapping("/findAllOrder")
	public List<CropsOrder> findAllOrders() {
		return service.findAllOrder();
	}

}
