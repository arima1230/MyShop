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
@WebServlet("/manager/admin_doitemdel")
public class DoItemDel extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字コードを設定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");


		// パラメターを取得
		String id = request.getParameter("itemId");
		String icode = request.getParameter("itemCode");
		String iname = request.getParameter("itemName");
		String pid = request.getParameter("parentId");
		String fname = request.getParameter("photo");
		String price = request.getParameter("itemPrice");
		String desc = request.getParameter("itemDesc");
		String stock = request.getParameter("itemStock");
		String def = request.getParameter("deleteFlag");

		int deleteflag = 0;
		if (def != null) {
			deleteflag = Integer.parseInt(def);
		}

		// Itemをインスタンス化
		Item item = new Item(
				Integer.parseInt(id), 
				Integer.parseInt(icode), 
				iname,
				Integer.parseInt(price),
				Integer.parseInt(pid.split("-")[0]),
				desc,
				Integer.parseInt(stock), 
				fname, 
				deleteflag);

		// DBに入れる
		int count = ItemDao.del(item);

		// 遷移先
		if (count > 0) {
			response.sendRedirect("admin_itemselect");
		} 
	}
}
