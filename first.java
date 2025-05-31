import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// A simple Book class to hold title and author
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title.trim();
        this.author = author.trim();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Nicely formatted book output
    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}

// The main catalog system where users interact
public class first {
    private static List<Book> catalog = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("📚 Welcome to the Library Catalog!");

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add a Book");
            System.out.println("2. Search for a Book");
            System.out.println("3. List All Books");
            System.out.println("4. Exit");

            System.out.print("Choose an option (1-4): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addBook();
                    break;
                case "2":
                    searchBooks();
                    break;
                case "3":
                    listBooks();
                    break;
                case "4":
                    System.out.println("👋 Goodbye! Thanks for using the Library Catalog.");
                    running = false;
                    break;
                default:
                    System.out.println("⚠ Please enter a valid option (1-4).");
            }
        }
    }

    // Method to add a book to the catalog
    private static void addBook() {
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter the book author: ");
        String author = scanner.nextLine();

        Book newBook = new Book(title, author);
        catalog.add(newBook);

        System.out.println("✅ Book added: " + newBook);
    }

    // Method to search for books by title or author
    private static void searchBooks() {
        System.out.print("Enter title or author to search: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;
        System.out.println("\n🔍 Search results:");
        for (Book book : catalog) {
            if (book.getTitle().toLowerCase().contains(keyword) ||
                book.getAuthor().toLowerCase().contains(keyword)) {
                System.out.println(" - " + book);
                found = true;
            }
        }

        if (!found) {
            System.out.println("❌ No books found matching your search.");
        }
    }

    // Method to list all books
    private static void listBooks() {
        if (catalog.isEmpty()) {
            System.out.println("📭 No books in the catalog.");
        } else {
            System.out.println("\n📚 All Books in the Catalog:");
            for (Book book : catalog) {
                System.out.println(" - " + book);
            }
        }
    }
}
