package com.turna.servlet.item;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turna.entity.Item;
import com.turna.service.ItemDao;

/**
 * @author fu.zhirao
 */
@WebServlet("/manager/admin_itemselect")
public class ItemSelect extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 全部カテゴリを取得
				ArrayList<Item> itemlist = ItemDao.selectAll();
				// 値を設定する
				request.setAttribute("itemlist", itemlist);
				// 遷移先
				request.getRequestDispatcher("admin_item.jsp").forward(request, response);
	}
}
