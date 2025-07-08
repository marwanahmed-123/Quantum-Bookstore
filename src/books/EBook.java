package books;

import java.time.Year;

public class EBook extends Book implements Purchasable{
    private String fileType;
    private String email;
    public EBook(String title, String isbn, String author,  int publishedDate, String fileType,double price) {
        super( title,  isbn,  author,  publishedDate);
        this.fileType = fileType;
        this.price = price;
    }
    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void purchase() {
        System.out.println(this.getTitle()+" is sent to "+ email);
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(double price){
        this.price = price;
    }
}
