package books;

import java.time.Year;

public class PaperBook extends Book implements Purchasable {
    private int stock;
    private String address;
    public PaperBook(String title, String isbn, String author, int publishedDate, int stock,double price) {
        super(title, isbn, author, publishedDate);
        this.stock = stock;
        this.price = price;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void purchase() {
        if (stock <= 0) {
            throw new IllegalStateException("Out of stock");
        }
        System.out.println(this.getTitle()+" is pending  to "+ address);
    }
    public void purchase(int quantity) {
        if (quantity <= 0) {
            throw new IllegalStateException("Invalid quantity");
        } else if (quantity > this.stock) {
            throw new  IllegalStateException("Only " + this.stock + " items available");
        } else {
            this.stock -= quantity;
        }
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        this.price = price;
    }
}
