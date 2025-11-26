package com.shinhan.util;

import java.util.Scanner;

public class IOUtil {
	
	private final static Scanner sc = new Scanner(System.in);

	// ====== 공통 입력 메서드 (int) ======
	public static int inputInt(String msg) {
		while(true) {
			System.out.print(msg);
			String input = sc.nextLine(); //전체 라인을 문자열로 받음
			//공백인지 확인
			if(input == null || input.trim().isEmpty()) {
				error("값을 입력해주세요.");
				continue;
			}
			//숫자로 파싱 시도
			try {
				return Integer.parseInt(input.trim());
			} catch (NumberFormatException e) {
				error("숫자를 입력해주세요.");
				continue;
			}
		}
	}
	
	// ====== 공통 입력 메서드 (String) ======
	public static String inputString(String msg) {
		System.out.print(msg);
        return sc.nextLine();
	}
	
	// ====== 공통 출력 메서드 (String, print) ======
	public static void print(String msg) {
		System.out.print(msg);
	}
	
	// ====== 공통 출력 메서드 (String, prntln) ======
	public static void println(String msg) {
		System.out.println(msg);
	}
	
	// ====== 공통 출력 메서드 (Error) ======
	public static void error(String msg) {
		System.out.println("X "+msg);
	}
}
