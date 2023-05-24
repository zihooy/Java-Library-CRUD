package library.servlet.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	// JDBC 기본설정값
	
	// 오라클 연결
	public static Connection getConnection() {
		Connection conn = null;
		
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.69:3306/book?serverTimezone=UTC", "posco","qwerQWER1234!@#$");
			// 자동 커밋설정 안하기
			conn.setAutoCommit(false);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	// 열린객체 닫기
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	// PreparedStatement, Statement 둘다사용가능
	// 상속관계임, Statement 가 부모여서 다형성사용가능!
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
	// 커밋/롤백
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}