package com.briup.app.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.service.ICustomerService;
import com.briup.app.estore.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		//1 接受请求中携带的的参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String zip = request.getParameter("zip");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		//2 把参数封装成对象（可选）
		Customer customer = new Customer();
		customer.setName(name);
		customer.setPassword(password);
		customer.setAddress(address);
		customer.setZip(zip);
		customer.setTelephone(telephone);
		customer.setEmail(email);
		//3 调用service层进行业务逻辑处理
		ICustomerService customerService = new CustomerServiceImpl();
		String page = "/login.jsp";
		String msg = "注册成功!请登录";
		try {
			customerService.register(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			page = "/register.jsp";
			msg = "注册失败"+e.getMessage();
			String url = "/register.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}		
		//4 根据service层方法的处理结果，选择适合的页面		
		HttpSession session = request.getSession();
		session.setAttribute(msg, "msg");
		String location =request.getContextPath()+"/login.jsp";
		response.sendRedirect(location);
	}

}
