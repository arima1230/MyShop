package com.turna.servlet.item;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.turna.entity.Item;
import com.turna.service.ItemDao;

/**
 * @author fu.zhirao
 */
@WebServlet("/manager/admin_doitemupdate")
public class DoItemUpdate extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字コードを設定する
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// SmartUploadをインスタンス化
		SmartUpload su = new SmartUpload();
		// メンバへのアクセス
		su.initialize(this.getServletConfig(), request, response);
		// アップロード
		try {
			su.upload();
		} catch (ServletException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SmartUploadException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		// アップロードしたファイルを取得
		Files fs = su.getFiles();
		File f = fs.getFile(0);
		// ファイル名を取得
		String fname = f.getFileName();

		// 保存する
		try {
			su.save("shop/image");
		} catch (ServletException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SmartUploadException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		Request reql = su.getRequest();
		// パラメターを取得
		String id = reql.getParameter("itemId");
		String icode = reql.getParameter("itemCode");
		String iname = reql.getParameter("itemName");
		String pid = reql.getParameter("parentId");
		String price = reql.getParameter("itemPrice");
		String desc = reql.getParameter("itemDesc");
		String stock = reql.getParameter("itemStock");
		String def = reql.getParameter("deleteFlag");

		int deleteflag = 0;
		if (def != null) {
			deleteflag = Integer.parseInt(def);
		}

		// System.out.print(iid);
		// Itemをインスタンス化
		Item item = new Item(
				Integer.parseInt(id), 
				Integer.parseInt(icode),
				iname, 
				Integer.parseInt(price),
				Integer.parseInt(pid.split("-")[0]), 
				desc,
				Integer.parseInt(stock),
				fname, 
				deleteflag);

		// DBに入れる
		int count = ItemDao.update(item);
		// System.out.print(u);
		// 成功/失敗によってforward

		if (count > 0) {
			response.sendRedirect("admin_itemselect");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('商品編集失敗')");
			out.println("location.href='/MyShop1/manager/admin_toitemupdate?id=" + id + "'");
			out.println("</script>");
		}
	}

}
