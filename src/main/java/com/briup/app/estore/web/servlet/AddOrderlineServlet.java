package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.dao.BookDao;
import com.briup.app.estore.dao.impl.BookDaoImpl;
import com.briup.app.estore.shoppingcart.ShoppingCart;

/**
 * Servlet implementation class AddOrderlineServlet
 */
@WebServlet("/AddOrderlineServlet")
public class AddOrderlineServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
	BookDao bookDao = new BookDaoImpl();
		
		Customer customer = (Customer)req.getAttribute("customer");
		HttpSession session = req.getSession();
		ShoppingCart shoppingCart = null;
		if(null==session.getAttribute("shoppingCart"))
		{
			String location = req.getContextPath()+"/login.jsp";
			resp.sendRedirect(location );
		}
		else
		{
			shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
		}
		int bookid = Integer.parseInt(req.getParameter("book_id"));
		Orderline line = new Orderline();
		Book book = bookDao.findById(bookid);
		line.setBook(book);
		shoppingCart.add(line);
		session.setAttribute("shoppingCart", shoppingCart);
		
		String path =req.getContextPath()+"/index.jsp";
		resp.sendRedirect(path);
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
   
}
