package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.naming.spi.DirStateFactory.Result;

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
	
	public void close() {
		JdbcUtil.close(con, pstmt, rs);
	}

	public ArrayList<String> memberList() {
		ArrayList<String> mList=new ArrayList<>();
		String sql="SELECT ID FROM MEMBER";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				mList.add(rs.getNString("id"));
			}
			return mList;
		} catch (SQLException e) {
			System.out.println("DAO memberList 예외 발생");
			e.printStackTrace();
		}
		return null;
	}

	public boolean memberDelete(String id) {
		String sql="DELETE FROM MEMBER WHERE ID=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			int result;
			result=pstmt.executeUpdate();
			if(result!=0) return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public HashMap<String, String> memberInfo(String id) {
		String sql="SELECT * FROM MEMBER WHERE ID=?";
		HashMap<String, String> hMap=new HashMap<>();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs=pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			if(rs.next()) {
				for(int i=1;i<=columnCount;i++) {
					hMap.put(rsmd.getColumnLabel(i), rs.getNString(i));
				}
			}
			return hMap;
		} catch (SQLException e) {
			System.out.println("memberInfo 예외 발생");
			e.printStackTrace();
		}
		return null;
	}

}
