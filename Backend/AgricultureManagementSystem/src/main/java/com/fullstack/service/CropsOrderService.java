package com.fullstack.service;

import java.util.List;

import com.fullstack.model.CropsOrder;

public interface CropsOrderService {

	public boolean insertOrder(CropsOrder order);
	public boolean updateOrder(CropsOrder order);
	public List<CropsOrder> findAllOrder();
	
	boolean deleteOrder(Long orderId);
	CropsOrder findOrderById(Long orderId);
	
}
