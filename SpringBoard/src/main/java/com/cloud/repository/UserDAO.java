package com.cloud.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.cloud.common.JDBCUtil;

@Repository
public class UserDAO {
	
	//jdbc ���� ����
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//sql ��� ����
	private final String LOGIN = 
		"SELECT * FROM users2 WHERE id=? and passwd=?";
		
	//�α��� üũ
	public boolean login(UserVO vo) {
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(LOGIN);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
}