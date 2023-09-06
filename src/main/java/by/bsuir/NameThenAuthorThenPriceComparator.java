package by.bsuir;

import java.util.Objects;

public class NameThenAuthorThenPriceComparator extends NameThenAuthorComparator{
    @Override
    public int compare(Book o1, Book o2) {
        if (Objects.equals(o1.getTitle(), o2.getTitle()) && Objects.equals(o1.getAuthor(), o2.getAuthor())) {
            return Integer.compare(o1.getPrice(), o2.getPrice());
        } else {
            return super.compare(o1, o2);
        }
    }
}
