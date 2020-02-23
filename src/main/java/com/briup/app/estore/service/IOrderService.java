package com.briup.app.estore.service;

import com.briup.app.estore.bean.Order;
import com.briup.app.estore.shoppingcart.ShoppingCart;

public interface IOrderService {
	
	void saveOrder(Order order);
	
}
