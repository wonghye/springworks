package com.cloud.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloud.common.JDBCUtil;

@Repository
public class BoardDAO {
	
	//jdbc 관련 변수
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//SQL 쿼리 상수 선언
	private final String BOARD_INSERT =
			"INSERT INTO board2(bno, title, writer, content) "
			+ "VALUES (seq2.nextval, ?, ?, ?)";
	private final String BOARD_LIST =
			"SELECT * FROM board2 ORDER BY bno DESC";
	private final String BOARD_ONE =
			"SELECT * FROM board2 WHERE bno = ?";
	private final String BOARD_DELETE = 
			"DELETE FROM board2 WHERE bno = ?";
	private final String BOARD_UPDATE = 
			"UPDATE board2 SET title=?, content=? WHERE bno = ?";
	
	
	
	//글 쓰기
	public void insertBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	
	//글 목록 보기
	public List<BoardVO> getBoardList(){
		List<BoardVO> boardList = new ArrayList<BoardVO>();
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
				vo.setRegDate(rs.getDate("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				boardList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return boardList;
	}
	
	// 글 상세보기
	public BoardVO getBoard(int bno) {
		BoardVO board = new BoardVO();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_ONE);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board.setBno(rs.getInt("bno"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return board;
	}
	
	//조회수
	public void updateCount(int bno) {
		
		try {
			conn = JDBCUtil.getConnection();
			//조회수 검색
			/*
			String sql = "SELECT cnt FROM board2 WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt("cnt")+1;
			}
			*/
			//조회수 증가
			String sql = "UPDATE board2 SET cnt = ? WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, cnt);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn, pstmt, rs);
		}
	}
	
	//글 삭제
	public void deleteBoard(BoardVO vo) {
		
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getBno());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
		
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBno());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
}
