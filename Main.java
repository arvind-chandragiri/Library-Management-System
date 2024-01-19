import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book searchBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<Book> searchBookByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public void issueBook(Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            // Code to store student details to whom the book has been issued.
            System.out.println("Book with ID " + book.getId() + " has been issued.");
        } else {
            System.out.println("Sorry, the book is not available for issue.");
        }
    }

    public void returnBook(Book book) {
        if (!book.isAvailable()) {
            book.setAvailable(true);
            // Code to remove student details who returned the book.
            System.out.println("Book with ID " + book.getId() + " has been returned.");
        } else {
            System.out.println("The book is already available.");
        }
    }

    public void listAllBooks() {
        for (Book book : books) {
            System.out.println( book.getTitle() + " by " + book.getAuthor() + " (ID: " + book.getId() + ")");
        }
    }

    // Other methods as needed
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Adding some initial books to the library
        library.addBook(new Book(1, "Java Programming", "John Doe"));
        library.addBook(new Book(2, "Python Basics", "Jane Smith"));
        library.addBook(new Book(3, "Data Structures and Algorithms", "Alice Johnson"));

        boolean running = true;
        while (running) {
            System.out.println("Select an option:");
            System.out.println("1. Add a book");
            System.out.println("2. Search a book by ID");
            System.out.println("3. Search books by title");
            System.out.println("4. Issue a book");
            System.out.println("5. Return a book");
            System.out.println("6. List all books");
            System.out.println("7. Exit");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the book ID:");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.println("Enter the book title:");
                    String bookTitle = scanner.nextLine();
                    System.out.println("Enter the author name:");
                    String authorName = scanner.nextLine();
                    library.addBook(new Book(bookId, bookTitle, authorName));
                    break;
                case 2:
                    System.out.println("Enter the book ID:");
                    int searchId = scanner.nextInt();
                    Book foundBook = library.searchBookById(searchId);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook.getTitle() + " by " + foundBook.getAuthor());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the book title:");
                    String searchTitle = scanner.nextLine();
                    List<Book> foundBooks = library.searchBookByTitle(searchTitle);
                    if (!foundBooks.isEmpty()) {
                        System.out.println("Books found:");
                        for (Book book : foundBooks) {
                            System.out.println(book.getTitle() + " by " + book.getAuthor() + " (ID: " + book.getId() + ")");
                        }
                    } else {
                        System.out.println("No books found.");
                    }
                    break;
                case 4:
                    // Code to issue a book
                    
                    break;
                case 5:
                    // Code to return a book
                   
                    break;
                case 6:
                    library.listAllBooks();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        scanner.close();
    }
}