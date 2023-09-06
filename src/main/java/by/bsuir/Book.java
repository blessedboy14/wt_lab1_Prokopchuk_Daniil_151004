package by.bsuir;

import java.util.Objects;

public class Book implements Comparable{
    private String title;
    private String author;
    private int price;
    private static int edition;
    public int isbn;
    public Book(String title, String author, int price, int edition) {
        this.title = title;
        this.author = author;
        this.price = price;
        Book.edition = edition;
        this.isbn = this.title.hashCode();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    public static int getEdition() {
        return edition;
    }

    public Book(String title, String author, int price, int edition, int isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        Book.edition = edition;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "About book: title - " + this.title + ", author - " + this.author + ", price - " + this.price
                + ", edition - " + Book.edition;
    }

    @Override
    public boolean equals(Object obj) {
        try{
            Book book = (Book) obj;
            return (Objects.equals(this.title, book.title)) && (Objects.equals(this.author, book.author));
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (this.title.hashCode() * this.author.hashCode()) % (this.title.hashCode() + this.author.hashCode());
    }

    @Override
    public Book clone() {
        return new Book(this.title, this.author, this.price, Book.edition);
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.isbn, ((Book) o).isbn);
    }
}
