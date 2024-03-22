package shop;

public class User {
	private String name, id , pw;
	private Cart cart;
	public User(String name, String id ,String pw ) {
		this.name = name;
		this.id = id;
		this.pw = pw;
	}
	
	public String getName() {
		return this.name;
	}
	public String getId() {
		return this.id;
	}
	
	public String getPw() {
		return this.pw;
	}
}
