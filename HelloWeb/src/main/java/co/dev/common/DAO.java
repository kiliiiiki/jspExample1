package co.dev.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * connection 객체 가져오기, 데이터 베이스 처리를 위한 preparestatement 가져오기, 결과값 담기위한 resultset 가져오기
 */
public class DAO {
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public void getConn() {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void disConn() {
		//resource 환원
			try {
				if(conn != null) {
				conn.close();
				}
				if(psmt != null) {
					psmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
}
