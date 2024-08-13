package com.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fullstack.dao.SellerProductDao;
import com.fullstack.model.SeedCart;
import com.fullstack.model.SellerProduct;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class SellerProductServiceImpl implements SellerProductService {

	@Autowired
	SellerProductDao dao;
	


	@Override
	public boolean insertProduct(SellerProduct product) {
		this.dao.addProduct(product);
		   return true;
	}

	@Override
	public boolean updateProduct(SellerProduct product) {
		dao.updateProduct(product);
		return true;
	}

	@Override
	public List<SellerProduct> findAllProduct() {
		return this.dao.listAllProduct();
	}

	@Override
	public boolean deleteProduct(Long productId) {
		dao.deleteProduct(productId);
		return true;
	}

	@Override
	public SellerProduct findProductyById(Long productId) {
		return dao.findProductById(productId);
	}
	
	


}
