package com.shinhan.controller;

import java.util.List;

import com.shinhan.dao.DAO;
import com.shinhan.dto.BoardDTO;
import com.shinhan.dto.CommonDTO;
import com.shinhan.service.Service;
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
    	 IOUtil.println("=== 글 등록 ===");

    	    String title = IOUtil.inputString("제목 입력 >> ");
    	    String content = IOUtil.inputString("내용 입력 >> ");
    	    int userId = IOUtil.inputInt("작성자 ID 입력 >> ");

    	    BoardDTO dto = new BoardDTO();
    	    dto.setBoard_title(title);
    	    dto.setBoard_content(content);
    	    dto.setBoard_user_id(userId);

    	    int result = dao.insertboard(dto);

    	    if (result > 0) {
    	        IOUtil.println("글이 성공적으로 등록되었습니다.");
    	    } else {
    	        IOUtil.println("글 등록 실패!");
    	    }
    }

    // ====== R : 글 조회 ======
    // >> 전체 리스트(제목, 작성자) >> 상세 내용
    private void readBoard() {
    	IOUtil.println("=== 글 목록 조회 ===");

        List<BoardDTO> list = Service.boardselectAll();

        if (list.isEmpty()) {
            IOUtil.println("등록된 글이 없습니다.");
            return;
        }

        // 전체 리스트 출력
        for (BoardDTO b : list) {
            IOUtil.println("ID: " + b.getBoard_id()
                    + " | 제목: " + b.getBoard_title()
                    + " | 작성자: " + b.getBoard_user_id());
        }

        int id = IOUtil.inputInt("상세조회할 글 ID 입력 >> ");

        CommonDTO dto = Service.selectboardId2(id);

        if (dto == null) {
            IOUtil.println("해당 글을 찾을 수 없습니다.");
            return;
        }

        // 상세 내용 출력
        IOUtil.println("=== 글 상세 ===");
        IOUtil.println("제목: " + dto.getBoard_title());
        IOUtil.println("내용: " + dto.getBoard_content());
        IOUtil.println("작성자: " + dto.getUser_name());
        IOUtil.println("수정일: " + dto.getBoard_udtdate());
    }

    // ====== U : 글 수정 ======
    // >> 전체 리스트 >> 인덱스 번호 선택
    private void updateBoard() {
    	 IOUtil.println("=== 글 수정 ===");

    	    List<BoardDTO> list = Service.boardselectAll();

    	    if (list.isEmpty()) {
    	        IOUtil.println("등록된 글이 없습니다.");
    	        return;
    	    }

    	    // 목록 출력
    	    for (BoardDTO b : list) {
    	        IOUtil.println("ID: " + b.getBoard_id()
    	                + " | 제목: " + b.getBoard_title()
    	                + " | 작성자: " + b.getBoard_user_id());
    	    }

    	    int id = IOUtil.inputInt("수정할 글 ID 입력 >> ");

    	    BoardDTO old = Service.selectboardId(id);

    	    if (old == null) {
    	        IOUtil.println("해당 글을 찾을 수 없습니다.");
    	        return;
    	    }

    	    // 새 값 입력받기
    	    String newTitle = IOUtil.inputString("새 제목 입력 >> ");
    	    String newContent = IOUtil.inputString("새 내용 입력 >> ");

    	    BoardDTO newDto = new BoardDTO();
    	    newDto.setBoard_user_id(id);   // update 조건이 board_user_id 사용 중!!
    	    newDto.setBoard_title(newTitle);
    	    newDto.setBoard_content(newContent);

    	    int result = Service.updateboard(newDto);

    	    if (result > 0) {
    	        IOUtil.println("글이 성공적으로 수정되었습니다.");
    	    } else {
    	        IOUtil.println("글 수정 실패!");
    	    }
    }

    // ====== D : 글 삭제 ======
    // >> 전체 리스트 >> 상세 내용 >> 삭제
    private void deleteBoard() {
    	IOUtil.println("=== 글 삭제 ===");

        List<BoardDTO> list = Service.boardselectAll();

        if (list.isEmpty()) {
            IOUtil.println("등록된 글이 없습니다.");
            return;
        }

        // 목록 출력
        for (BoardDTO b : list) {
            IOUtil.println("ID: " + b.getBoard_id()
                    + " | 제목: " + b.getBoard_title()
                    + " | 작성자: " + b.getBoard_user_id());
        }

        int id = IOUtil.inputInt("삭제할 글 ID 입력 >> ");

        BoardDTO dto = Service.selectboardId(id);
        if (dto == null) {
            IOUtil.println("해당 글을 찾을 수 없습니다.");
            return;
        }

        // 삭제 확인
        String confirm = IOUtil.inputString("정말 삭제하시겠습니까? (Y/N) >> ");
        if (!confirm.equalsIgnoreCase("Y")) {
            IOUtil.println("삭제 취소되었습니다.");
            return;
        }

        int result = Service.deleteboard(id);

        if (result > 0) {
            IOUtil.println("글이 삭제되었습니다.(비활성 처리)");
        } else {
            IOUtil.println("삭제 실패! 이미 삭제된 글일 수 있습니다.");
        }
    }

    // 실행용 main
    public static void main(String[] args) {
        new Controller().start();
    }
}