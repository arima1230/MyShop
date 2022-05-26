package com.turna.servlet.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turna.entity.Order;
import com.turna.service.OrderDao;

@WebServlet("/manager/admin_order_day")
public class OrderDayServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// コンテンツタイプの設定
		res.setContentType("text/html; charset=UTF-8");
		HttpSession session = req.getSession(true);
	
		// DAOをインスタンス化する
		OrderDao dao = new OrderDao();
		// 入力データの取得
		String select = req.getParameter("select_day");
		// リクエストの日付を元に注文番号、発送ステータス、入金ステータスをDAOより取得する
		Order bean = new Order();
		bean = dao.getOrder(select);
		int order_id = bean.getOrder_id();
		String deli_status = bean.getDeli_status();
		String pay_status = bean.getPay_status();

		// セッションへユーザ情報をセットする
		session.setAttribute("order_id", order_id);
		session.setAttribute("deli_status", deli_status);
		session.setAttribute("pay_status", pay_status);

		RequestDispatcher rd = req.getRequestDispatcher("admin_order_day.jsp");
		rd.forward(req, res);
	}
}
