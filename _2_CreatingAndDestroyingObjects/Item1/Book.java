package _2_CreatingAndDestroyingObjects.Item1;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author;

    private Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public static Book ofTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        return new Book(title, null);
    }

    public static Book ofTitleAndAuthor(String title, String author) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (author != null && author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty if provided");
        }
        return new Book(title, author);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "The book \"" + title + "\" was written by " + (author != null ? author : "unknown");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}