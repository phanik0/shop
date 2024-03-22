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
	
	public Item getItem(int index) {
		return list.get(index).clone();
	}
	
	public int cartSize() {
		return list.size();
	}
}
