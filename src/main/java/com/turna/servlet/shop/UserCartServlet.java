package com.turna.servlet.shop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turna.entity.Cart;
import com.turna.service.CartDao;

/**
 * Servlet implementation class UserCartServlet
 */
@WebServlet("/UserCartServlet")
public class UserCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession(true);
			CartDao dao = new CartDao(); 
			session.setAttribute("count", dao.createCart());
			int item_id = (int)(session.getAttribute("item_id"));
			String item_name = String.valueOf(session.getAttribute("item_name"));
			int price = (int)(session.getAttribute("price"));
			String image_path = String.valueOf(session.getAttribute("image_path"));
			int stock = Integer.parseInt(req.getParameter("stock"));
			System.out.println(item_id);
			System.out.println(item_name);
			System.out.println(price);
			System.out.println(image_path);
			ArrayList<Cart> list = new ArrayList<Cart>();
			Cart bean = new Cart();
			bean.setImage_path(image_path);
			bean.setItem_id(item_id);
			bean.setItem_name(item_name);
			bean.setPrice(price);
			bean.setStock(stock);
			list.add(bean);
			for(int i = 0 ; i < list.size() ; i++){
				System.out.println( list.get(i).getItem_name());
			}
			
	}
}

