package com.briup.app.estore.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Order;
import com.briup.app.estore.dao.OrderDao;
import com.briup.app.estore.mapper.OrderMapper;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		OrderMapper mapper = session.getMapper(OrderMapper.class);
		mapper.insert(order);
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		OrderMapper mapper = session.getMapper(OrderMapper.class);
		List<Order> list = mapper.selectAll();
		return list;
	}

}
