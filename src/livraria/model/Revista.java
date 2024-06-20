package livraria.model;

public class Revista extends Produto {
    private String edition;

    public Revista(String title, double price, int quantity, String edition) {
        super(title, price, quantity);
        this.edition = edition;
    }

    public String getEdition() {
        return edition;
    }

    @Override
    public String getCategory() {
        return "Revista";
    }

    @Override
    public void displayDetails() {
        System.out.println("Revista [Código: " + getCode() + ", Título: " + getTitle() + ", Edição: " + edition + ", Preço: "
                + getPrice() + ", Quantidade: " + getQuantity() + "]");
    }
}