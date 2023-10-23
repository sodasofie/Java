import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private Item book;
    private Item dvd;
    private Patron patron;

    @BeforeEach
    void setUp() {
        library = new Library();
        book = new Book("Book Title", "123", "Author");
        dvd = new DVD("DVD Title", "456", 120);
        patron = new Patron("John", "789");
    }

    @Test
    void testAddItemToLibrary() {
        library.add(book);
        assertTrue(library.listAvailable().contains(book));
    }

    @Test
    void testRemoveItemFromLibrary() {
        library.add(book);
        library.remove(book);
        assertFalse(library.listAvailable().contains(book));
    }

    @Test
    void testRegisterPatron() {
        library.registerPatron(patron);
        assertTrue(library.getPatrons().contains(patron));
    }

    @Test
    void testLendItemToPatron() {
        library.add(book);
        library.registerPatron(patron);
        library.lendItem(patron, book);
        assertTrue(patron.getBorrowedItems().contains(book));
        assertTrue(book.isBorrowed());
    }

    @Test
    void testReturnItemToLibrary() {
        library.add(book);
        library.registerPatron(patron);
        library.lendItem(patron, book);
        library.returnItem(patron, book);
        assertFalse(patron.getBorrowedItems().contains(book));
        assertFalse(book.isBorrowed());
    }

    @Test
    void testListAvailableItems() {
        library.add(book);
        library.add(dvd);
        assertEquals(2, library.listAvailable().size());
    }

    @Test
    void testListBorrowedItems() {
        library.add(book);
        library.add(dvd);
        library.registerPatron(patron);
        library.lendItem(patron, book);
        library.lendItem(patron, dvd);
        assertEquals(2, library.listBorrowed().size());
    }
}