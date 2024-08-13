package com.fullstack.service;

import java.util.List;

import com.fullstack.model.FarmerProduct;

public interface FarmerProductService {
	
		public boolean insertProduct(FarmerProduct product);
		public boolean updateProduct(FarmerProduct product);
		public List<FarmerProduct> findAllProduct();
		
		boolean deleteProduct(Long productId);
		public FarmerProduct findProductyById(Long productId);
		
		
}
