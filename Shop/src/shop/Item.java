package shop;

public class Item {
	private String name;
	public Item(String name) {
		this.name = name;
	}
	public Item clone() {
		return new Item(this.name);
	}
	@Override
	public String toString() {
		return "["+ name+"] ";
	}
}
