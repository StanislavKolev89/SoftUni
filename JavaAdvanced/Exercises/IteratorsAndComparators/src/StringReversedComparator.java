import java.util.Comparator;

public class StringReversedComparator implements Comparator<String> {

    @Override
    public int compare(String f, String s) {
        return s.compareTo(f);
    }
}
