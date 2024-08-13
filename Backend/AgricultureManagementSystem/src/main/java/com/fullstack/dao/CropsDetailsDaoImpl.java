package com.fullstack.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fullstack.model.CropsDetails;


import jakarta.persistence.EntityManager;

@Repository
public class CropsDetailsDaoImpl implements CropsDetailsDao{

	@Autowired
	private EntityManager entity;
	
	@Override
	public String addCropDetails(CropsDetails details) {
		String msg="";
		try {
		entity.persist(details);
		return msg="Inserted Success";
		}catch(Exception e) {
			return msg="Inserted failure";
		}

	}

	@Override
	public CropsDetails findCropDetails(Long cropsId) {
		Query<CropsDetails> qrery = (Query<CropsDetails>) entity.createQuery("from CropsDetails where cropsId=:id");
		qrery.setParameter("id", cropsId);
		return qrery.getSingleResult();	

	}


	@Override
	public String updateCropDetails(CropsDetails details) {
		String msg="";
		try {
			entity.merge(details);
			return msg="updation successfull";
		}catch(Exception e) {
			return msg="updation failure";
		}
	}

	@Override
	public String deleteCropDetails(Long cropsId) {
		String msg="";
		CropsDetails detail = entity.find(CropsDetails.class, cropsId);
		try {
			entity.remove(detail);
			return msg="deletion success";
		}catch(Exception e) {
			return msg="deletion failure";
		}

	}

	@Override
	public List<CropsDetails> listAllCropDetails() {
		List<CropsDetails> cropsList =  entity.createQuery("from CropsDetails").getResultList();
		return cropsList;
	}



	
}
