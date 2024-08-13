package com.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.dao.SeedOrderDao;
import com.fullstack.model.CropsOrder;
import com.fullstack.model.SeedCart;
import com.fullstack.model.SeedOrder;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SeedOrderServiceImpl implements SeedOrderService{

	@Autowired
	SeedOrderDao dao;

	@Override
	public boolean insertOrder(SeedOrder order) {
		this.dao.addOrder(order);
		   return true;
	}

	@Override
	public boolean updateOrder(SeedOrder order) {
		dao.updateOrder(order);
		return true;
	}

	@Override
	public List<SeedOrder> findAllOrder() {
		return this.dao.listAllOrder();
	}

	@Override
	public boolean deleteOrder(Long orderId) {
		dao.deleteOrder(orderId);
		return true;
	}

	@Override
	public SeedOrder findOrderById(Long orderId) {
		return dao.findOrderById(orderId);
	}
	
	

}
