package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

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

}
