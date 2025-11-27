package com.shinhan.service;

import java.util.List;

import com.shinhan.dao.DAO;
import com.shinhan.dto.BoardDTO;

public class Service {
	
//	Service 작성 예시 (메소드 명에만 Service 표기, 카멜형식)
//	public static void insertBoardService() {
//		return DAO.insertboard();
//	}
	/*
	 * public static List<DTO> userselectAll(){ return DAO.userselectAll(); }
	 */
	
	//보드 리스트 조회
	public List<BoardDTO> selectBoardAll(){
		return DAO.selectBoardAll();
	}

	//보드 상세 조회
	public BoardDTO selectBoardId(int board_id){
		return DAO.selectBoardId(board_id);
	}
	
	//보드 삭제
	public int deleteBoard(int board_id) {
	    return DAO.deleteBoard(board_id);
	}
	
	//보드 수정
	public int updateBoard(BoardDTO board_id) {
		return DAO.updateBoard(board_id);
	}
}
