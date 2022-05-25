package com.turna.servlet.item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turna.entity.Item;
import com.turna.service.ItemDao;

/**
 *  @author fu.zhirao
 */
@WebServlet("/manager/admin_toitemdel")
public class ToItemDel extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字コードを設定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));

		// idによりDBから探す
		Item item = ItemDao.selectById(id);
		// 値を設定する
		request.setAttribute("item", item);
		// 遷移先
		request.getRequestDispatcher("admin_itemdel.jsp").forward(request, response);
	}
}
