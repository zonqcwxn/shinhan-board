package com.shinhan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dto.BoardDTO;
import com.shinhan.dto.CommonDTO;
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

	// 보드 테이블 전체 조회
	public List<BoardDTO> selectBoardAll() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = """
				select
					*
				from
					tbl_board
				""";
		List<BoardDTO> dtoList = new ArrayList<BoardDTO>();
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				BoardDTO dto = makeBoard(rs);
				dtoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
		return dtoList;
	}

	public List<CommonDTO> selectBoardAll2() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = """
				SELECT
				   	b.board_id,
				    b.board_title,
				    u.user_name
				FROM
				    tbl_board b
				JOIN
				    tbl_user u
				ON
				    b.board_user_id = u.user_id
				WHERE
				    1=1
				ORDER BY
					b.board_id DESC
				""";
		List<CommonDTO> dtoList = new ArrayList<CommonDTO>();
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				CommonDTO dto = new CommonDTO();
				dto.setBoard_id(rs.getInt("board_id"));
	            dto.setBoard_title(rs.getString("board_title"));
	            dto.setUser_name(rs.getString("user_name"));
	            dtoList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
		return dtoList;
	}

	

	// 蹂대�� ID濡� 議고��
	public BoardDTO selectBoardId(int bId) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = """
				select
					*
				from
					tbl_board
				where board_id = ?
				and board_active = 'Y'
				""";
		BoardDTO boardDTO = null;
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			st.setInt(1, bId);
			rs = st.executeQuery();
			if (rs.next()) {
				boardDTO = makeBoard(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
		return boardDTO;
	}

	public CommonDTO selectBoardId2(int board_id) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = """
				SELECT
				    u.user_name,
				    b.board_title,
				    b.board_content,
				    b.board_udtdate
				FROM
				    tbl_board b
				JOIN
				    tbl_user u
				ON
				    b.board_user_id = u.user_id
				WHERE
				    1=1
				and
				    b.board_id = ?
				""";
		CommonDTO Dto = null;
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			st.setInt(1, board_id);
			rs = st.executeQuery();
			if (rs.next()) {
				Dto = new CommonDTO();
			    Dto.setUser_name(rs.getString("user_name"));
			    Dto.setBoard_title(rs.getString("board_title"));
			    Dto.setBoard_content(rs.getString("board_content"));
			    Dto.setBoard_udtdate(rs.getDate("board_udtdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, rs);
		}
		return Dto;
	}
	public int insertBoard(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = """
				INSERT INTO
					tbl_board
				(
				board_id,
				board_title,
				board_content,
				board_active,
				board_view,
				board_regdate,
				board_udtdate,
				board_user_id)
				VALUES
				(seq_Board_id.NEXTVAL,
				?, ?,
				'Y', 0,
				SYSDATE, SYSDATE, ?)
				""";

		int result = 0;

		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			st.setString(1, dto.getBoard_title());
			st.setString(2, dto.getBoard_content());
			st.setInt(3, dto.getBoard_user_id());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, null);
		}
		return result;
	}

	public int updateBoard(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = """
				update
					tbl_board
				set
					board_title = ?,
					board_content = ?,
					board_udtdate = SYSDATE
				where board_id = ?
				""";
		int result = 0;

		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			st.setString(1, dto.getBoard_title());
			st.setString(2, dto.getBoard_content());
			st.setInt(3, dto.getBoard_id());

			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, null);
		}
		return result;
	}

	public int deleteBoard(int board_id) {
		Connection conn = null;
		PreparedStatement st = null;
		String sql = """
				update
					tbl_board
				set
					board_active = 'N',
					board_udtdate=SYSDATE
				where board_id = ?
				and board_active = 'Y'"
				""";
		int result = 0;

		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			st.setInt(1, board_id);
			result = st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisConnect(conn, st, null);
		}

		return result;
	}

	private BoardDTO makeBoard(ResultSet rs) throws SQLException {
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
