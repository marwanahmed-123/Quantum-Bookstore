package books;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Book> books;
    private int booksCount;
    public Inventory(){
        books = new ArrayList<Book>();
        booksCount=0;
    }
    public int getBooksCount() {
        return booksCount;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }
    public void addBook(Book book) {
        books.add(book);
        booksCount++;
    }
    public Book getBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
    public void removeBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                booksCount--;
                return;
            }else {
                throw new IllegalStateException("Book not found");
            }
        }
    }
}
