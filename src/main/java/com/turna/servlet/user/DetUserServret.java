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

/**
 * @author nakauti
 */
@WebServlet("/manager/admin_detuserservlet")
public class DetUserServret extends HttpServlet {

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
			UserDao dao = new UserDao();
		// リクエストからユーザIDを取得する
			int id = Integer.parseInt(req.getParameter("user_id"));
		// リクエストのユーザIDを元に残りの情報ををDAOより取得する
			User bean = new User();
			bean = dao. getUser(id);
			String name = bean.getUser_name();
			String kana = bean.getKana();
			String postcode = bean.getPostcode();
		    String adress =bean.getAdress();
			String building =bean.getBuilding();
		    String roomnumber= bean.getRoomnumber();
		    String phonenumber = bean.getPhonenumber();
			String email = bean.getEmail();	
					
		// セッションへユーザ情報をセットする
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("kana ",kana );
			session.setAttribute("postcode ",postcode );
			session.setAttribute("adress ",adress );
			session.setAttribute("building", building);
			session.setAttribute("roomnumber",roomnumber );
			session.setAttribute("phonenumber ",phonenumber );
			session.setAttribute("email ",email );
			
			
		// 画面の遷移先
		req.getRequestDispatcher("/manager/admin_user_detail.jsp").forward(req, res);
	}

}

