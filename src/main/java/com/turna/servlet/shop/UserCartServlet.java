package com.turna.servlet.shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		if((int)(session.getAttribute("count")) == 0) {
			CartDao dao = new CartDao(); 
			session.setAttribute("count", dao.createCart());
			int a = (int)(session.getAttribute("item_id"));
			int b = Integer.parseInt(req.getParameter("stock"));
			System.out.println(a);
			System.out.println(b);
		}
	}
}


