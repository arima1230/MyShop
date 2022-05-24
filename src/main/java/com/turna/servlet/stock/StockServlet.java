package com.turna.servlet.stock;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turna.service.StockDao;


public class StockServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 文字コードを設定する
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = req.getSession(true);
		
		//DAOのインスタンス化
		StockDao dao = new StockDao();
		//リクエストにDAOで取得した情報をセットする
		req.setAttribute("list", dao.selectAll());
		
		RequestDispatcher rd = req.getRequestDispatcher("/manager/admin_stock.jsp");
	    rd.forward(req, res);
		

	}
}
