package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	private String brand;
	private Scanner scan = new Scanner(System.in);
	private UserManager userManager;
	private ItemManager itemManger;
	private final int USER= 1;
	private final int FILE= 2;
	private final int ADMIN= 3;
	
	private final int JOIN = 1;
	private final int OUT = 2;
	private final int LOG_IN = 3;
	private final int LOG_OUT = 4;
	private final int SHOPPING = 5;
	
	private final int ITEM = 1;
	private final int CHECK = 2;
	
	private int log;
	
	public Shop(String brand) {
		this.brand = brand;
	}
	private void setSystem() {
		log = -1;
	}
	private int inputNumber(String message) {
		System.out.println(message);
		int number = 0 ;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력하세요 ");
		}
		return number;
	}
	private String inputString(String message) {
		System.out.println(message);
		return scan.next();
	}
	private void printMainMenu() {
		System.out.println("[1]유저메뉴");
		System.out.println("[2]파일메뉴");
		System.out.println("[3]관리자메뉴");
	}
	
	private void runMainMenu() {
		int sel = inputNumber("메뉴를 선택해주세요");
		if(sel == USER)
			runUserMenu();
		else if(sel == FILE)
			else if(sel == ADMIN)
				runAdminMenu();
		
	}
	private void runUserMenu() {
		int sel = inputNumber("메뉴를 선택해주세요");
		if(sel == JOIN)
			userManager.addUser();
		else if(sel == OUT)
			userManager.removeUser(log);
			else if(sel == LOG_IN)
				userManager
				else if(sel == LOG_OUT)
					else if(sel == SHOPPING)
		
	}
	private void logIn() {
		String id = inputString("ID를 입력해주세요");
		String pw = inputString("비밀번호를 입력해주세요");
		int index = userManager.checkUserInfo(id, pw);
		if(index ==-1) {
			System.err.println("회원정보가 일치하지 않습니다");
			return;
		}
		
		log = index;
	}
	private void runAdminMenu(){
		int sel = inputNumber("메뉴를 선택해주세요");
		if(sel == ITEM)
			userManager.addUser();
		else if(sel == CHECK)
	}
	private void printUserMenu() {
		System.out.println("[1]회원가입");
		System.out.println("[2]회원탈퇴");
		System.out.println("[3]로그인");
		System.out.println("[4]로그아웃");
		System.out.println("[5]쇼핑하기");
	}
	private void printMyPage() {
		System.out.println("[1]장바구니");
		System.out.println("[2]항목삭제");
		System.out.println("[3]수량수정");
		System.out.println("[4]결제");
	}
	private void printAdminMenu() {
		System.out.println("[1]아이템");
		System.out.println("[2]조회");
	}
	
	private void printItemMenu() {
		System.out.println("[1]등록");
		System.out.println("[1]삭제");
		System.out.println("[1]수정");
	}
	public void run() {
		// 유저 - 
		// ㄴ 회원가입					[O]
		// ㄴ 탈퇴					[X]
		// ㄴ 로그인					[X]
		// ㄴ 로그아웃					[X]
		// ㄴ 쇼핑하기					[X]
		// ㄴ 마이페이지
		//   ㄴ 내장바구니				[X]
		//   ㄴ 항목삭제				[X]
		//   ㄴ 수량수정				[X]
		//   ㄴ 결제					[X]
		// 파일 
		// ㄴ 자동저장					[X]
		// ㄴ 자동로드					[X]
		
		// 관리자 -
		// ㄴ 아이템		
		//   ㄴ 등록					[X]
		//   ㄴ 삭제					[X]
		//   ㄴ 수정					[X]
		// ㄴ 조회(총 매출)			[X]
	}
}
