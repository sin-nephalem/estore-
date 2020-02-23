package com.briup.app.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.service.impl.CustomerServiceImpl;
import com.briup.app.estore.shoppingcart.ShoppingCart;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		CustomerServiceImpl customerservice = new CustomerServiceImpl();
		ShoppingCart sc = new ShoppingCart();
		try {
				Customer login = customerservice.login(name, password);
				HttpSession session = request.getSession();
				session.setAttribute("customer", login);
				session.setAttribute("shoppingCart", sc);
				String path = request.getContextPath()+"/index.jsp";
				response.sendRedirect(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String url = "/login.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}
		
	}

}
