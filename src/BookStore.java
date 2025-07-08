import MailService.Mail;
import MailService.PendingMails;
import ShipmentService.PendingShipments;
import ShipmentService.Shipment;
import books.*;

import java.util.ArrayList;
import java.util.Scanner;
public class BookStore {
    public void startBookStore() {
        boolean exit = false;
        PendingMails mails = new PendingMails();
        PendingShipments shipments = new PendingShipments();
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the bookstore!");
        while (!exit) {
            System.out.println("Please select an option:");
            System.out.println("1. Add a book");
            System.out.println("2. remove a book");
            System.out.println("3. view books");
            System.out.println("4. Buy a Paper Book");
            System.out.println("5. Buy an EBook Book");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                {
                    System.out.println("Enter 1 to add an E-Book\n2 to add a Paper Book\n3 to add a Showcase/DemoBook");
                    int type = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter book title");
                    String title = scanner.nextLine();
                    System.out.println("Enter book isbn");
                    String isbn = scanner.nextLine();
                    System.out.println("Enter book author");
                    String author = scanner.nextLine();
                    System.out.println("Enter book published year");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    if (type == 1){
                        System.out.println("Enter book price");
                        double price = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Enter book file type");
                        String fileType = scanner.nextLine();
                        EBook book = new EBook(title, isbn, author, year, fileType,price);
                        inventory.addBook(book);
                    }
                    else if (type == 2){
                        System.out.println("Enter book price");
                        double price = scanner.nextDouble();
                        System.out.println("Enter book stock");
                        int stock = scanner.nextInt();
                        scanner.nextLine();
                        PaperBook book = new PaperBook(title, isbn, author, year, stock,price);
                        inventory.addBook(book);
                    }
                    else if (type == 3){
                        ShowcaseBook book = new ShowcaseBook(title, isbn, author, year);
                        inventory.addBook(book);
                    } else {
                        System.out.println("invalid choice");
                    }
                }
                break;
                case 2:
                {
                    System.out.println("Enter book isbn");
                    String isbn = scanner.nextLine();
                    try {
                        inventory.removeBook(isbn);
                    } catch (IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 3:
                {
                    ArrayList<Book> books = inventory.getBooks();
                    for (Book book : books) {
                        System.out.println("Book title: " + book.getTitle());
                        System.out.println("Book ISBN: " + book.getIsbn());
                        System.out.println("Book author: " + book.getAuthor());
                        System.out.println("Book publish date:" + book.getPublishedDate());
                        if (book instanceof EBook) {
                            EBook ebook = (EBook) book;
                            System.out.println("Book file type: " + ebook.getFileType());
                            System.out.println("Book price: " + ebook.getPrice());
                        } else if (book instanceof PaperBook) {
                            PaperBook pbook = (PaperBook) book;
                            System.out.println("Book stock: " + pbook.getStock());
                            System.out.println("Book price: " + pbook.getPrice());
                        }
                    }
                }
                break;
                case 4:
                {
                    System.out.println("Enter paper book isbn");
                    String isbn = scanner.nextLine();
                    try {
                        Book book = inventory.getBook(isbn);
                        if (book instanceof PaperBook) {
                            PaperBook pbook = (PaperBook) book;
                            System.out.println("Enter quantity");
                            int quantity = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Enter shipment address");
                            String address = scanner.nextLine();
                            pbook.purchase(quantity);
                            Shipment shipment = new Shipment(pbook, quantity, address);
                            shipments.addShipment(shipment);
                            if (((PaperBook) book).getStock() ==0) {
                                inventory.removeBook(isbn);
                            }
                        }
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
                case 5:
                {
                    System.out.println("Enter EBook isbn");
                    String isbn = scanner.nextLine();
                    try {
                        Book book = inventory.getBook(isbn);
                        if (book instanceof EBook) {
                            EBook ebook = (EBook) book;
                            System.out.println("Enter mail address");
                            String address = scanner.nextLine();
                            ebook.purchase();
                            Mail mail = new Mail(ebook, address);
                            mails.addMail(mail);
                        }
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6:
                    exit = true;
                    break;
            }
        }
    }
}
