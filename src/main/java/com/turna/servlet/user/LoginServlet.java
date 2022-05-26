package com.turna.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turna.service.UserLoginDao;

/**
 * @author fu.zhirao
 */
@WebServlet("/user/user_login")
public class LoginServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 文字コードを設定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String account_name = String.valueOf(request.getParameter("account_name"));
		String pass = request.getParameter("pass");
		System.out.println(account_name);
		System.out.println(pass);;
		UserLoginDao dao = new UserLoginDao();
		if(dao.checkAdmin(account_name, pass) == "ok") {
			RequestDispatcher rd = request.getRequestDispatcher("/manager/admin_menu.jsp");
			rd.forward(request, response);
			return;
		}else {
			String msg = "ユーザー名、またはパスワードが間違っています。";
			request.setAttribute("error", msg);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/shop/jsp/login.jsp");
		rd.forward(request, response);
	}

}
