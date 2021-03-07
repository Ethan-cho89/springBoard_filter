package test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import test.db.DBCPBean;
import test.vo.BoardVo;

public class BoardDao {

	public int insert(BoardVo vo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int num = vo.getNum();
		String writer = vo.getWriter();
		String title = vo.getTitle();
		String content = vo.getContent();
		try {
			con=DBCPBean.getConn();
			String sql = "insert into myboard values(?,?,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, writer);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			int n =pstmt.executeUpdate();
			return n;
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, null);
		}
	}
	
	public ArrayList<BoardVo> list(int startRow, int endRow){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con=DBCPBean.getConn();
			String sql = "select * from " + 
					"(" + 
					"    select rownum rnum, aa.* from" + 
					"    (" + 
					"        select * from myboard order by num desc" + 
					"    )aa" + 
					") where rnum>=? and rnum<=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			ArrayList<BoardVo> list = new ArrayList<BoardVo>();
			while(rs.next()) {
				int n = rs.getInt("num");
				String w = rs.getString("writer");
				String t = rs.getString("title");
				String c = rs.getString("content");
				Date r = rs.getDate("regdate");
				BoardVo vo = new BoardVo(n, w, t, c, r);
				list.add(vo);
			}
			return list;
		}catch(SQLException s) {
			s.printStackTrace();
			return null;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
	
	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			con=DBCPBean.getConn();
			String sql = "select nvl(max(num),0) from myboard";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}else {
				return -1;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
	
	public int getCount() {
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			con=DBCPBean.getConn();
			String sql = "select nvl(count(num),0) from myboard";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}else {
				return -1;
			}
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
	
	
	public BoardVo load(int num) {
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try { 
			con=DBCPBean.getConn();
			String sql = "select * from myboard where num =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String writer = rs.getString("writer");
				String title =rs.getString("title");
				String content = rs.getString("content");
				Date regdate = rs.getDate("regdate");
				BoardVo vo = new BoardVo(num, writer, title, content, regdate);
				return vo;
			}else {
				return null;
			}
		}catch(SQLException se) {
			se.printStackTrace();
			return null;
		}finally {
			DBCPBean.close(con, pstmt, rs);
		}
	}
	
	public int delete(int num) {
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			con= DBCPBean.getConn();
			String sql = "delete from myboard where num =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			int n =pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, null);
		}
	}
	
	public int update(BoardVo vo) {
		Connection con= null;
		PreparedStatement pstmt=null;
		try {
			con = DBCPBean.getConn();
			String sql ="update myboard set title=?,content=? where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNum());
			int n = pstmt.executeUpdate();
			return n;
		}catch(SQLException s) {
			s.printStackTrace();
			return -1;
		}finally {
			DBCPBean.close(con, pstmt, null);
		}
	}
	
}
