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
@WebServlet("/manager/admin_docateupdate")
public class DoCateUpdate extends HttpServlet {
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
		int id = Integer.parseInt(request.getParameter("id"));
		int pid = Integer.parseInt(request.getParameter("parentId"));
		String name = request.getParameter("className");
		
		if( name != "") {
		// インスタンス化
		Category cate = new Category(id, name, pid);
		// DBに入れる
		CategoryDao.update(cate);
		}else{
			request.setAttribute("a", "a");
			Category cate = CategoryDao.selectById(id);
			// 全部カテゴリを取得
			ArrayList<Category> catelist = CategoryDao.selectAll();
			// 値を設定する
			request.setAttribute("catelist", catelist);
			request.setAttribute("cate1", cate);
			RequestDispatcher rd = request.getRequestDispatcher("admin_catemodify.jsp");
			rd.forward(request, response);
			
		}
		// 遷移先
		response.sendRedirect("admin_cateselect");
	}
}
