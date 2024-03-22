package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	private String brand;
	private Scanner scan = new Scanner(System.in);
	private UserManager userManager;
	private ItemManager itemManager;
	private final int USER = 1;
	private final int FILE = 2;
	private final int ADMIN = 3;

	private final int JOIN = 1;
	private final int OUT = 2;
	private final int LOG_IN = 3;
	private final int LOG_OUT = 4;
	private final int SHOPPING = 5;

	private final int CART = 1;
	private final int DELETE = 2;
	private final int MODIFY = 3;
	private final int PAYMENT = 4;

	private final int ITEM = 1;
	private final int CHECK = 2;
	
	private final int REGISTER = 1;
	private final int DELETE_ITEM= 2;
	private final int MODIFY_ITEM= 3;
	private final int TOTAL= 4;
	
	private int total;
	private int log;

	public Shop(String brand) {
		this.brand = brand;
	}

	private void setSystem() {
		log = -1;
	}

	private int inputNumber(String message) {
		System.out.println(message);
		int number = 0;
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
		System.out.println("[2]관리자메뉴");
	}

	private void runMainMenu() {
		int sel = inputNumber("메뉴를 선택해주세요");
		if (sel == USER)
			runUserMenu();
		else if (sel == ADMIN)
			runAdminMenu();

	}

	private void printUserMenu() {
		System.out.println("[1]회원가입");
		System.out.println("[2]회원탈퇴");
		System.out.println("[3]로그인");
		System.out.println("[4]로그아웃");
		System.out.println("[5]쇼핑하기");
	}

	private void runUserMenu() {
		int sel = inputNumber("메뉴를 선택해주세요");
		if (sel == JOIN)
			userManager.addUser();
		else if (sel == OUT)
			userManager.removeUser(log);
		else if (sel == LOG_IN)
			logIn();
		else if (sel == LOG_OUT)
			logOut();
		else if (sel == SHOPPING)
			shopping();

	}

	private void logIn() {
		String id = inputString("ID를 입력해주세요");
		String pw = inputString("비밀번호를 입력해주세요");
		int index = userManager.checkUserInfo(id, pw);
		if (index == -1) {
			System.err.println("회원정보가 일치하지 않습니다");
			return;
		}

		log = index;
	}

	private void logOut() {
		log = -1;
		System.out.println("로그아웃 되었습니다");
	}

	private void shopping() {
		itemManager.showAllItem();
		int number = inputNumber("구매하실 상품을 선택해주세요");
		if (number < 0 || number > itemManager.getItemSize()) {
			System.err.println("올바른 상품을 골라주세요");
			return;
		}
		int quantity = inputNumber("구매하실 개수를 입력해주세요");
		if (quantity < 1 || quantity > 99) {
			System.err.println("올바른 수량을 골라주세요");
			return;
		}
		addItem(number, quantity);
	}

	private void addItem(int number, int quantity) {
		User user = userManager.getUser(log);
		Item item = itemManager.getItem(number);
		item.setQuantity(quantity);
		Cart cart = user.getCart();
		cart.addItemToCart(item);
	}

	private void printMyPage() {
		System.out.println("[1]장바구니");
		System.out.println("[2]항목삭제");
		System.out.println("[3]수량수정");
		System.out.println("[4]결제");
	}

	private void runMyPage() {
		int sel = inputNumber("메뉴를 선택해주세요");
		if (sel == CART)
			printMyCart();
		else if (sel == DELETE)
			removeItem();
		else if (sel == MODIFY)
			modifyItemQuantity();
		else if (sel == PAYMENT)
			payment();

	}

	private void printMyCart() {
		User user = userManager.getUser(log);
		Cart cart = user.getCart();
		for (int i = 0; i < cart.cartSize(); i++) {
			Item item = cart.getItem(i);
			System.out.println(item);
		}
	}

	private void removeItem() {
		printMyCart();
		User user = userManager.getUser(log);
		Cart cart = user.getCart();
		int index = inputNumber("지우실 상품의 번호를 입력해주세요") - 1;
		if (index < 0 || index > cart.cartSize()) {
			System.err.println("없는상품입니다");
			return;
		}
		cart.removeCartItem(index);
	}

	private void modifyItemQuantity() {
		User user = userManager.getUser(log);
		Cart cart = user.getCart();
		int index = inputNumber("수정하실상품의 번호를 입력해주세요") - 1;
		if (index < 0 || index > cart.cartSize()) {
			System.err.println("없는상품입니다");
			return;
		}
		Item item = cart.getItem(index);
		int quantity = inputNumber("수정하실상품의 번호를 입력해주세요") - 1;
		if (quantity < 1 || quantity > 99 || item.getQuantity() == quantity) {
			System.err.println("올바른 수량을 골라주세요");
			return;
		}
		item.setQuantity(quantity);
	}

	private void payment() {
		printMyCart();
		User user = userManager.getUser(log);
		Cart cart = user.getCart();
		int total = cart.addAllItemPrice();
		System.out.printf("총금액은 %d 원입니다\n", total);
		String pay = inputString("결제하시겠습니까? Y/N");
		if (pay.equals("Y")) {
			this.total += total;
			cart.removeAllItem();
		}
	}
	//관리자
	private void printAdminMenu() {
		System.out.println("[1]등록");
		System.out.println("[2]삭제");
		System.out.println("[3]수정");
		System.out.println("[4]조회");
	}
	
	private void runAdminMenu() {
		int sel = inputNumber("메뉴를 선택해주세요");
		if (sel == REGISTER)
			registItem();
		else if (sel == DELETE_ITEM)
			checkTotal();
		else if (sel == MODIFY_ITEM)
			modifyItem();
		else if (sel == TOTAL)
			checkTotal();
	}
	private void registItem() {
		itemManager.addItem();
	}
	private void modifyItem() {
		
	}
	private void checkTotal() {

	}



	public void run() {
		// 유저 -
		// ㄴ 회원가입 [O]
		// ㄴ 탈퇴 [X]
		// ㄴ 로그인 [X]
		// ㄴ 로그아웃 [X]
		// ㄴ 쇼핑하기 [X]
		// ㄴ 마이페이지
		// ㄴ 내장바구니 [X]
		// ㄴ 항목삭제 [X]
		// ㄴ 수량수정 [X]
		// ㄴ 결제 [X]
		// 파일
		// ㄴ 자동저장 [X]
		// ㄴ 자동로드 [X]

		// 관리자 -
		// ㄴ 아이템
		// ㄴ 등록 [X]
		// ㄴ 삭제 [X]
		// ㄴ 수정 [X]
		// ㄴ 조회(총 매출) [X]
	}
}
