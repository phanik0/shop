package shop;

import java.util.ArrayList;

public class ItemManager {
	private ArrayList<Item>list;
	
	public void showAllItem() {
		for(int i = 0 ; i<list.size();i++) {
			Item item = list.get(i);
			System.out.print(item);
		}
	}
	public void addItem(int log,int index) {
		if(index > list.size() || index <0) {
			System.err.println("올바른 상품을 선택해주세요");
			return;
		}
		User user = 
	}
	public int getItemSize() {
		return list.size();
	}
	
	public Item getItem(int index) {
		return list.get(index).clone();
	}
}
