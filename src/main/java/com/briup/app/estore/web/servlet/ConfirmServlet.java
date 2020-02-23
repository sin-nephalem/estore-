package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Order;
import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.dao.CustomerDao;
import com.briup.app.estore.dao.impl.CustomerDaoImpl;
import com.briup.app.estore.service.ICustomerService;
import com.briup.app.estore.service.IOrderService;
import com.briup.app.estore.service.impl.CustomerServiceImpl;
import com.briup.app.estore.service.impl.OrderServiceImpl;
import com.briup.app.estore.shoppingcart.ShoppingCart;

/**
 * Servlet implementation class ConfirmServlet
 */
@WebServlet("/ConfirmServlet")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ICustomerService cs = new CustomerServiceImpl();
		IOrderService os = new OrderServiceImpl();
		
		try {
			
			Customer customer = (Customer)request.getAttribute("customer");
			ShoppingCart sc = (ShoppingCart)request.getAttribute("shoppingCart");
			if(request.getParameter("name")!=null)
			{
				customer.setName(request.getParameter("name"));
				if(request.getParameter("password").equals(request.getParameter("password2")))
				{
					System.out.println("两次密码不一致");
					String location = request.getContextPath()+"userinfo.jsp";
					response.sendRedirect(location );
				}
				customer.setPassword(request.getParameter("password2"));
				customer.setAddress(request.getParameter("address"));
				customer.setZip(request.getParameter("zip"));
				customer.setTelephone(request.getParameter("telephone"));
				customer.setEmail(request.getParameter("email"));		
			}
			
			Order order = new Order();
			order.setCost(sc.getCost());
			order.setCustomer(customer);
			Map<Integer, Orderline> lines = sc.getLines();
			List<Orderline> list = new ArrayList<Orderline>();
			for(Integer key:lines.keySet()) {
				Orderline orderline = lines.get(key);
				list.add(orderline);
			}
			order.setOrderlines(list);
			order.setOrderdate(new Date());
			
			cs.update(customer);
			os.saveOrder(order);
			
			String location = request.getContextPath()+"/index.jsp";
			response.sendRedirect(location );
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			String location = request.getContextPath()+"/confirmOrder.jsp";
			response.sendRedirect(location);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
