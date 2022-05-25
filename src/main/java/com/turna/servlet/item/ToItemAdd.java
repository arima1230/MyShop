package com.turna.servlet.item;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turna.entity.Category;
import com.turna.service.CategoryDao;
/**
 * @author fu.zhirao
 */
@WebServlet("/manager/admin_toitemadd")
public class ToItemAdd extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Category> plist = CategoryDao.selectCat("father");
		request.setAttribute("plist", plist);
		ArrayList<Category> clist = CategoryDao.selectCat("child");
		request.setAttribute("clist", clist);

		request.getRequestDispatcher("admin_itemadd.jsp").forward(request, response);
	}
}
