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
@WebServlet("/manager/admin_doitemadd")
public class DoItemAdd extends HttpServlet {
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
		String icode = reql.getParameter("itemCode");
		String iname = reql.getParameter("itemName");
		String id = reql.getParameter("parentId");
		String price = reql.getParameter("itemPrice");
		String desc = reql.getParameter("itemDesc");
		String stock = reql.getParameter("itemStock");

		// Itemをインスタンス化
		Item item = new Item(0, Integer.parseInt(icode), iname, Integer.parseInt(price),
				Integer.parseInt(id.split("-")[0]), desc, Integer.parseInt(stock), fname, 0);

		// DBに入れる
		int count = ItemDao.insert(item);

		// 成功/失敗によってforward

		if (count > 0) {
			response.sendRedirect("admin_itemselect");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('商品追加失敗')");
			out.println("location.href='/MyShop/manager/admin_toitemadd'");
			out.println("</script>");
		}

	}

}
