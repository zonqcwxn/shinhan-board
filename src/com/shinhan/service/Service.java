package com.shinhan.service;

import java.util.List;

import com.shinhan.dao.DAO;
import com.shinhan.dto.BoardDTO;
import com.shinhan.dto.CommonDTO;

public class Service {
	
	private DAO dao = new DAO();
	
//	Service 작성 예시 (메소드 명에만 Service 표기, 카멜형식)
//	public static void insertBoardService() {
//		return DAO.insertboard();
//	}
	/*
	 * public static List<DTO> userselectAll(){ return DAO.userselectAll(); }
	 */
	
	//보드 리스트 조회
	public List<BoardDTO> selectBoardAll(){
		return dao.selectBoardAll();
	}
	public List<CommonDTO> selectBoardAll2(){
		return dao.selectBoardAll2();
	}


	//보드 상세 조회
	public BoardDTO selectBoardId(int board_id){
		return dao.selectBoardId(board_id);
	}
	
	//보드 삭제
	public int deleteBoard(int board_id) {
	    return dao.deleteBoard(board_id);
	}
	
	//보드 수정
	public int updateBoard(BoardDTO board_id) {
		return dao.updateBoard(board_id);
	}
	public CommonDTO selectboardId2(int board_id) {
		return dao.selectBoardId2(board_id);
	}
}
