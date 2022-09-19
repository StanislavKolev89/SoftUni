import java.lang.reflect.Field;

public class Comparator implements Comparable<Field> {
    private String name;

    public Comparator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Field o) {
        return this.getName().compareTo(o.getName());
    }
}
