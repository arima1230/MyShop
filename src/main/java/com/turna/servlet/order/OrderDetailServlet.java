package com.turna.servlet.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turna.entity.Order;
import com.turna.service.OrderDao;

/**
 * @author nakauti
 */
@WebServlet("/manager/admin_order_detail")
public class OrderDetailServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 文字コードを設定する
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = req.getSession(true);
		
		// UserDsoをインスタンス化する
			OrderDao dao = new OrderDao();
		// リクエストからユーザIDを取得する
			int id = Integer.parseInt(req.getParameter("order_id"));
		// リクエストのユーザIDを元に残りの情報ををDAOより取得する
			Order bean = new Order();
			bean = dao. getOrder(id);
			int order_id  = bean.getOrder_id();
			int user_id  = bean.getUser_id();
			int cart_id  = bean.getCart_id();
			String post_code = bean.getPostcode();
		    String adress =bean.getAdress();
			String building =bean.getBuilding();
		    String room_number= bean.getRoomnumber();
		    String pay_stutas = bean.getPay_status();
		    String deli_stutas = bean.getDeli_status();
					
		// セッションへユーザ情報をセットする
			session.setAttribute("order_id", order_id);
			session.setAttribute("user_id", user_id);
			session.setAttribute("cart_id", cart_id);
			session.setAttribute("post_code ",post_code );
			session.setAttribute("adress ",adress );
			session.setAttribute("building", building);
			session.setAttribute("room_number",room_number );
			session.setAttribute("pay_status",pay_stutas );
			session.setAttribute("deli_status",deli_stutas );
			
			
		// 画面の遷移先
		req.getRequestDispatcher("/manager/admin_order_detail.jsp").forward(req, res);
	}
}