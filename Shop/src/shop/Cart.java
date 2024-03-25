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
			System.err.println("���ڸ� �Է��ϼ��� ");
		}
		return number;
	}
	public void removeCartItem(int index) {
		list.remove(index);
	}
	public void removeAllItem() {
		list.clear();
	}
	public int addAllItemPrice() {
		int price = 0 ;
		for(int i = 0 ; i<list.size();i++) {
			Item item = list.get(i);
			price += item.getPrice();
		}
		return price;
	}
	@Override
	public String toString() {
		String info = "";
		for(int i = 0 ; i<list.size();i++) {
			Item item = list.get(i);
			info += item.getName() + ":" + item.getPrice()+"\n";
		}
		return info;
	}
	
}
