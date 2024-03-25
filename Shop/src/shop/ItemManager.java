package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemManager {
	private Scanner scan = new Scanner(System.in);

	private ArrayList<Item> list = new ArrayList<>();

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
		String name = inputString("추가할 아이템을 입력해주세요");
		int index = findItemIndex(name);
		if (index != -1) {
			System.err.println("이미 존재하는 아이템입니다");
			return;
		}
		int price = inputNumber("가격을 입력해주세요");
		Item item = new Item(name, price);
		list.add(item);

	}
	public void addItem(Item item) {
		list.add(item);
	}
	public void modifyItem() {
		String name1 = inputString("수정할 아이템을 입력해주세요");
		int index = findItemIndex(name1);

		if (index == -1) {
			System.err.println("입력하신 아이템이 존재하지않습니다");
			return;
		}
		String name2 = inputString("수정할 아이템이름을 입력해주세요");
		int price = inputNumber("수정할 가격을 입력해주세요");
		if (price < 1) {
			System.err.println("올바른 가격을 입력해주세요");
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
			System.err.println("숫자만 입력하세요 ");
		}
		return number;
	}

	private String inputString(String message) {
		System.out.println(message);
		return scan.next();
	}
}
