package com.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.dao.CropsOrderDao;
import com.fullstack.model.CropsOrder;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CropsOrderServiceImpl implements CropsOrderService{

	@Autowired
	CropsOrderDao dao;
	
	@Override
	public boolean insertOrder(CropsOrder order) {
		this.dao.addOrder(order);
		   return true;
	}

	@Override
	public boolean updateOrder(CropsOrder order) {
		dao.updateOrder(order);
		return true;
	}

	@Override
	public List<CropsOrder> findAllOrder() {
		return this.dao.listAllOrder();
	}

	@Override
	public boolean deleteOrder(Long orderId) {
		dao.deleteOrder(orderId);
		return true;
	}

	@Override
	public CropsOrder findOrderById(Long orderId) {
		return dao.findOrderById(orderId);
		 
	}

}
