package MailService;

import books.EBook;
import books.PaperBook;

public class Mail {
    private EBook book;
    private double price;
    private String email;
    public Mail(EBook book, String email) {
        this.book = book;
        this.email = email;
        this.price = book.getPrice();
    }
    public String getEmail() {
        return email;
    }
    public double getPrice() {
        return price;
    }
    public EBook getBook() {
        return book;
    }

}
