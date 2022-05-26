package com.turna.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turna.service.UserAccountNameCheckDao;
import com.turna.service.UserEditDao;

@WebServlet("/DoUserEdit")
public class DoUserEditServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		HttpSession session = request.getSession(true);
		
		String user_id = (String)session.getAttribute("user_id");
		System.out.print(user_id);
		String account_name = (String)request.getParameter("account_name");
		//System.out.print(account_name);
		String user_name = (String)request.getParameter("user_name");
		//System.out.print(user_name);
		String kana = (String)request.getParameter("kana");
		//System.out.print(kana);
		String pass = (String)request.getParameter("pass");
		//System.out.print(pass);
		String birthday = (String)request.getParameter("birthday");
		//System.out.print(birthday);
		String sex = (String)request.getParameter("sex");
		//System.out.print(sex);
		String email = (String)request.getParameter("email");
		//System.out.print(email);
		String phone_number = (String)request.getParameter("phone_number");
		//System.out.print(phone_number);
		String post_code = (String)request.getParameter("post_code");
		//System.out.print(post_code);
		String adress = (String)request.getParameter("adress");
		//System.out.print(adress);
		String building = (String)request.getParameter("building");
		//System.out.print(building);
		String room_number = (String)request.getParameter("room_number");
		//System.out.print(room_number);
		
		session.setAttribute("user_id", user_id);
		
		session.setAttribute("account_name", account_name);
		session.setAttribute("user_name", user_name);
		session.setAttribute("user_name", kana);
		session.setAttribute("pass", pass);
		session.setAttribute("sex", sex);
		session.setAttribute("birthday", birthday);
		session.setAttribute("email", email);
		session.setAttribute("phone_number", phone_number);
		session.setAttribute("post_code", post_code);
		session.setAttribute("adress", adress);
		session.setAttribute("building", building);
		session.setAttribute("room_number", room_number);
		
		UserAccountNameCheckDao dao1 = new UserAccountNameCheckDao();
		String flag = dao1.Check(account_name);
		String location ="shop/jsp/user_edit.jsp";
		if(flag != null) {
			request.setAttribute("message1","このアカウントは使えません");
			System.out.print(8451);
		}else {	
		request.setAttribute("message","変更しました");
		
		UserEditDao dao = new UserEditDao();
		//dao.Edit(account_name, user_name, kana, pass, sex, birthday, email, phone_number, post_code, adress, building, room_number, user_id);
		dao.Editaccount_name(account_name, user_id);
		dao.Edituser_name(user_name, user_id);
		dao.Editkana(kana, user_id);
		dao.Editpass(pass, user_id);
		dao.Editsex(sex, user_id);
		dao.Editbirthday(birthday, user_id);
		dao.Editemail(email, user_id);
		dao.Editphone_number(phone_number, user_id);
		dao.Editpost_code(post_code, user_id);
		dao.Editadress(adress, user_id);
		dao.Editbuilding(building, user_id);
		dao.Editroom_number(room_number, user_id);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(location);
		rd.forward(request, response);
	}
}

