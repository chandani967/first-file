import java.util.ArrayList;
import java.util.Scanner;

class Book {
  private String title;
  private String author;

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }
}

class Library {
  private ArrayList<Book> books;

  public Library() {
    this.books = new ArrayList<>();
  }

  public void addBook(String title, String author) {
    Book book = new Book(title, author);
    books.add(book);
    System.out.println("Book \"" + title + "\" by " + author + " added to the library.");
  }

  public void searchByTitle(String title) {
    boolean found = false;
    for (Book book : books) {
      if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
        System.out.println("\"" + book.getTitle() + "\" by " + book.getAuthor());
        found = true;
      }
    }
    if (!found) {
      System.out.println("No books found with title \"" + title + "\".");
    }
  }

  public void searchByAuthor(String author) {
    boolean found = false;
    for (Book book : books) {
      if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
        System.out.println("\"" + book.getTitle() + "\" by " + book.getAuthor());
        found = true;
      }
    }
    if (!found) {
      System.out.println("No books found by author \"" + author + "\".");
    }
  }

  public void listBooks() {
    if (books.isEmpty()) {
      System.out.println("The library is empty.");
    } else {
      System.out.println("Library Catalog:");
      for (Book book : books) {
        System.out.println("\"" + book.getTitle() + "\" by " + book.getAuthor());
      }
    }
  }
}

public class A {
  public static void main(String[] args) {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("\nLibrary Catalog System");
      System.out.println("1. Add a book");
      System.out.println("2. Search by title");
      System.out.println("3. Search by author");
      System.out.println("4. List all books");
      System.out.println("5. Exit");

      System.out.print("Choose an option: ");
      int option = scanner.nextInt();
      scanner.nextLine(); // Consume newline left-over

      switch (option) {
        case 1:
          System.out.print("Enter book title: ");
          String title = scanner.nextLine();
          System.out.print("Enter book author: ");
          String author = scanner.nextLine();
          library.addBook(title, author);
          break;
        case 2:
          System.out.print("Enter book title to search: ");
          title = scanner.nextLine();
          library.searchByTitle(title);
          break;
        case 3:
          System.out.print("Enter author to search: ");
          author = scanner.nextLine();
          library.searchByAuthor(author);
          break;
        case 4:
          library.listBooks();
          break;
        case 5:
          System.out.println("Goodbye!");
          scanner.close();
          return;
        default:
          System.out.println("Invalid option. Please choose a valid option.");
      }
    }
  }
}
 // Library Management
