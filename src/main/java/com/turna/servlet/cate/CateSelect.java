package com.turna.servlet.cate;

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
@WebServlet("/manager/admin_cateselect")
public class CateSelect extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 全部カテゴリを取得
		ArrayList<Category> catelist = CategoryDao.selectAll();
		// 値を設定する
		request.setAttribute("catelist", catelist);
		// 遷移先
		request.getRequestDispatcher("admin_cate.jsp").forward(request, response);
	}
}
