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
	
	//리스트 조회
	public static List<BoardDTO> selectBoardAll(){
		return DAO.selectBoardAll();
	}

	//
	public static BoardDTO selectBoardId(int board_id){
		return DAO.selectBoardId(board_id);
	}
	public static int deleteBoard(int board_id) {
	    return DAO.deleteBoard(board_id);
	}
	
	public static int updateBoard(BoardDTO board_id) {
		return DAO.updateBoard(board_id);
	}
}
