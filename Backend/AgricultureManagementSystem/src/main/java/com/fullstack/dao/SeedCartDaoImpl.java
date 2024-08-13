package com.fullstack.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fullstack.model.Cart;
import com.fullstack.model.SeedCart;
import com.fullstack.model.SellerProduct;

import jakarta.persistence.EntityManager;

@Repository
public class SeedCartDaoImpl implements SeedCartDao{
	
	@Autowired
	private EntityManager entity;
	

	@Override
	public SeedCart findCartById(Long cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCart(SeedCart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteOrder(Long cartId) {
		String msg = "";
		SeedCart cart = entity.find(SeedCart.class, cartId);
		try {
			entity.remove(cart);
			return msg = "deletion success";
		} catch (Exception e) {
			return msg = "deletion failure";
		}
	}

	@Override
	public List<SeedCart> listAllCart() {

		List<SeedCart> cartList = entity.createQuery("from SeedCart").getResultList();
		return cartList;

	}

	@Override
	public void insertCart(SeedCart cart) {
		System.err.println(cart);
		try {
			entity.persist(cart);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean validateCart(SeedCart cart) {
		try {
			SellerProduct sellerProduct = cart.getSellerProduct();
			long prodId = sellerProduct.getProductId();
			Query<SeedCart> query = (Query<SeedCart>) entity.createQuery("FROM SeedCart as cart where cart.sellerProduct.productId=:id");
			query.setParameter("id", prodId);
			SeedCart cart1 = query.getSingleResult();
			return true;
			
			}catch (Exception e) {
				return false;
			}

}
}
