package com.turna.servlet.shop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turna.service.ItemDao;

/**
 * Servlet implementation class user_item_details_servlet
 */
@WebServlet("/UserItemDetailsServlet")
public class UserItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req , res );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		ItemDao dao = new ItemDao();
		//ここでトップから送られてきたIDを受け取る
		int item_id = 1;
		req.setAttribute("list", dao.getItemDetail(item_id));
		RequestDispatcher rd  = req.getRequestDispatcher("shop/jsp/UserItemDetails.jsp");
		rd.forward(req, res);
	}

}