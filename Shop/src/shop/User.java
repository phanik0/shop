package shop;

public class User {
	private String id , pw;
	private Cart cart;
	public User(String id ,String pw ) {
		this.id = id;
		this.pw = pw;
		cart = new Cart();
	}
	
//	public String getName() {
//		return this.name;
//	}
	public String getId() {
		return this.id;
	}
	
	public String getPw() {
		return this.pw;
	}
	
	public Cart getCart() {
		return this.cart;
	}
	public User clone() {
		return new User(this.id, this.pw);
	}
}
