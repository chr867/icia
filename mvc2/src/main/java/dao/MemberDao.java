package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import bean.Member;

public class MemberDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDao() {
		con=JdbcUtil.getConnection();
	}
	
	public boolean access(HashMap<String, String> hMap) {
		String sql="SELECT * FROM MEMBER WHERE ID=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, hMap.get("id"));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getNString("pw").equals(hMap.get("pw"))) {
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("access 예외 발생");
			e.printStackTrace();
		}
		return false;
	}

	public void close() {
		JdbcUtil.close(con, pstmt, rs);
	}

	public boolean memberJoin(Member mb) {
		String sql="INSERT INTO MEMBER(ID,PW,NAME,GENDER) VALUES(?,?,?,?)";
		int result=0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,mb.getId());
			pstmt.setString(2,mb.getPw());
			pstmt.setString(3,mb.getName());
			pstmt.setString(4,mb.getGender());
			result=pstmt.executeUpdate(); //update, delete, insert
			if(result!=0) {
				return true; //회원가입 성공
			}
		} catch (SQLException e) {
			System.out.println("회원가입 예외 발생");
			e.printStackTrace();
		} //파싱1번
		
		return false; //실패
	}
}
