package com.fullstack.ControllerTesting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.fullstack.controller.CropsOrderController;
import com.fullstack.model.CropsOrder;
import com.fullstack.model.Customer;
import com.fullstack.model.FarmerProduct;

import junit.framework.Assert;

class OrderCropsTesting {

	@Autowired
	CropsOrderController cropsOrderController;
	
	@Autowired
	FarmerProduct farmerProduct;
	
	@Autowired
	Customer customer;
	
	@Test
	public void testCropsOrderSuccess() {
		
		CropsOrder cropsOrder = new CropsOrder();
		cropsOrder.setUserName("Vino");
		cropsOrder.setBuildingName("Thinavilai");
		cropsOrder.setCardNum(677899887766655L);
		cropsOrder.setCityName("Nagercoil");
		cropsOrder.setColonyName("Villukuri");
		cropsOrder.setContactNumber(9150620567L);
		cropsOrder.setStateName("Tamil Nadu");
		cropsOrder.setCvv(678);
		cropsOrder.setExp(13/2030);
		
		FarmerProduct product=new FarmerProduct();
		product.setProductId(3L);
		cropsOrder.setFarmerProduct(product);
		
		Customer customer =new Customer();
		customer.setCustomerId(1L);
		cropsOrder.setCustomer(customer);
		
		String insertCropsOrder = "order inserted successfully";
		ResponseEntity<String> result=cropsOrderController.insertorder(cropsOrder);
		Assert.assertEquals(insertCropsOrder, result);
		
		
		
	}
	

}
