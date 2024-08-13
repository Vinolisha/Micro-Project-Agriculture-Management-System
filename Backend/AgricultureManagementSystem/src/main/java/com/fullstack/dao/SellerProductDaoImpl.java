package com.fullstack.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fullstack.model.SellerProduct;

import jakarta.persistence.EntityManager;

@Repository
public class SellerProductDaoImpl implements SellerProductDao {

	@Autowired
	private EntityManager entity;

	@Override
	public String addProduct(SellerProduct product) {
		String msg="";
		try {
		entity.persist(product);
		return msg="Inserted Success";
		}catch(Exception e) {
			return msg="Inserted failure";
		}

	}

	@Override
	public SellerProduct findProductById(Long productId) {
		Query<SellerProduct> qrery = (Query<SellerProduct>) entity.createQuery("from SellerProduct where productId=:id");
		qrery.setParameter("id", productId);
		return qrery.getSingleResult();
	}

	@Override
	public String updateProduct(SellerProduct product) {
		String msg="";
		try {
			entity.merge(product);
			return msg="updation successfull";
		}catch(Exception e) {
			return msg="updation failure";
		}
	}

	@Override
	public String deleteProduct(Long productId) {
		String msg="";
		SellerProduct prod = entity.find(SellerProduct.class, productId);
		try {
			entity.remove(prod);
			return msg="deletion success";
		}catch(Exception e) {
			return msg="deletion failure";
		}
	}

	@Override
	public List<SellerProduct> listAllProduct() {
		List<SellerProduct> farmerList =  entity.createQuery("from SellerProduct").getResultList();
		return farmerList;
	}
	


}
