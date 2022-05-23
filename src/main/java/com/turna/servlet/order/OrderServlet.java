package com.turna.servlet.order;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turna.service.UserDao;

@WebServlet("/manager/admin_user")
public class OrderServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// DAOをインスタンス化する
		UserDao dao = new UserDao();
		// リクエストにDAOで取得したユーザ情報をセットする
		req.setAttribute("list", dao.getUserList());

		RequestDispatcher rd = req.getRequestDispatcher("admin_order.jsp");
		rd.forward(req, res);
	}
}
