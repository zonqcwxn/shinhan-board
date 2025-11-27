package com.shinhan.controller;

import java.util.ArrayList;
import java.util.List;

import com.shinhan.dao.DAO;
import com.shinhan.dto.CommonDTO;
import com.shinhan.util.IOUtil;

public class Controller {
    
    private final DAO dao = new DAO(); // JDBC DAO (앞에서 만든 insert/select/update/delete)

    public void start() {
        while (true) {
            BoardView.menu();
            int menu = IOUtil.inputInt("메뉴 선택 >> ");
            switch (menu) {
                case 1 -> f_create();  		// C
                case 2 -> f_selectList();	// R
                case 3 -> f_update();  	// Uㄹㅇㄴ
                case 4 -> f_delete();  	// D
                case 0 -> {
                    IOUtil.println("프로그램을 종료합니다.");
                    return;
                }
                default -> IOUtil.println("잘못된 메뉴입니다.");
            }
        }
    }

    
    // ====== C : 글 등록 ======
    // >> 등록 화면
    private void f_create() {

    }

    
    // ====== R : 글 목록 조회 ======
    // >> 전체 리스트(제목, 작성자) >> 상세 내용
    private void f_selectList() {
    	List<CommonDTO> boardList = new ArrayList<CommonDTO>();
    }
    
    
    // ====== R : 글 상세 조회 ======
    // >> 전체 리스트(제목, 작성자) >> 상세 내용
    private void f_select() {
    	List<CommonDTO> boardList = new ArrayList<CommonDTO>();
    	
    }

    // ====== U : 글 수정 ======
    // >> 전체 리스트 >> 인덱스 번호 선택
    private void f_update() {
    	List<CommonDTO> boardList = new ArrayList<CommonDTO>();
        
    }
    

    // ====== D : 글 삭제 ======
    // >> 전체 리스트 >> 상세 내용 >> 삭제
    private void f_delete() {
    	List<CommonDTO> boardList = new ArrayList<CommonDTO>();
        
    }
//
    // 실행용 main
    public static void main(String[] args) {
        new Controller().start();
    }
}