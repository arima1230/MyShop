package com.turna.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turna.entity.SHOP_USER;
import com.turna.service.SHOP_USERDao;

/**
 * Servlet implementation class DoUserAdd
 */
@WebServlet("/manager/admin_douseradd")
public class DoUserAdd extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 文字コードを設定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String userid = request.getParameter("userId");
		String name = request.getParameter("name");
		String pwd = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String year = request.getParameter("birthday");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		// インスタンス化
		SHOP_USER u = new SHOP_USER(userid, name, pwd, sex, year, null, email, phone, address, 1);

		// DBに入れる

		int count = SHOP_USERDao.insert(u);
		// System.out.print(u);
		// 成功/失敗によってforward

		if (count > 0) {
			response.sendRedirect("admin_douserselect");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('ユーザ追加失敗')");
			out.println("location.href='/MyShop/manager/admin_useradd.jsp'");
			out.println("</script>");
		}

	}

}
