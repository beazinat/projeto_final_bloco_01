package livraria.model;

public abstract class Produto {
    private static int nextCode = 1;

    private int code;
    private String title;
    private double price;
    private int quantity;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract void displayDetails();
}