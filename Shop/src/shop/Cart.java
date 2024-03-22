package shop;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Item>list;
	public Cart() {
		list = new ArrayList<>();
	}
	
	public void addItemToCart(Item item) {
		list.add(item);
	}
}
