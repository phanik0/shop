package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemManager {
	private Scanner scan = new Scanner(System.in);
	
	private ArrayList<Item>list;
	public int getItemSize() {
		return list.size();
	}
	
	public void showAllItem() {
		for(int i = 0 ; i<list.size();i++) {
			Item item = list.get(i);
			System.out.print(item);
		}
	}
	public void addItem(int log,int index) {
		if(index > list.size() || index <0) {
			System.err.println("�ùٸ� ��ǰ�� �������ּ���");
			return;
		}
		User user = 
	}
	
	public Item getItem(int index) {
		return list.get(index).clone();
	}
	
	public void removeCartItem(Cart cart) {
		int index = inputNumber("����� ��ǰ�� ��ȣ�� �Է����ּ���");
		
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
}
