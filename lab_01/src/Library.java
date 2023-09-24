import java.util.ArrayList;

public class Library {
    public static void main(String[] args) {
        // Створення книг і бібліотеки
        Book book1 = new Book("Книга 1", "Автор 1-нак", "122333444", 2005);
        Book book2 = new Book("Книга 2", "Автор 2-гий", "3793000911", 2019);
        Book book3 = new Book("Книга 3 'Малий Кобзар' ", "Тарас Шевченко", "480310200", 1979);
        Book book4 = new Book("Книга 4", "Автор 4-тий", "1098736844", 2003);

        LibrarySearchEngine librarySearchEngine = new LibrarySearchEngine();

        // Додавання книг
        librarySearchEngine.addBook(book1);
        librarySearchEngine.addBook(book2);
        librarySearchEngine.addBook(book3);

        // Показ всіх книг
        System.out.println();
        System.out.println("Всі наявні книги:");

        ArrayList<Book> allBooks = librarySearchEngine.getAllBooks();
        for (Book book : allBooks) {
            System.out.println();
            System.out.println("Назва: " + book.getName());
            System.out.println("Автор: " + book.getAuthor());
            System.out.println("Номер ISBN: " + book.getIsbn());
            System.out.println("Рік видання: " + book.getYear());
        }

        // Пошук книги за назвою
        String searchName = "Книга 4";
        Book foundBook = librarySearchEngine.findBookByName(searchName);
        if (foundBook != null) {
            System.out.println();
            System.out.println("Знайдена книга за назвою \"" + searchName + "\": " + foundBook.getName());
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Книга за назвою " + searchName + " не була знайдена. ");
            System.out.println();
        }

        // Видалення книги за ISBN
        String isbnToRemove = "122333444";
        librarySearchEngine.removeBookByIsbn(isbnToRemove);
        System.out.println();

        // Перевірка видалення книги
        System.out.println("Всі наявні книги:");
        allBooks = librarySearchEngine.getAllBooks();
        for (Book book : allBooks) {
            System.out.println();
            System.out.println("Назва: " + book.getName());
            System.out.println("Автор: " + book.getAuthor());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Рік видання: " + book.getYear());
            System.out.println();
        }
    }
}

