package shop;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Item>list;
	public Cart() {
		list = new ArrayList<>();
	}
	
	public void addItemToCart(Item item) {
		list.add(item);
	}
	
	public Item getItem(int index) {
		return list.get(index).clone();
	}
	
	public int cartSize() {
		return list.size();
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
	public void removeCartItem(int index) {
		list.remove(index);
	}
}
