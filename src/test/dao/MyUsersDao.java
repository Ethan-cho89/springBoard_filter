package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.db.DBCPBean;

public class MyUsersDao {
	private static MyUsersDao instance = new MyUsersDao();
	
	public static MyUsersDao getInstance() {
		return instance;
	}
	
	public int isUser(String id, String pwd) {
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		try {
			con = DBCPBean.getConn();
			String sql = "select * from myusers where id=? and pwd=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return 1;
			}else {
				return 0;
			}
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
	
}
