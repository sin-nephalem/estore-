package com.briup.app.estore.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.dao.CustomerDao;
import com.briup.app.estore.dao.impl.CustomerDaoImpl;
import com.briup.app.estore.mapper.CustomerMapper;
import com.briup.app.estore.service.ICustomerService;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class CustomerServiceImpl implements ICustomerService{

	@Override
	public void register(Customer customer) throws Exception{
		// TODO Auto-generated method stub
		CustomerDao customerDaoImpl = new CustomerDaoImpl();
		
		Customer name = customerDaoImpl.findByName(customer.getName());
		if(name!=null)
		{
			throw new Exception("该用户已存在："+name.getName());
		}
		customerDaoImpl.saveCustomer(customer);
	}

	@Override
	public Customer login(String name, String password) throws Exception {
		// TODO Auto-generated method stub
		CustomerDao customerDao = new CustomerDaoImpl();

		Customer selectByName = customerDao.findByName(name);
		if(selectByName == null)
		{
			throw new Exception("该用户不存在，登录前请先注册");
		}
		if(password.equals(selectByName.getPassword()))
			return selectByName;
		else
			throw new Exception("密码不正确");
			
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		mapper.updateByPrimaryKey(customer);
	}

}
