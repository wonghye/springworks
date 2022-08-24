package com.spring.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.spring.common.JDBCUtil;

//@Repository("userDAO")
public class UserDAO {
	
	//jdbc ���� ���� ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	//sql - ��� ����
	private final String LOGIN = "SELECT * FROM users WHERE id=? and passwd=?";
		
	//ȸ�� �α���	
	public boolean login(UserVO vo) {
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(LOGIN);
			pstmt.setString(1, vo.getId());   //set id ������
			pstmt.setString(2, vo.getPasswd());
			rs= pstmt.executeQuery();
			if(rs.next()) {  //  id pwd ��ġ�ϴ� �ڷᰡ ������
				return true; // true ��ȯ
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return false;
	}
}
