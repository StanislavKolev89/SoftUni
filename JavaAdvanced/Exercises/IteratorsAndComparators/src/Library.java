import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library implements Iterable<Book> {
    private List<Book> books;
    private boolean inReversedOrder;

    public Library(boolean inReversedOrder) {
        this.books = new ArrayList<>();
        this.inReversedOrder = inReversedOrder;

    }

    public void add(Book book) {
        this.books.add(book);
    }

    public Book get(int index) {
        return this.books.get(index);
    }

    public int booksCount() {
        return this.books.size();
    }

    @Override
    public Iterator<Book> iterator() {
        if(inReversedOrder) {
            return new Iterator<Book>() {
                private int i = books.size() - 1;

                @Override
                public boolean hasNext() {
                    return i >= 0;
                }

                @Override
                public Book next() {
                    return get(i--);
                }
            };
        }
        return books.iterator();
    }
}
