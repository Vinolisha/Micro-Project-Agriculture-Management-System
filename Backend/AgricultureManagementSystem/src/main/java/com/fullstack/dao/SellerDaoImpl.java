package com.fullstack.dao;

import java.util.Optional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fullstack.model.Customer;
import com.fullstack.model.Farmer;
import com.fullstack.model.Seller;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@Repository
@Transactional
@Service
public class SellerDaoImpl implements SellerDao {
	
	private EntityManager entityManager;
	
	
	
	public SellerDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public SellerDaoImpl(EntityManager entity) {
		super();
		this.entityManager=entity;
	}

	
	@Override
	public Optional<Seller> findByemail(String email) {

		  return entityManager.createQuery("SELECT a FROM Seller a WHERE a.email = :email", Seller.class)
	              .setParameter("email", email)
	              .getResultStream()
	              .findFirst();
	    }

	@Override
	public void addSeller(Seller seller) {
		  try {
	        	entityManager.persist(seller);
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public Seller sellerLogin(String email, String password) {
		Query q = (Query) entityManager.createQuery("from Seller log where log.email =?1 and log.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		return (Seller) q.getSingleResult();
	}
}
