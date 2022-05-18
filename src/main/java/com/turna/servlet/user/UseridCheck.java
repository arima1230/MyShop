package com.turna.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turna.service.UserDao;

/**
 * @author fu.zhirao
 */
@WebServlet("/useridcheck")
public class UseridCheck extends HttpServlet {

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

		String nameid = request.getParameter("name");

		int count = UserDao.selectById(nameid);

		PrintWriter out = response.getWriter();
		if (count > 0) {
			out.print("false");
		} else {

			out.print("true");

		}

	}

}
