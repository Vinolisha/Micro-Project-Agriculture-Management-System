package com.fullstack.dao;

import java.util.List;

import com.fullstack.model.CropsOrder;


public interface CropsOrderDao {
	
	public String addOrder(CropsOrder order);
	public CropsOrder findOrderById(Long orderId);
	public String updateOrder(CropsOrder order);
	public String deleteOrder(Long productId);
	public List<CropsOrder> listAllOrder();
}
