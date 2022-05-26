package com.turna.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turna.service.UserGetDao;


@WebServlet("/DoUserGetServlet")
public class DoUserGetServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		HttpSession session = request.getSession(true);
		
		// String user_id = (String)session.getAttribute("user_id");
		 String location = null;
		 
		 //if(user_id == null){
			// location = "Login";//ログイン画面へのパスの記述をする
		// }else {
		String user_id = "8";//テスト用
		
		session.setAttribute("user_id", user_id);
		UserGetDao dao = new UserGetDao();
		session.setAttribute("account_name", dao.get_account_name(user_id));
		session.setAttribute("user_name", dao.get_user_name(user_id));
		session.setAttribute("kana", dao.get_kana(user_id));
		session.setAttribute("pass", dao.get_pass(user_id));
		session.setAttribute("sex", dao.get_sex(user_id));
		session.setAttribute("birthday", dao.get_birthday(user_id));
		session.setAttribute("email", dao.get_email(user_id));
		session.setAttribute("phone_number", dao.get_phone_number(user_id));
		session.setAttribute("post_code", dao.get_post_code(user_id));
		session.setAttribute("adress", dao.get_adress(user_id));
		session.setAttribute("building", dao.get_building(user_id));
		session.setAttribute("room_number", dao.get_room_number(user_id));
		
		//request.setAttribute("message","変更しました");//テスト用
		
		location = "shop/jsp/user_edit.jsp";//登録情報画面へのパスの記述をする
		 //}
		RequestDispatcher rd = request.getRequestDispatcher(location);
		rd.forward(request, response);
	}
}
