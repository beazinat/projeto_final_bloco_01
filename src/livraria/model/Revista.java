package livraria.model;

public class Revista extends Produto {
	private String edition;

	public Revista(int code, String title, double price, int quantity, String edition) {
		super(code, title, price, quantity);
		this.edition = edition;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	@Override
	public void displayDetails() {
		System.out.println("Revista [Código: " + getCode() + ", Título: " + getTitle() + ", Edição: " + edition
				+ ", Preço: " + getPrice() + ", Quantidade: " + getQuantity() + "]");
	}
}