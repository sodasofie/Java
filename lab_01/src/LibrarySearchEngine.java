import java.util.ArrayList;
public class LibrarySearchEngine {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public Book findBookByName(String name) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    public void removeBookByIsbn(String isbn) {
        boolean bookRemoved = false;

        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                bookRemoved = true;
                System.out.println("Книга за номером ISBN: " + isbn + " була видалена.");
                break;
            }
        }

        if (!bookRemoved) {
            System.out.println("Книги з номером ISBN: " + isbn + " не існує в бібліотеці.");
        }
    }}