package com.briup.app.estore.dao;

import java.util.List;

import com.briup.app.estore.bean.Book;

public interface BookDao {
	List<Book> findAll();
	Book findById(Integer id);
}
