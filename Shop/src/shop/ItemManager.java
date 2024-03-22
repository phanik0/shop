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
	public void addItem() {
		String name = inputString("추가할 아이템을 입력해주세요");
		for(int i = 0 ; i<list.size();i++) {
			Item item = list.get(i);
			if(item.getName().equals(name)) {
				System.err.println("이미 존재하는 아이템입니다");
				return;
			}
		}
		int price = inputNumber("가격을 입력해주세요");
		Item item = new Item(name,price);
		list.add(item);
		
	}
	
	public Item getItem(int index) {
		return list.get(index).clone();
	}
	
	public void removeCartItem(Cart cart) {
		int index = inputNumber("지우실 상품의 번호를 입력해주세요");
		
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
