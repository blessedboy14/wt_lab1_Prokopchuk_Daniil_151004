package by.bsuir;

import java.util.Comparator;
import java.util.Objects;

public class NameThenAuthorComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        if (!Objects.equals(o1.getTitle(), o2.getTitle())) {
            return o1.getTitle().compareTo(o2.getTitle());
        } else {
            return o1.getAuthor().compareTo(o2.getAuthor());
        }
    }
}
