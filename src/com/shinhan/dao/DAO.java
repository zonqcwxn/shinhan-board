package com.shinhan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dto.BoardDTO;
import com.shinhan.util.DBUtil;

public class DAO {
	
//	sql 작성 예시
//	String sql = """
//			UPDATE 
//				TBL_BOARD
//			SET 
//				BOARD_ACTIVE = 'N'
//			WHERE 1=1
//			AND BOARD_ID =?
//			AND BOARD_ACTIVE ='Y'
//			""";
	
	// 유저 테이블 전체 조회
	/*
	 * public static List<DTO> userselectAll() { Connection conn = null;
	 * PreparedStatement st = null; ResultSet rs = null; String sql =
	 * "select * from tbl_user"; List<DTO> dtolist = new ArrayList<DTO>(); try {
	 * conn = DBUtil.dbConnect(); st = conn.prepareStatement(sql); rs =
	 * st.executeQuery(); while (rs.next()) { DTO dto = makeuser(rs);
	 * dtolist.add(dto); } } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } finally { DBUtil.dbDisConnect(conn, st, rs); }
	 * 
	 * return dtolist; }
	 */
	//보드 테이블 전체 조회
	public static List<BoardDTO> boardselectAll() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from tbl_board";
		List<BoardDTO> dtolist = new ArrayList<BoardDTO>();
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				BoardDTO dto = makeboard(rs);
				dtolist.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
		return dtolist;
	}
	//유저 ID로 조회
	/*
	 * public static DTO selectuserId(int uId) { Connection conn = null;
	 * PreparedStatement st = null; ResultSet rs = null; String sql =
	 * "select * from tbl_user where user_id = ?"; DTO dto = null; try { conn =
	 * DBUtil.dbConnect(); st = conn.prepareStatement(sql); st.setInt(1, uId); rs =
	 * st.executeQuery(); if (rs.next()) { dto = makeuser(rs); } } catch
	 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * finally { DBUtil.dbDisConnect(conn, st, rs); } return dto;
	 * 
	 * }
	 */
	//보드 ID로 조회
	public static BoardDTO selectboardId(int bId) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = """
				select * from tbl_board 
				where board_user_id = ? and board_active = 'Y'
				""";
		BoardDTO dto = null;
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			st.setInt(1, bId);
			rs = st.executeQuery();
			if(rs.next()) {
				dto = makeboard(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
		return dto;
		
	}
	/*
	 * public static int insertuser(DTO dto) { Connection conn = null;
	 * PreparedStatement st = null; String sql =
	 * "insert into tbl_user(user_id, user_name, user_pwd, user_email, user_regdate, user_active) values(seq_user_id.NEXTVAL, ?, ?, ?, SYSDATE, 'Y' )"
	 * ; int result = 0;
	 * 
	 * try { conn = DBUtil.dbConnect(); st = conn.prepareStatement(sql);
	 * st.setString(1, dto.getUser_name()); st.setString(2, dto.getUser_pwd());
	 * st.setString(3, dto.getUser_email()); result = st.executeUpdate(); } catch
	 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace();
	 * }finally { DBUtil.dbDisConnect(conn, st, null); } return result; }
	 */
	
	public static int insertboard(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "insert into tbl_board(board_id, board_title, board_content, board_active, board_view) "
				+ "values(board_seq.NEXTVAL, ?, ?, 'Y', 0";
		int result = 0;
		
		
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			st.setString(1, dto.getBoard_title());
			st.setString(2, dto.getBoard_content());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisConnect(conn, st, null);
		}
		return result;
	}
	
	public static int updateboard(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "update tbl_board set board_title = ?, board_content = ?, board_udtdate = SYSDATE from tbl_board where = ?";
		int result = 0;
		
		
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			st.setString(1, dto.getBoard_title());
			st.setString(2, dto.getBoard_content());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisConnect(conn, st, null);
		}
		return result;
	}
	/*
	 * public static int deleteuser(int user_id) { Connection conn = null;
	 * PreparedStatement st = null; String sql =
	 * "update tbl_user set user_acitve = 'N' from tbl_user where user_id = ? and user_active = 'Y'"
	 * ; int result = 0;
	 * 
	 * try { conn = DBUtil.dbConnect(); st = conn.prepareStatement(sql);
	 * st.setInt(1, user_id); result = st.executeUpdate();
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }finally {
	 * DBUtil.dbDisConnect(conn, st, null); }
	 * 
	 * return result; }
	 */

	public static int deleteboard(int board_id) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = "update tbl_board set board_active = 'N' from tbl_board where board_id = ? and board_active = 'Y'";
		int result = 0;

		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			st.setInt(1, board_id);
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisConnect(conn, st, null);
		}

		return result;
	}

	/*
	 * private static DTO makeuser(ResultSet rs) throws SQLException { DTO dto = new
	 * DTO(); dto.setUser_id(rs.getInt("user_id"));
	 * dto.setUser_name(rs.getString("user_name"));
	 * dto.setUser_pwd(rs.getString("user_pwd"));
	 * dto.setUser_email(rs.getString("user_email"));
	 * dto.setUser_regdate(rs.getDate("user_regdate"));
	 * dto.setUser_active(rs.getString("user_active")); return dto; }
	 */

	private static BoardDTO makeboard(ResultSet rs) throws SQLException {
		BoardDTO dto = new BoardDTO();
		dto.setBoard_id(rs.getInt("board_id"));
		dto.setBoard_user_id(rs.getInt("board_user_id"));
		dto.setBoard_title(rs.getString("board_title"));
		dto.setBoard_content(rs.getString("board_content"));
		dto.setBoard_regdate(rs.getDate("board_regdate"));
		dto.setBoard_udtdate(rs.getDate("board_udtdate"));
		dto.setBoard_view(rs.getInt("board_view"));
		dto.setBoard_active(rs.getString("board_active"));
		return dto;
	}
}
