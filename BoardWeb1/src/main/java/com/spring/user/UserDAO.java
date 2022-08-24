package com.spring.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.spring.common.JDBCUtil;

//@Repository("userDAO")
public class UserDAO {
	
	//jdbc 관련 변수 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	//sql - 상수 선언
	private final String LOGIN = "SELECT * FROM users WHERE id=? and passwd=?";
		
	//회원 로그인	
	public boolean login(UserVO vo) {
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(LOGIN);
			pstmt.setString(1, vo.getId());   //set id 가져옴
			pstmt.setString(2, vo.getPasswd());
			rs= pstmt.executeQuery();
			if(rs.next()) {  //  id pwd 일치하는 자료가 있으면
				return true; // true 반환
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return false;
	}
}
