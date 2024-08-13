package com.fullstack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fullstack.dao.SellerDao;
import com.fullstack.model.Cart;
import com.fullstack.model.Customer;

public interface CustomerService {
	
	public boolean addCustomer(Customer customer);

	public Optional<Customer> findbyemail(String email);
	
	public Customer  findById(Long customerId);
	
	public Optional<Customer> customerLogin(String email, String password);
	
	List<Customer> findAllCustomer();

}
