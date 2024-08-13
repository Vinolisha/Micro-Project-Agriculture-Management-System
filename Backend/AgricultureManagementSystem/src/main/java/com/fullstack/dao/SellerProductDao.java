package com.fullstack.dao;

import java.util.List;


import com.fullstack.model.SellerProduct;

public interface SellerProductDao {

	public String addProduct(SellerProduct product);
	public SellerProduct findProductById(Long productId);
	public String updateProduct(SellerProduct product);
	public String deleteProduct(Long productId);
	public List<SellerProduct> listAllProduct();
	

}
