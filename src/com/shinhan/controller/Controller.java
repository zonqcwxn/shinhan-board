package com.shinhan.controller;

import java.util.Scanner;

import com.shinhan.dao.DAO;

public class Controller {

    private final Scanner sc = new Scanner(System.in);
    private final DAO dao = new DAO(); // JDBC DAO (앞에서 만든 insert/select/update/delete)

    public void start() {
        while (true) {
            printMenu();
            int menu = inputInt("메뉴 선택 >> ");

            switch (menu) {
                case 1 -> createBoardView();  // C
                case 2 -> readBoardView();    // R
                case 3 -> updateBoardView();  // U
                case 4 -> deleteBoardView();  // D
                case 0 -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 메뉴입니다.");
            }
        }
    }

    // ====== 공통 입력 메서드 ======
    private int inputInt(String msg) {
        System.out.print(msg);
        while (!sc.hasNextInt()) {
            System.out.println("숫자를 입력하세요.");
            sc.next(); // 잘못된 입력 제거
            System.out.print(msg);
        }
        int num = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        return num;
    }

    private String inputString(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    private void printMenu() {
        System.out.println();
        System.out.println("===== 게시판 CRUD =====");
        System.out.println("1. 글 등록 (Create)");
        System.out.println("2. 글 조회 (Read)");
        System.out.println("3. 글 수정 (Update)");
        System.out.println("4. 글 삭제 (Delete)");
        System.out.println("0. 종료");
        System.out.println("=======================");
    }

    // ====== C : 글 등록 ======
    private void createBoardView() {
        
    }

    // ====== R : 글 조회 (id로 단건 조회) ======
    private void readBoardView() {
        
    }

    // ====== U : 글 수정 ======
    private void updateBoardView() {
        
    }

    // ====== D : 글 삭제 ======
    private void deleteBoardView() {
        
    }

    // 실행용 main
    public static void main(String[] args) {
        new Controller().start();
    }
}