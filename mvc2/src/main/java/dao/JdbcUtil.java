package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	static { // 클래스당 1번 초기화
		System.out.println("static 블럭");
		try {
			// 드라이버 클래스 동적 바인딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 바인딩 실패");
			// System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();}
			if(pstmt!=null) {
				pstmt.close();}
			if(con!=null) {
				con.close();}
			
		} catch (SQLException e) {
			System.out.println("db접속 종료 예외 발생");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "icia", "1234");
//			System.out.println("con=" + con);
			// 자바 기본 오토 커밋
			con.setAutoCommit(false); // 수동커밋 DML:insert,update,delete
			
			return con;
		} catch (SQLException e) {
			System.out.println("db접속 예외 발생");
			e.printStackTrace();
		}return null;
	}
	
	public static void commit(Connection con) {
		try {
			if(con!=null) {
			con.commit();}
		} catch (SQLException e1) {
			System.out.println("커밋 예외 발생");
			e1.printStackTrace();
		}
		
	}

	public static void rollback(Connection con) {
		try {
			if(con!=null) {
			con.rollback();}
		} catch (SQLException e1) {
			System.out.println("롤백 예외 발생");
			e1.printStackTrace();
		}
	}

//	private void select() {
//		try {
//			stmt = con.createStatement();
//			String sql = "SELECT * FROM MEMBER";
//			rs = stmt.executeQuery(sql); // select만
//			while (rs.next()) {
//				System.out.println("| 아이디: " + rs.getString("ID"/* 컬럼명 */) + "| 비번: " + rs.getString("Pw") + "| 이름: "
//						+ rs.getString("NAME") + "| 나이: " + rs.getInt("AGE") + "| 이메일: " + rs.getString("EMAIL") + "|");
//			}
//			System.out.println("----------------------------");
//		} catch (SQLException e) {
//			System.out.println("select 예외 발생");
//			e.printStackTrace();
//		}
//	}// end select
//
//	private void insert() { // 자바는 자동커밋
//		try {
//			stmt = con.createStatement();
//			String sql = "INSERT INTO MEMBER VALUES('AAA',1111,'에이',10,'AAA@naver.com')";
//			int cnt = stmt.executeUpdate(sql); // insert, update, delete
//			if (cnt != 0) {
//				System.out.println("insert ok");
//			} else {
//				System.out.println("insert fail");
//			}
//		} catch (SQLException e) {
//			System.out.println("insert 예외 발생");
//			e.printStackTrace();
//		}
//	}
//
//	private void delete() {
//		try {
//			stmt = con.createStatement();
//			String sql = "DELETE FROM MEMBER WHERE ID='AAA'";
//			int cnt = stmt.executeUpdate(sql);
//			if (cnt != 0) {
//				System.out.println("delete ok");
//			} else {
//				System.out.println("delete fail");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	private void update() {
//		try {
//			stmt = con.createStatement();
//			String sql = "UPDATE MEMBER SET PW=2222";
//			int cnt = stmt.executeUpdate(sql);
//			if (cnt != 0) {
//				System.out.println("update ok");
//			} else {
//				System.out.println("update fail");
//			}
//		} catch (SQLException e) {
//			System.out.println("update 예외 발생");
//			e.printStackTrace();
//		}
//
//	}
	
	
}
