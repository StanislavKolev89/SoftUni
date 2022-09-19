import java.util.Comparator;

public class StudnetsComparatorByName implements Comparator<Student > {
    @Override
    public int compare(Student f, Student s) {
        return f.getName().compareTo(s.getName());
    }
}
