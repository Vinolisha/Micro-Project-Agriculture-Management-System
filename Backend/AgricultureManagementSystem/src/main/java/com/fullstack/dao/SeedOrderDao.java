package com.fullstack.dao;

import java.util.List;
import com.fullstack.model.SeedOrder;

public interface SeedOrderDao {
	
	
	public String addOrder(SeedOrder order);
	public SeedOrder findOrderById(Long orderId);
	public String updateOrder(SeedOrder order);
	public String deleteOrder(Long productId);
	public List<SeedOrder> listAllOrder();

}
