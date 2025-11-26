package com.shinhan.controller;

import com.shinhan.dao.DAO;
import com.shinhan.util.IOUtil;

public class Controller {
    
    private final DAO dao = new DAO(); // JDBC DAO (앞에서 만든 insert/select/update/delete)

    public void start() {
        while (true) {
            BoardView.menu();
            int menu = IOUtil.inputInt("메뉴 선택 >> ");
            switch (menu) {
                case 1 -> createBoard();  // C
                case 2 -> readBoard();    // R
                case 3 -> updateBoard();  // U
                case 4 -> deleteBoard();  // D
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
    private void createBoard() {
        
    }

    // ====== R : 글 조회 ======
    // >> 전체 리스트(제목, 작성자) >> 상세 내용
    private void readBoard() {
        
    }

    // ====== U : 글 수정 ======
    // >> 전체 리스트 >> 인덱스 번호 선택
    private void updateBoard() {
        
    }

    // ====== D : 글 삭제 ======
    // >> 전체 리스트 >> 상세 내용 >> 삭제
    private void deleteBoard() {
        
    }

    // 실행용 main
    public static void main(String[] args) {
        new Controller().start();
    }
}