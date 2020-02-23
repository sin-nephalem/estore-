package com.briup.app.estore.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.dao.CustomerDao;
import com.briup.app.estore.mapper.CustomerMapper;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		mapper.insert(customer);
	}

	@Override
	public Customer findByName(String name) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		Customer selectByName = mapper.selectByName(name);
		return selectByName;
	}

}
