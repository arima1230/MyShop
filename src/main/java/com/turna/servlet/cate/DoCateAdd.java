package com.turna.servlet.cate;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/manager/admin_docateadd")
public class DoCateAdd extends HttpServlet {
	private static final String String = null;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字コードを設定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// パラメターを取得
		int pid = Integer.parseInt(request.getParameter("parentId"));
		String name = request.getParameter("className");
		// インスタンス化
		if( name != "") {
		Category cate = new Category(0, name, pid);
		// DBに入れる
		CategoryDao.insert(cate);
		}else {
			request.setAttribute("a", "a");
			// 全部カテゴリを取得
			ArrayList<Category> catelist = CategoryDao.selectAll();
			// 値を設定する
			request.setAttribute("catelist", catelist);
			RequestDispatcher rd = request.getRequestDispatcher("admin_cate.jsp");
			rd.forward(request, response);
		}
		// 遷移先
		response.sendRedirect("admin_cateselect");
	}

}
