package books;

public abstract class Book {
    protected String title;
    protected String isbn;
    protected String author;
    protected int publishedDate;
    protected double price;
    public Book(String title, String isbn, String author, int publishedDate) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publishedDate = publishedDate;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPublishedDate() {
        return publishedDate;
    }
    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }
}
