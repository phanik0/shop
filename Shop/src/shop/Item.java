package shop;

public class Item {
	private String name;
	private int quantity;
	public Item(String name) {
		this.name = name;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Item clone() {
		return new Item(this.name);
	}
	
	
	@Override
	public String toString() {
		return "["+ name+"] ";
	}
}
