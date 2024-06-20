package livraria.model;

public class Livro extends Produto {
    private String author;
    private String genre;

    public Livro(int code, String title, double price, int quantity, String author, String genre) {
        super(code, title, price, quantity);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void displayDetails() {
        System.out.println("Livro [Código: " + code + ", Título: " + title + ", Autor: " + author + ", Gênero: " + genre + ", Preço: " + price + ", Quantidade: " + quantity + "]");
    }
}
