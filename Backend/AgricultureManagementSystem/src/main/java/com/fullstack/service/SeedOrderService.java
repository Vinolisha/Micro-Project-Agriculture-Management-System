package com.fullstack.service;

import java.util.List;

import com.fullstack.model.SeedOrder;



public interface SeedOrderService {
	
	public boolean insertOrder(SeedOrder order);
	public boolean updateOrder(SeedOrder order);
	public List<SeedOrder> findAllOrder();	
	boolean deleteOrder(Long orderId);
	SeedOrder findOrderById(Long orderId);

}
