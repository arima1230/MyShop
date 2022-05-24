package com.turna.servlet.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turna.service.UserInputDao;

@WebServlet("/DoUserInput")
public class DoUserInputServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("shop/jsp/user_register.jsp");
		rd.forward(request, response);

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset= UTF-8");
		HttpSession session = request.getSession(true);
		
		String account_name = (String)request.getParameter("account_name");
		System.out.print(account_name);
		String user_name = (String)request.getParameter("user_name");
		System.out.print(user_name);
		String kana = (String)request.getParameter("kana");
		System.out.print(kana);
		String pass = (String)request.getParameter("pass");
		System.out.print(pass);
		//String year = (String)request.getParameter("year");
		//String month = (String)request.getParameter("month");
		//String day = (String)request.getParameter("day");
		//System.out.print(year);
		//System.out.print(month);
		//System.out.print(day);
		//String birthday = (year + month + day);
		String birthday = (String)request.getParameter("birthday");
		System.out.print(birthday);
		
		String sex = (String)request.getParameter("sex");
		System.out.print(sex);
		String email = (String)request.getParameter("email");
		System.out.print(email);
		//String phone_number1 = (String)request.getParameter("phone_number1");
		//String phone_number2 = (String)request.getParameter("phone_number2");
		//String phone_number3 = (String)request.getParameter("phone_number3");
		//int  phone_number =Integer.parseInt(phone_number1 + phone_number2 + phone_number3);
		//String phone_number = (phone_number1 + phone_number2 + phone_number3);
		//int phone_number = Integer.parseInt(phone_number4);
		//System.out.print(phone_number);
		String phone_number = (String)request.getParameter("phone_number");
		System.out.print(phone_number);
		
		//String post_code1 = (String)request.getParameter("post_code1");
		//String post_code2 = (String)request.getParameter("post_code2");
		////int post_code =Integer.parseInt(post_code1 + post_code2);
		//String post_code = (post_code1 + post_code2);
		////int post_code = Integer.parseInt(post_code3);
		String post_code = (String)request.getParameter("post_code");
		System.out.print(post_code);
		
		
		String adress = (String)request.getParameter("adress");
		System.out.print(adress);
		String building = (String)request.getParameter("building");
		System.out.print(building);
		String room_number = (String)request.getParameter("room_number");
		System.out.print(room_number);
		
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
		
		UserInputDao dao = new UserInputDao();
		dao.input(account_name, user_name, kana, pass, sex, birthday, email, phone_number, post_code, adress, building, room_number);
		RequestDispatcher rd = request.getRequestDispatcher("shop/jsp/user_register.jsp");
		rd.forward(request, response);
	}
}
