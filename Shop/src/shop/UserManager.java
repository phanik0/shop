package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
	private Scanner scan = new Scanner(System.in);
	private ArrayList<User> users = new ArrayList<>();
	public User getUser(int index) {
		User user = users.get(index).clone();
		return user;
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
	public int getSize() {
		return users.size();
	}
	public void addUser() {

		String id = inputString("���̵� �Է����ּ���");
		if(users.size()>1) {
		if (!checkIdDuplication(id)) {
			System.err.println("�ߺ��� ���̵��Դϴ�");
			return;
		}
		}
		String pw = inputString("��й�ȣ�� �Է����ּ���");

		User user = new User(id, pw);
		users.add(user);
	}
	public void addUser(User user) {
		users.add(user);
	}
	public void removeUser(int index) {
		String pw = inputString("��й�ȣ�� �Է����ּ���");
		User user = users.get(index);
		if (!user.getPw().equals(pw)) {
			System.err.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
			return;
		}
		users.remove(index);
	}

	

	private boolean checkIdDuplication(String id) {

		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if (user.getId().equals(id))
				return false;
		}
		return true;
	}

	public int checkUserInfo(String id, String pw) {
		int index = -1;
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if (user.getId().equals(id) && user.getPw().equals(pw))
				return index = i;
		}
		return index;
	}
}
