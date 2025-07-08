package org.kosa.job.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DbConfig;

// Dao : Data Access Object  데이터 제어 로직을 담당하는 객체 
// Singleton Pattern : 시스템 상에 단 하나 객체 생성해서 사용하는 설계 패턴 
public class MemberDao {
	private static MemberDao instance;
	private MemberDao() throws ClassNotFoundException {
		Class.forName(DbConfig.DRIVER);
	}
	// 지연된 로딩 : Lazy Loading 
	public static MemberDao getInstance() throws ClassNotFoundException {
		if(instance == null)
			instance = new MemberDao();
		return instance;
	}

	/*
	 * method() throws SQLException { Connection PreparedStatement ResultSet try {
	 * 
	 * }finally{ close } return memberVO; }
	 */
	public MemberVo findMemberById(String memberId) throws SQLException {
		MemberVo memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PASS);
			String sql = "select id,password,name,address from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			if (rs.next())
				memberVO = new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return memberVO;
	}

	public void register(MemberVo memberVO) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PASS);
			String sql = "INSERT INTO member(id,password,name,address) VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPassword());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getAddress());
			int result = pstmt.executeUpdate();
			System.out.println("insert count:" + result);
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}

	public ArrayList<MemberVo> findMemberByAddress(String address) throws SQLException {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PASS);
			String sql = "SELECT id,name,address FROM member WHERE address=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new MemberVo(rs.getString("id"),null,rs.getString("name"),rs.getString("address")));
			}
		}finally {
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}
		return list;
	}
	public int getAllMemberCount() throws SQLException {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PASS);
			String sql = "select count(*) from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt(1);
		}finally {
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}
		return count;
	}
}











