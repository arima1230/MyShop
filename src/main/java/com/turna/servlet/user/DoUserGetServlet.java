package com.turna.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turna.service.UserChangeGetDao;


@WebServlet("/DoUserGetServlet")
public class DoUserGetServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("shop/jsp/.jsp");//shophomeから
		rd.forward(request, response);

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		HttpSession session = request.getSession(true);
		
		 String user_id = (String)session.getAttribute("user_id");
		 String location = null;
		 
		 if(user_id == null){
			 location = "Login";//ログイン画面へのパスの記述をする
		 }else {
		session.setAttribute("user_id", user_id);
		UserChangeGetDao dao = new UserChangeGetDao();
		request.setAttribute("account_name", dao.get_account_name(user_id));
		request.setAttribute("user_name", dao.get_user_name(user_id));
		
		
		location = "Change of Information";//登録情報画面へのパスの記述をする
		 }
		
		
		RequestDispatcher rd = request.getRequestDispatcher(location);//変更画面"shop/jsp/.jsp"
		rd.forward(request, response);
	}
}
