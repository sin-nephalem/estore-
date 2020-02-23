package com.briup.app.estore.dao;

import java.util.List;

import com.briup.app.estore.bean.Order;

public interface OrderDao {
	
	void saveOrder(Order order);
	List<Order> findAll();
}
