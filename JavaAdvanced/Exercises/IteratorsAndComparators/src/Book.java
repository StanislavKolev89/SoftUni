import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        setTitle(title);
        setYear(year);
        setAuthor(authors);

    }
    @Override
    public int compareTo(Book other){
        int result = this.title.compareTo(other.title);
        if(result==0){
            result = Integer.compare(this.year,other.year);
        }
        return result;
    }

    private void setAuthor(String[] authors) {
        this.authors= new ArrayList<>();
        for (String author: authors){
            this.authors.add(author);
        }
    }

    private void setTitle(String title) {
        this.title = title;
    }
    
    private  void setYear(int year){
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return this.year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }
}
