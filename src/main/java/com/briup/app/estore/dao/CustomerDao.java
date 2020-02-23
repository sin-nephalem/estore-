package com.briup.app.estore.dao;

import com.briup.app.estore.bean.Customer;

public interface CustomerDao {
	void saveCustomer(Customer customer);
	Customer findByName(String name);
}
