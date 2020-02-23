package com.briup.app.estore.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.dao.BookDao;
import com.briup.app.estore.mapper.BookMapper;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class BookDaoImpl implements BookDao {

	@Override
	public List<Book> findAll() {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		List<Book> list = mapper.selectAll();
		return list;
	}

	@Override
	public Book findById(Integer id) {
		SqlSession session = MyBatisSqlSessionFactory.openSession(true);
		BookMapper mapper = session.getMapper(BookMapper.class);
		Book book = mapper.selectByPrimaryKey(id);
		return book;
	}
	
}
