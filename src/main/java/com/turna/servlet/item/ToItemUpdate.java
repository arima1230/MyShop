package com.turna.servlet.item;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turna.entity.Category;
import com.turna.entity.Item;
import com.turna.service.CategoryDao;
import com.turna.service.ItemDao;

/**
 * @author fu.zhirao
 */
@WebServlet("/manager/admin_toitemupdate")
public class ToItemUpdate extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字コードを設定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		ArrayList<Category> plist = CategoryDao.selectCat("father");
		request.setAttribute("plist", plist);
		ArrayList<Category> clist = CategoryDao.selectCat("child");
		request.setAttribute("clist", clist);

		int id = Integer.parseInt(request.getParameter("id"));

		// idによりDBから探す
		Item it = ItemDao.selectById(id);
		// 値を設定する
		request.setAttribute("item", it);
		// 遷移先
		request.getRequestDispatcher("admin_itemmodify.jsp").forward(request, response);
	}

}
