package com.briup.app.estore.service.impl;

import com.briup.app.estore.bean.Order;
import com.briup.app.estore.dao.impl.OrderDaoImpl;
import com.briup.app.estore.service.IOrderService;
import com.briup.app.estore.shoppingcart.ShoppingCart;

public class OrderServiceImpl implements IOrderService {

	@Override
	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		OrderDaoImpl odi = new OrderDaoImpl();
		odi.saveOrder(order);
	}

}
