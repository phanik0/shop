package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
	private Scanner scan = new Scanner(System.in);
	private ArrayList<User>users;
	private int inputNumber(String message) {
		System.out.println(message);
		int number = 0 ;
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
	private void addUser() {
		
		String id = inputString("���̵� �Է����ּ���");
		if(!checkIdDuplication(id)) {
			System.err.println("�ߺ��� ���̵��Դϴ�");
			return;
		}
		String pw = inputString("��й�ȣ�� �Է����ּ���");
		
		User user = new User(id,pw);
		users.add(user);
	}
	
	private boolean checkIdDuplication(String id) {
		
		for(int i = 0 ; i<users.size();i++) {
		User user = users.get(i);
		if(user.getId().equals(id))
			return false;
		}
		return true;
	}
}
