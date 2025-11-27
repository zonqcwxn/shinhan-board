package com.shinhan.service;

import java.util.List;

import com.shinhan.dao.DAO;
import com.shinhan.dto.BoardDTO;

public class Service {
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
}
