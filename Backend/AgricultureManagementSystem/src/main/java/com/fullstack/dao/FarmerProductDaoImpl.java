package com.fullstack.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fullstack.model.FarmerProduct;

import jakarta.persistence.EntityManager;

@Repository
public class FarmerProductDaoImpl implements FarmerProductDao{
	
	@Autowired
	private EntityManager entity;

	@Override
	public String addProduct(FarmerProduct product) {
		String msg="";
		try {
		entity.persist(product);
		return msg="Inserted Success";
		}catch(Exception e) {
			return msg="Inserted failure";
		}

	}

	@Override
	public FarmerProduct findProductById(Long productId) {
		Query<FarmerProduct> qrery = (Query<FarmerProduct>) entity.createQuery("from FarmerProduct where productId=:id");
		qrery.setParameter("id", productId);
		return qrery.getSingleResult();
	}

	@Override
	public String updateProduct(FarmerProduct product) {
		String msg="";
		try {
			entity.merge(product);
			return msg="updation successfull";
		}catch(Exception e) {
			return msg="updation failure";
		}
	}

	@Override
	public String deleteProduct(Long ProductId) {
		String msg="";
		FarmerProduct prod = entity.find(FarmerProduct.class, ProductId);
		try {
			entity.remove(prod);
			return msg="deletion success";
		}catch(Exception e) {
			return msg="deletion failure";
		}
	}

	@Override
	public List<FarmerProduct> listAllProduct() {
		List<FarmerProduct> farmerList =  entity.createQuery("from FarmerProduct").getResultList();
		return farmerList;
	}
	
	
}
