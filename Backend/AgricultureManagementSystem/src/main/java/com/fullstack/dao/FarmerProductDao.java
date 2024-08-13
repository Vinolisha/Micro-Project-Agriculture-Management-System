package com.fullstack.dao;

import java.util.List;

import com.fullstack.model.FarmerProduct;

public interface FarmerProductDao {
	
		public String addProduct(FarmerProduct product);
		public FarmerProduct findProductById(Long productId);
		public String updateProduct(FarmerProduct product);
		public String deleteProduct(Long productId);
		public List<FarmerProduct> listAllProduct();
		
		
	
}
