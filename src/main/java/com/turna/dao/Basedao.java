package com.turna.dao;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class Basedao {
//
//	static {
//		// JDBCドライバをロード
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//
//	}
//
//	// DBに繋がる
//	public static Connection getconn() {
//		// 連携対象を作る
//		Connection conn = null;
//		String url = "jdbc:mysql://localhost/shopping?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
//		try {
//			conn = DriverManager.getConnection(url, "root", "");
//		
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//		return conn;
//	}
//
//	// 実行可能 I:insert U:update D:delete
//	public static int exectuIUD(String sql, Object[] params) {
//		int count = 0;
//		Connection conn = Basedao.getconn();
//
//		// SQLを準備する
//		PreparedStatement ps = null;
//
//		// insert into user(''',''') value(?,?,?)
//		try {
//			// SQLを準備する
//			ps = conn.prepareStatement(sql);
//			// パラメターを連携
//			for (int i = 0; i < params.length; i++) {
//				ps.setObject(i + 1, params[i]);
//			}
//			// sqlを実行する
//			count = ps.executeUpdate();
//
//	} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		} finally {
//			Basedao.closeall(null, ps, conn);
//		}
//
//		return count;
//}
//     //DBからの切断
//	public static void closeall(ResultSet rs, PreparedStatement ps, Connection conn) {
//		// rs,ps,connはnullじゃない場合はDBと切断
//		if (rs != null)
//			try {
//				if (rs != null)
//					rs.close();
//			} catch (SQLException e) {
//				// TODO 自動生成された catch ブロック
//				e.printStackTrace();
//			}
//
//		if (ps != null)
//			try {
//				ps.close();
//			} catch (SQLException e) {
//				// TODO 自動生成された catch ブロック
//				e.printStackTrace();
//			}
//
//	if (conn != null)
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO 自動生成された catch ブロック
//				e.printStackTrace();
//			}
//	}
//}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Basedao {
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/shopping?useUnicode=true&characterEncoding=utf8";
	private static final String DB_USER = "root";
	private static final String DB_PWD = "";

	private Connection connection = null;

	public Connection getConnection() {
		return this.connection;
	}

	public void connect() {
		try {
			Class.forName(DB_DRIVER);
			this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			if (this.connection != null) {
				this.connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.connection = null;
		}
	}
}

