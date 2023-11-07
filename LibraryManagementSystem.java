import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    String title;
    String author;
    String publisher;
    String ISBN;
    String category;
    int availability;

    public Book(String title, String author, String publisher, String ISBN, String category, int availability) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.category = category;
        this.availability = availability;
    }

    public void updateAvailability(int newAvailability) {
        this.availability = newAvailability;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book Availability");
            System.out.println("3. Search for Books");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String ISBN = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter availability: ");
                    int availability = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    Book newBook = new Book(title, author, publisher, ISBN, category, availability);
                    books.add(newBook);
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter ISBN of the book to update availability: ");
                    String searchISBN = scanner.nextLine();
                    System.out.print("Enter new availability: ");
                    int newAvailability = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    for (Book book : books) {
                        if (book.ISBN.equals(searchISBN)) {
                            book.updateAvailability(newAvailability);
                            System.out.println("Availability updated successfully.");
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter a keyword to search for books: ");
                    String keyword = scanner.nextLine().toLowerCase();

                    System.out.println("Search Results:");
                    for (Book book : books) {
                        if (book.title.toLowerCase().contains(keyword)
                            || book.author.toLowerCase().contains(keyword)
                            || book.category.toLowerCase().contains(keyword)
                            || book.publisher.toLowerCase().contains(keyword)) {
                            System.out.println("Title: " + book.title);
                            System.out.println("Author: " + book.author);
                            System.out.println("ISBN: " + book.ISBN);
                            System.out.println("Availability: " + book.availability);
                            System.out.println();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}
