public class Book {
    private String name;
    private String author;
    private String isbn_number;
    private int year;

    public Book(String name, String author, String isbn, int year) {
        this.name = name;
        this.author = author;
        this.isbn_number = isbn;
        this.year = year;
    }

    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn_number;
    }
    public int getYear() {
        return year;
    }
}