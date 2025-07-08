package ShipmentService;

import books.PaperBook;
public class Shipment {
    private PaperBook book;
    private int quantity;
    private double price;
    private String address;
    public Shipment(PaperBook book, int quantity, String address) {
        this.book = book;
        this.quantity = quantity;
        this.price = book.getPrice() * quantity;
        this.address = address;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getAddress() {
        return address;
    }
    public double getPrice() {
        return price;
    }
    public PaperBook getBook() {
        return book;
    }
}
