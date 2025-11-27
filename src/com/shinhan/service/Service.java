package com.shinhan.service;

import java.util.List;

import com.shinhan.dao.DAO;
import com.shinhan.dto.BoardDTO;
import com.shinhan.dto.CommonDTO;

public class Service {
	
//	Service 작성 예시 (메소드 명에만 Service 표기, 카멜형식)
//	public static void insertBoardService() {
//		return DAO.insertboard();
//	}
	/*
	 * public static List<DTO> userselectAll(){ return DAO.userselectAll(); }
	 */
	public static List<BoardDTO> boardselectAll(){
		return DAO.boardselectAll();
	}

	public static BoardDTO selectboardId(int board_id){
		return DAO.selectboardId(board_id);
	}
	public static int deleteboard(int board_id) {
	    return DAO.deleteboard(board_id);
	}
	
	public static int updateboard(BoardDTO board_id) {
		return DAO.updateboard(board_id);
	}

	public static CommonDTO selectboardId2(int id) {
		// TODO Auto-generated method stub
		return DAO.selectboardId2(id);
	}
}
