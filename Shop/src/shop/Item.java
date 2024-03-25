package shop;

public class Item {
	private String name;
	private int quantity,price;
	public Item(String name) {
		this.name = name;
	}
	public Item(String name,int price) {
		this.name = name;
		this.price = price;
	}
	public Item(String name,int price,int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public int getPrice() {
		return this.price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	public Item clone() {
		return new Item(this.name);
	}
	
	
	@Override
	public String toString() {
		return "["+ name + ":" + price+"¿ø" +"] ";
	}
}
