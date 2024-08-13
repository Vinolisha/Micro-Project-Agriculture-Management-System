package com.fullstack.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fullstack.model.Customer;
import com.fullstack.model.FarmerProduct;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{
	
	private EntityManager entityManager;

	public CustomerDaoImpl() {
		super();
		
	}
	
	@Autowired
	public CustomerDaoImpl(EntityManager entity) {
		super();
		this.entityManager=entity;
	}

	@Override
	public Object addCustomer(Customer customer) {
		System.out.println(customer);
		 try {
	      entityManager.persist(customer);
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
		return customer;
		
	}

	@Override
	public Optional<Customer> findbyemail(String email) {
		 return entityManager.createQuery("SELECT a FROM Customer a WHERE a.email = :email", Customer.class)
	              .setParameter("email", email)
	              .getResultStream()
	              .findFirst();
	    }

	@Override
	public Customer findById(Long customerId) {
		Query<Customer> qrery = (Query<Customer>) entityManager.createQuery("from Customer where customerId=:id");
		qrery.setParameter("id", customerId);
		return qrery.getSingleResult();
		
	}

	

	@Override
	public Customer customerLogin(String email, String password) {
		Query q = (Query) entityManager.createQuery("from Customer log where log.email =?1 and log.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		return (Customer) q.getSingleResult();
	}

	@Override
	public List<Customer> listAllCustomer() {
		List<Customer> customerList =  entityManager.createQuery("from Customer").getResultList();
		return customerList;
	}
}
