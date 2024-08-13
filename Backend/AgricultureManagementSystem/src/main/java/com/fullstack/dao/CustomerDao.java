package com.fullstack.dao;

import java.util.List;
import java.util.Optional;

import com.fullstack.model.Customer;
import com.fullstack.model.FarmerProduct;

public interface CustomerDao {
	
	public Object  addCustomer(Customer customer);

	public Optional<Customer> findbyemail(String email);
	
	public Customer  findById(Long customerId);
	
	public Customer customerLogin(String email, String password);
	
	public List<Customer> listAllCustomer();
	


}
