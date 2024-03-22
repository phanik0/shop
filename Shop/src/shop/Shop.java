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
		int number = 0;
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("���ڸ� �Է��ϼ��� ");
		}
		return number;
	}

	private String inputString(String message) {
		System.out.println(message);
		return scan.next();
	}

	private void printMainMenu() {
		System.out.println("[1]�����޴�");
		System.out.println("[2]�����ڸ޴�");
	}

	private void runMainMenu() {
		int sel = inputNumber("�޴��� �������ּ���");
		if (sel == USER)
			runUserMenu();
		else if (sel == ADMIN)
			runAdminMenu();

	}

	private void printUserMenu() {
		System.out.println("[1]ȸ������");
		System.out.println("[2]ȸ��Ż��");
		System.out.println("[3]�α���");
		System.out.println("[4]�α׾ƿ�");
		System.out.println("[5]�����ϱ�");
	}

	private void runUserMenu() {
		int sel = inputNumber("�޴��� �������ּ���");
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
		String id = inputString("ID�� �Է����ּ���");
		String pw = inputString("��й�ȣ�� �Է����ּ���");
		int index = userManager.checkUserInfo(id, pw);
		if (index == -1) {
			System.err.println("ȸ�������� ��ġ���� �ʽ��ϴ�");
			return;
		}

		log = index;
	}

	private void logOut() {
		log = -1;
		System.out.println("�α׾ƿ� �Ǿ����ϴ�");
	}

	private void shopping() {
		itemManager.showAllItem();
		int number = inputNumber("�����Ͻ� ��ǰ�� �������ּ���");
		if(number < 0 || number > itemManager.getItemSize()) {
			System.err.println("�ùٸ� ��ǰ�� ����ּ���");
			return;
		}
		addItem(number);
	}
	private void addItem(int number) {
		User user = userManager.getUser(log);
		Item item = itemManager.getItem(number);
		Cart cart = user.getCart();
		cart.addItemToCart(item);
		
		
	}
	private void runAdminMenu(){
		int sel = inputNumber("�޴��� �������ּ���");
		if(sel == ITEM)
			userManager.addUser();
		else if(sel == CHECK)
			checkTotal();
	}
	
	private void checkTotal() {
		
	}
	private void printMyPage() {
		System.out.println("[1]��ٱ���");
		System.out.println("[2]�׸����");
		System.out.println("[3]��������");
		System.out.println("[4]����");
	}

	private void printAdminMenu() {
		System.out.println("[1]������");
		System.out.println("[2]��ȸ");
	}

	private void printItemMenu() {
		System.out.println("[1]���");
		System.out.println("[1]����");
		System.out.println("[1]����");
	}

	public void run() {
		// ���� -
		// �� ȸ������ [O]
		// �� Ż�� [X]
		// �� �α��� [X]
		// �� �α׾ƿ� [X]
		// �� �����ϱ� [X]
		// �� ����������
		// 	�� ����ٱ��� [X]
		// �� �׸���� [X]
		// �� �������� [X]
		// �� ���� [X]
		// ����
		// �� �ڵ����� [X]
		// �� �ڵ��ε� [X]

		// ������ -
		// �� ������
		// �� ��� [X]
		// �� ���� [X]
		// �� ���� [X]
		// �� ��ȸ(�� ����) [X]
	}
}
