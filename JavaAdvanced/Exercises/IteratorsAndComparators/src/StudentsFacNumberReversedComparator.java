import java.util.Comparator;

public class StudentsFacNumberReversedComparator implements Comparator<Student> {

    @Override

    public int compare( Student f, Student s){
        return Integer.compare(s.getFacNumber(),f.getFacNumber());
    }
}
