package livraria.model;

public abstract class Produto {
	private static int nextCode = 1;

	protected int code;
	protected String title;
	protected double price;
	protected int quantity;

	public Produto(String title, double price, int quantity) {
		this.code = nextCode++;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}

	public int getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public abstract String getCategory();

	public abstract void displayDetails();
}