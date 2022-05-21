package com.turna.servlet.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fu.zhirao
 */
@WebServlet("/manager/admin_cateselect")
public class OrderServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 全部カテゴリを取得
		ArrayList<Order> oderlist = OrderDao.selectAll();
		// 値を設定する
		request.setAttribute("orderlist", orderlist);
		// 遷移先
		request.getRequestDispatcher("admin_order.jsp").forward(request, response);
	}
}
