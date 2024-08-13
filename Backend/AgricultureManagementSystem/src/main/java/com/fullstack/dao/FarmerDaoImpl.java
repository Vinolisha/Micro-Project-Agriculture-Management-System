package com.fullstack.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fullstack.model.Customer;
import com.fullstack.model.Farmer;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
@Service
public class FarmerDaoImpl implements FarmerDao {
	
	private EntityManager entityManager;

	public FarmerDaoImpl() {
		super();
		
	}
	
	@Autowired
	public FarmerDaoImpl(EntityManager entity) {
		super();
		this.entityManager=entity;
	}

	@Override
	public void addFarmer(Farmer farmer) {
		
	        try {
	        	entityManager.persist(farmer);
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public Optional<Farmer> findbyemail(String email) {
			
		  return entityManager.createQuery("SELECT a FROM Farmer a WHERE a.email = :email", Farmer.class)
		              .setParameter("email", email)
		              .getResultStream()
		              .findFirst();
		    }

	@Override
	public Farmer farmerLogin(String email, String password) {
		Query q = (Query) entityManager.createQuery("from Customer log where log.email =?1 and log.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		return (Farmer) q.getSingleResult();
	}

	@Override
	public List<Farmer> listAllFarmer() {
		List<Farmer> farmerList =  entityManager.createQuery("from Farmer").getResultList();
		return farmerList;
	}
	}

