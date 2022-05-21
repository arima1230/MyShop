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
 * @author fu.zhirao
 */
@WebServlet("/manager/admin_douserselect")
public class DoUserSelect extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// TODO Auto-generated method stub
		// 文字コードを設定する
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		// セッションオブジェクトを生成する
		HttpSession session = req.getSession(true);

		// JSP側でユーザー管理ボタンが押された場合、一覧画面へ遷移する
		if (req.getParameter("submit") == null) {

			// DAOをインスタン化する
			UserDao dao = new UserDao();
			// リクエストにDAOで取得したユーザ情報をセットする
			req.setAttribute("list", dao.getUserList());

		} else if (req.getParameter("submit").equals("変更")) {
			// JSP側で詳細ボタンが押されたら詳細画面へ遷移する

			// DAOをインスタン化する
			UserDao dao = new UserDao();
			// リクエストからユーザIDを取得する
			int id = Integer.parseInt(req.getParameter("user_id"));
			// リクエストのユーザIDを元に残りの情報ををDAOより取得する
			User bean = new User();
			bean = dao.getUser(id);
			String name = bean.getUser_name();
			String kana = bean.getKana();
			String postcode = bean.getPostcode();
			String adress = bean.getAdress();
			String building = bean.getBuilding();
			String roomnumber = bean.getRoomnumber();
			String phonenumber = bean.getPhonenumber();
			String email = bean.getEmail();

			// セッションへユーザ情報をセットする
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("kana ", kana);
			session.setAttribute("postcode ", postcode);
			session.setAttribute("adress ", adress);
			session.setAttribute("building", building);
			session.setAttribute("roomnumber", roomnumber);
			session.setAttribute("phonenumber ", phonenumber);
			session.setAttribute("email ", email);
			
			// JSPへ推移した際に、画面を指定する為にtop1をセットする
						req.setAttribute("top1", "変更画面へ");
//
//		// ユーザ情報取得
//		ArrayList<User> list = UserDao.selectAll();
//
//		// 値を設定する
//		request.setAttribute("userlist", list);
//
//		// 画面の遷移先
//		request.getRequestDispatcher("/manager/admin_user.jsp").forward(request, response);
//	}
//
//}

		}
		RequestDispatcher rd = req.getRequestDispatcher("/manager/admin_user.jsp");
		rd.forward(req, res);
	}
}
