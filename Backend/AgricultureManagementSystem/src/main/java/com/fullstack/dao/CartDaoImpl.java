package com.fullstack.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fullstack.model.Cart;
import com.fullstack.model.CropsOrder;
import com.fullstack.model.Farmer;
import com.fullstack.model.FarmerProduct;

import jakarta.persistence.EntityManager;

import jakarta.persistence.EntityManager;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private EntityManager entity;

	@Override
	public boolean validateCart(Cart cart) {

		try {
			FarmerProduct farmerProduct = cart.getFarmerProduct();
			long productId = farmerProduct.getProductId();
			Query<Cart> query = (Query<Cart>) entity
					.createQuery("FROM Cart as ct  WHERE ct.farmerProduct.productId=:id");
			query.setParameter("id", productId);
			Cart cart1 = query.getSingleResult();

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Cart findCartById(Long cartId) {
		Query<Cart> qrery = (Query<Cart>) entity.createQuery("from Cart where cartId=:id");
		qrery.setParameter("id", cartId);
		return qrery.getSingleResult();

	}

	@Override
	public String updateCart(Cart cart) {
		String msg = "";
		try {
			entity.merge(cart);
			return msg = "updation successfull";
		} catch (Exception e) {
			return msg = "updation failure";
		}
	}

	@Override
	public String deleteOrder(Long cartId) {
		String msg = "";
		Query<Cart> query = (Query<Cart>) entity.createQuery("from Cart where CartId=:id");
		query.setParameter("id", cartId);
		Cart cart = query.getSingleResult();

		try {
			entity.remove(cart);
			return msg = "deletion success";
		} catch (Exception e) {
			return msg = "deletion failure";
		}
	}

	@Override
	public List<Cart> listAllCart() {

		List<Cart> cartList = entity.createQuery("from Cart").getResultList();
		return cartList;

	}

	@Override
	public void insertCart(Cart cart) {
		System.err.println(cart);
		try {
			entity.persist(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
