package com.turna.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turna.entity.User;
import com.turna.service.UserDao;

@WebServlet("/detuserservlet")
public class DetUserServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		// 文字コードを設定する
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = req.getSession(true);
		// UserDaoをインスタンス化する
			UserDao dao = new UserDao();
		// リクエストからユーザIDを取得する
			int user_id = Integer.parseInt(req.getParameter("user_id"));
		// リクエストのユーザIDを元に残りの情報ををDAOより取得する
			User bean = new User();
			bean = dao. getUser(user_id);
			String name = bean.getUser_name();
			String kana = bean.getKana();
			String post_code = bean.getPostcode();
		    String adress =bean.getAdress();
			String building =bean.getBuilding();
		    String room_number= bean.getRoomnumber();
		    String phone_number = bean.getPhonenumber();
			String email = bean.getEmail();	
					
		// セッションへユーザ情報をセットする
			session.setAttribute("user_id", user_id);
			session.setAttribute("user_name", name);
			session.setAttribute("kana ",kana );
			session.setAttribute("post_code ",post_code );
			session.setAttribute("adress ",adress );
			session.setAttribute("building", building);
			session.setAttribute("room_number",room_number );
			session.setAttribute("phone_number ",phone_number );
			session.setAttribute("email ",email );
			
			
		// 画面の遷移先
			RequestDispatcher rd = req.getRequestDispatcher("/manager/admin_user_detail.jsp");
			rd.forward(req, res);
	}

}

