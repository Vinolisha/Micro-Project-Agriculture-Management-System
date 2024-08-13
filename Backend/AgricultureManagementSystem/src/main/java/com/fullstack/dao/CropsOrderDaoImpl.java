package com.fullstack.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fullstack.model.CropsOrder;

import jakarta.persistence.EntityManager;

@Repository
public class CropsOrderDaoImpl implements CropsOrderDao {

	@Autowired
	private EntityManager entity;

	@Override
	public String addOrder(CropsOrder order) {
		String msg="";
		try {
		entity.persist(order);
		return msg="Inserted Success";
		}catch(Exception e) {
			return msg="Inserted failure";
		}

	}


	@Override
	public CropsOrder findOrderById(Long orderId) {
		Query<CropsOrder> qrery = (Query<CropsOrder>) entity.createQuery("from CropsOrder where orderId=:id");
		qrery.setParameter("id", orderId);
		return qrery.getSingleResult();	}

	@Override
	public String updateOrder(CropsOrder order) {
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
		CropsOrder order = entity.find(CropsOrder.class, orderId);
		try {
			entity.remove(order);
			return msg="deletion success";
		}catch(Exception e) {
			return msg="deletion failure";
		}
	}

	@Override
	public List<CropsOrder> listAllOrder() {
		List<CropsOrder> orderList =  entity.createQuery("from CropsOrder").getResultList();
		return orderList;

	}

}
