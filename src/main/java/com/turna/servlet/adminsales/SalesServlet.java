package com.turna.servlet.adminsales;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turna.entity.SalesBean;
import com.turna.service.SalesDao;


public class SalesServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 文字コードを設定する
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = req.getSession(true);
		
	if(req.getParameter("submit").equals("検索")) {
		String create_at = (String)req.getParameter("create_at");
		
		//DAOのインスタンス化
		SalesDao dao = new SalesDao();
		
		//リクエストにDAOで取得した情報をセットする
		ArrayList<SalesBean> list1 = dao.getDate(req.getParameter("date"));
		ArrayList<SalesBean> list2 = dao.getTotal(req.getParameter("date"));
		
		int total = 0;
		for(int i = 0; i < list2.size(); i++){
			total += list2.get(i).getTotal_price();
		}
		
		
		req.setAttribute("list1", dao.getDate(null));
		req.setAttribute("total", total);
		
		RequestDispatcher rd = req.getRequestDispatcher("/manager/admin_sales_details.jsp");
	    rd.forward(req, res);
	    
		}
		
	}
}