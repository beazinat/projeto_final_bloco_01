package livraria.model;

public class Livro extends Produto {
	private String author;
	private String genre;

	public Livro(String title, double price, int quantity, String author, String genre) {
		super(title, price, quantity);
		this.author = author;
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	@Override
	public String getCategory() {
		return "Livro";
	}

	@Override
	public void displayDetails() {
		System.out.println("Livro [Código: " + getCode() + ", Título: " + getTitle() + ", Autor: " + author
				+ ", Gênero: " + genre + ", Preço: " + getPrice() + ", Quantidade: " + getQuantity() + "]");
	}
}