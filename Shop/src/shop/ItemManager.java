package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemManager {
	private Scanner scan = new Scanner(System.in);

	private ArrayList<Item> list;

	public int getItemSize() {
		return list.size();
	}

	public Item getItem(int index) {
		return list.get(index).clone();
	}

	private int findItemIndex(String name) {
		int index = -1;
		for (int i = 0; i < list.size(); i++) {
			Item item = list.get(i);
			if (item.getName().equals(name)) {
				index = i;
			}
		}
		return index;
	}

	public void showAllItem() {
		for (int i = 0; i < list.size(); i++) {
			Item item = list.get(i);
			System.out.print(item);
		}
	}

	public void addItem() {
		String name = inputString("�߰��� �������� �Է����ּ���");
		int index = findItemIndex(name);
		if (index != -1) {
			System.err.println("�̹� �����ϴ� �������Դϴ�");
			return;
		}
		int price = inputNumber("������ �Է����ּ���");
		Item item = new Item(name, price);
		list.add(item);

	}
	public void addItem(Item item) {
		list.add(item);
	}
	public void modifyItem() {
		String name1 = inputString("������ �������� �Է����ּ���");
		int index = findItemIndex(name1);

		if (index == -1) {
			System.err.println("�Է��Ͻ� �������� ���������ʽ��ϴ�");
			return;
		}
		String name2 = inputString("������ �������̸��� �Է����ּ���");
		int price = inputNumber("������ ������ �Է����ּ���");
		if (price < 1) {
			System.err.println("�ùٸ� ������ �Է����ּ���");
			return;
		}

		Item item2 = new Item(name2, price);
		list.set(index, item2);
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
}
