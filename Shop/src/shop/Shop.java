package shop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	private String brand;
	private Scanner scan = new Scanner(System.in);
	private UserManager userManager;
	private ItemManager itemManager;
	private File file;
	private FileReader fr;
	private FileWriter fw;
	private BufferedReader br;
	private String fileName;
	private final int USER = 1;
	private final int FILE = 2;
	private final int ADMIN = 2;

	private final int JOIN = 1;
	private final int OUT = 2;
	private final int LOG_IN = 3;
	private final int LOG_OUT = 4;
	private final int SHOPPING = 5;
	private final int MY_PAGE = 6;

	private final int CART = 1;
	private final int DELETE = 2;
	private final int MODIFY = 3;
	private final int PAYMENT = 4;

	private final int ITEM = 1;
	private final int CHECK = 2;

	private final int REGISTER = 1;
	private final int DELETE_ITEM = 2;
	private final int MODIFY_ITEM = 3;
	private final int TOTAL = 4;

	private int total;
	private int log;

	public Shop(String brand) {
		this.brand = brand;
	}

	private void setSystem() {
		fileName = "shop.txt";
		file = new File(fileName);
		userManager = new UserManager();
		itemManager = new ItemManager();
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
		for(int i = 0 ; i<userManager.getSize();i++) {
			System.out.println(userManager.getUser(i));
		}
		for(int i = 0 ; i<itemManager.getItemSize();i++) {
			System.out.println(itemManager.getItem(i));
		}
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
		System.out.println("[6]����������");
	}

	private void runUserMenu() {
		printUserMenu();
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
		else if (sel == MY_PAGE)
			runMyPage();

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
		int number = inputNumber("�����Ͻ� ��ǰ�� �������ּ���")-1;
		if (number < 0 || number > itemManager.getItemSize()) {
			System.err.println("�ùٸ� ��ǰ�� ����ּ���");
			return;
		}
		int quantity = inputNumber("�����Ͻ� ������ �Է����ּ���");
		if (quantity < 1 || quantity > 99) {
			System.err.println("�ùٸ� ������ ����ּ���");
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
		System.out.println("[1]��ٱ���");
		System.out.println("[2]�׸����");
		System.out.println("[3]��������");
		System.out.println("[4]����");
	}

	private void runMyPage() {
		printMyPage();
		int sel = inputNumber("�޴��� �������ּ���");
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
			System.out.println(cart);
		}
	}

	private void removeItem() {
		printMyCart();
		User user = userManager.getUser(log);
		Cart cart = user.getCart();
		int index = inputNumber("����� ��ǰ�� ��ȣ�� �Է����ּ���") - 1;
		if (index < 0 || index > cart.cartSize()) {
			System.err.println("���»�ǰ�Դϴ�");
			return;
		}
		cart.removeCartItem(index);
	}

	private void modifyItemQuantity() {
		User user = userManager.getUser(log);
		Cart cart = user.getCart();
		int index = inputNumber("�����Ͻǻ�ǰ�� ��ȣ�� �Է����ּ���") - 1;
		if (index < 0 || index > cart.cartSize()) {
			System.err.println("���»�ǰ�Դϴ�");
			return;
		}
		Item item = cart.getItem(index);
		int quantity = inputNumber("�����Ͻǻ�ǰ�� ��ȣ�� �Է����ּ���") - 1;
		if (quantity < 1 || quantity > 99 || item.getQuantity() == quantity) {
			System.err.println("�ùٸ� ������ ����ּ���");
			return;
		}
		item.setQuantity(quantity);
	}

	private void payment() {
		printMyCart();
		User user = userManager.getUser(log);
		Cart cart = user.getCart();
		int total = cart.addAllItemPrice();
		System.out.printf("�ѱݾ��� %d ���Դϴ�\n", total);
		String pay = inputString("�����Ͻðڽ��ϱ�? Y/N");
		if (pay.equals("Y")) {
			this.total += total;
			cart.removeAllItem();
		}
	}

	// ������
	private void printAdminMenu() {
		System.out.println("[1]���");
		System.out.println("[2]����");
		System.out.println("[3]����");
		System.out.println("[4]��ȸ");
	}

	private void runAdminMenu() {
		printAdminMenu();
		int sel = inputNumber("�޴��� �������ּ���");
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
		itemManager.modifyItem();
	}

	private void checkTotal() {
		System.out.printf("���� �� ������ %d�� �Դϴ�\n", total);
	}

	private void saveFile() {
		String info = setInfo();
		try {
			fw = new FileWriter(file);
			fw.write(info);
			fw.close();
			System.out.println("�������� ����");
		} catch (Exception e) {
			System.err.println("�����������");
		}
	}

	private String setInfo() {// ȸ������ : ���̵� ��й�ȣ ��ٱ���-�̸� ���� ����
								// ������ ���� : ������ ����
		String info = "";
		info += addUserInfo();
		info += "/\n";
		info += addItemInfo();

		return info;
	}

	private String addUserInfo() {
		String info = "";
		for (int i = 0; i < userManager.getSize(); i++) {
			User user = userManager.getUser(i);
			String id = user.getId();
			String pw = user.getPw();
			Cart cart = user.getCart();
			info += id + "," + pw + ",";
			for (int j = 0; j < cart.cartSize(); j++) {
				Item item = cart.getItem(j);
				if (j != cart.cartSize() - 1)
					info += item.getName() + "," + item.getQuantity() + ",";
				else
					info += item.getName() + "," + item.getQuantity();
			}
			info += "\n";

		}
		return info;
	}

	private String addItemInfo() {
		String info = "";
		for (int i = 0; i < itemManager.getItemSize(); i++) {
			Item item = itemManager.getItem(i);
			info += item.getName() + "," + item.getPrice() + "\n";
		}
		return info;
	}

	private void loadFile() {
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			boolean isUser = true;
			while (br.ready()) {
				String line = br.readLine();
				if (line.contains("/")) {
					isUser = false;
					continue;
				}

				if (isUser) {
					splitUserData(line);
				} else if(!isUser && !line.isEmpty())
					splitItemData(line);
			}
			fr.close();
			br.close();
			System.out.println("�ε强��");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("�ε����");
		}
	}

	private void splitUserData(String line) {
		String[] temp = line.split(",");
		String id = temp[0];
		String pw = temp[1];
		User user = new User(id, pw);
		Cart cart = user.getCart();
		for (int i = 2; i < temp.length; i += 3) {
			String name = temp[i];
			int price = Integer.parseInt(temp[i + 1]);
			int quantity = Integer.parseInt(temp[i + 2]);
			Item item = new Item(name, price, quantity);
			cart.addItemToCart(item);
		}
		userManager.addUser(user);
	}

	private void splitItemData(String line) {
		String[] temp = line.split(",");
		String name = temp[0];
		int price = Integer.parseInt(temp[1]);
		Item item = new Item(name, price);
		itemManager.addItem(item);

	}

	public void run() {
		setSystem();
		if (file.exists()) {
			loadFile();
		}
		while (true) {
			printMainMenu();
			runMainMenu();
			saveFile();
			// ���� -
			// �� ȸ������ [O]

			// �� Ż�� [X]
			// �� �α��� [X]
			// �� �α׾ƿ� [X]
			// �� �����ϱ� [X]
			// �� ����������
			// �� ����ٱ��� [X]
			// �� �׸���� [X]
			// �� �������� [X]
			// �� ���� [X]
			// ����
			// �� �ڵ����� [X]
			// �� �ڵ��ε� [X]
		}

		// ������ -
		// �� ������
		// �� ��� [X]
		// �� ���� [X]
		// �� ���� [X]
		// �� ��ȸ(�� ����) [X]
	}
}
