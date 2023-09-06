package by.bsuir;

import java.util.Objects;

public class ProgrammerBook extends Book{
    private String language;
    private int level;

    public ProgrammerBook(String title, String author, int price, int edition) {
        super(title, author, price, edition);
    }

    @Override
    public String toString() {
        return super.toString() + ", language - " + language + ", level - " + level;
    }

    @Override
    public int hashCode() {
        return (super.hashCode() * level / 2) + language.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        try{
            ProgrammerBook book = (ProgrammerBook) obj;
            return super.equals(obj) && Objects.equals(this.language, book.language);
        } catch (Exception e) {
            return false;
        }
    }
}
