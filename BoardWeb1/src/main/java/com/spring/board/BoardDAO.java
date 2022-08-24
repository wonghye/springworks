package com.spring.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.common.JDBCUtil;

//DAO data access object
@Repository("boardDAO")
public class BoardDAO {

	//jdbc 관련 변수 선언
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//sql쿼리 - 상수로 선언 !! boardWeb !!
	private final String BOARD_INSERT = "INSERT INTO boardWeb(bno, title, writer, content) "
			+ "VALUES (seq.nextval, ?, ?,?)";
	private final String BOARD_LIST = "SELECT * FROM boardWeb ORDER BY bno DESC";
	
	//게시글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("==> insertBoard() 처리");
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	//글 목록
	public List<BoardVO> getBoardList(){
		System.out.println("==> getBoardList() 처리");
		List<BoardVO> boardList = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBno(rs.getInt("bno"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getDate("regDate"));
				vo.setCnt(rs.getInt("cnt"));
				boardList.add(vo);   // 생성한 객체를 리스트에 저장
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return boardList;
	}
}
