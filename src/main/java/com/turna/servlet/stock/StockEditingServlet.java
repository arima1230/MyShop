package com.turna.servlet.stock;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turna.entity.StockBean;
import com.turna.service.StockDao;

public class StockEditingServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 文字コードを設定する
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = req.getSession(true);

	if(req.getParameter("submit").equals("編集")) {
		String item_code = (String)req.getParameter("item_code");
//		String item_name =(String)req.getParameter("item_name");
//		int stock = Integer.parseInt(req.getParameter("stock"));
		
		StockDao dao = new StockDao();
		StockBean bean = new StockBean();
		bean = dao.getItems(item_code);
		String item_name = bean.getItem_name();
		int stock = bean.getStock();
		
		session.setAttribute("item_code",item_code);
		session.setAttribute("item_name",item_name);
		session.setAttribute("stock",stock);
		
		RequestDispatcher rd = req.getRequestDispatcher("/manager/admin_stock_editing.jsp?no=1");
	    rd.forward(req, res);
		}
	
	if(req.getParameter("submit").equals("登録")) {
		String item_code = (String) session.getAttribute("item_code");
		//String item_name = (String) session.getAttribute("item_name");
		int stock = Integer.parseInt(req.getParameter("stock"));
		
		
		//DAOをインスタンス化
		StockDao dao = new StockDao();
		int rs = dao.update(stock, item_code);
		req.setAttribute("update", rs);
		
		session.setAttribute("item_code", session.getAttribute("item_code"));
		session.setAttribute("item_name", session.getAttribute("item_name"));
		session.setAttribute("stock", req.getParameter("stock"));
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/manager/admin_stock_editing.jsp?no=2");
		rd.forward(req, res);
		
	}
	}
}