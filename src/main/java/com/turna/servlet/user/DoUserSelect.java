package com.turna.servlet.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turna.entity.User;
import com.turna.service.UserDao;

/**
 * @author fu.zhirao
 */
@WebServlet("/manager/admin_douserselect")
public class DoUserSelect extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 文字コードを設定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// ユーザ情報取得
		ArrayList<User> list = UserDao.selectAll();

		// 値を設定する
		request.setAttribute("userlist", list);

		// 画面の遷移先
		request.getRequestDispatcher("/manager/admin_user.jsp").forward(request, response);
	}

}
