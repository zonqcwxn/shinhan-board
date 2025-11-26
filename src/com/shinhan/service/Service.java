package com.shinhan.service;

import java.util.List;

import com.shinhan.dao.DAO;

public class Service {
	/*
	 * public static List<DTO> userselectAll(){ return DAO.userselectAll(); }
	 */
	public static List<BoardDTO> boardselectAll(){
		return DAO.boardselectAll();
	}

	/*
	 * public static int deleteuser(int user_id) { return DAO.deleteuser(user_id); }
	 */
	public static int deleteboard(int board_id) {
	    return DAO.deleteboard(board_id);
	}
	
}
