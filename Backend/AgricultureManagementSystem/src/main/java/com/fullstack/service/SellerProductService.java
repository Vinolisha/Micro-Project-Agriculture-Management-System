package com.fullstack.service;

import java.util.List;

import com.fullstack.model.SeedCart;
import com.fullstack.model.SellerProduct;



public interface SellerProductService {

	public boolean insertProduct(SellerProduct product);
	
	public boolean updateProduct(SellerProduct product);
	public List<SellerProduct> findAllProduct();
	
	boolean deleteProduct(Long productId);
	public SellerProduct findProductyById(Long productId);

	
}
