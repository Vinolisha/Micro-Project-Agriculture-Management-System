package com.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.dao.FarmerProductDao;
import com.fullstack.model.FarmerProduct;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FarmerProductServiceImpl implements FarmerProductService{
	
	@Autowired
	FarmerProductDao dao;

	@Override
	public boolean insertProduct(FarmerProduct product) {
		this.dao.addProduct(product);
		   return true;
	}

	@Override
	public boolean updateProduct(FarmerProduct product) {
		dao.updateProduct(product);
		return true;
		  

	}

	@Override
	public boolean deleteProduct(Long productId) {
		dao.deleteProduct(productId);
		return true;
	}


	@Override
	public List<FarmerProduct> findAllProduct() {
		return this.dao.listAllProduct();
	}

	@Override
	public FarmerProduct findProductyById(Long productId) {
		
		return dao.findProductById(productId);
	}
	
}
