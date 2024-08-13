package com.fullstack.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fullstack.model.SeedOrder;

import jakarta.persistence.EntityManager;

@Repository
public class SeedOrderDaoImpl implements SeedOrderDao{

	@Autowired
	private EntityManager entity;
	
	@Override
	public String addOrder(SeedOrder order) {
		String msg="";
		try {
		entity.persist(order);
		return msg="Inserted Success";
		}catch(Exception e) {
			return msg="Inserted failure";
		}
	}

	@Override
	public SeedOrder findOrderById(Long orderId) {
		Query<SeedOrder> qrery = (Query<SeedOrder>) entity.createQuery("from CropsOrder where orderId=:id");
		qrery.setParameter("id", orderId);
		return qrery.getSingleResult();	
		}
	

	@Override
	public String updateOrder(SeedOrder order) {
		String msg="";
		try {
			entity.merge(order);
			return msg="updation successfull";
		}catch(Exception e) {
			return msg="updation failure";
		}
	}

	@Override
	public String deleteOrder(Long orderId) {
		String msg="";
		SeedOrder order = entity.find(SeedOrder.class, orderId);
		try {
			entity.remove(order);
			return msg="deletion success";
		}catch(Exception e) {
			return msg="deletion failure";
		}
	}

	@Override
	public List<SeedOrder> listAllOrder() {
		List<SeedOrder> orderList =  entity.createQuery("from SeedOrder").getResultList();
		return orderList;
	}

}
