package by.bsuir;

import java.util.Comparator;
import java.util.Objects;

public class AuthorThenNameComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if (!Objects.equals(o1.getAuthor(), o2.getAuthor())) {
            return o1.getAuthor().compareTo(o2.getAuthor());
        } else {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
}
