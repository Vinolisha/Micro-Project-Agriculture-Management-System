package com.fullstack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.dao.CustomerDao;
import com.fullstack.model.Customer;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerDao dao;

	@Override
	public boolean addCustomer(Customer customer) {
		dao.addCustomer(customer);
		return true;
	}
		
	

	@Override
	public Optional<Customer> findbyemail(String email) {
		return this.dao.findbyemail(email);
	}

	@Override
	public Customer findById(Long customerId) {
		// TODO Auto-generated method stub
		return dao.findById(customerId);
	}

	@Override
	public Optional<Customer> customerLogin(String email, String password) {
		return dao.findbyemail(email);
	}



	@Override
	public List<Customer> findAllCustomer() {
		return this.dao.listAllCustomer();
	}
	
	
}
