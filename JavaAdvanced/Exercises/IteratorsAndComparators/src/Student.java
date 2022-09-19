import java.util.Comparator;

public class Student implements Comparable<Student> {
    public void setFacNumber(int facNumber) {
        this.facNumber = facNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int facNumber;
    private String name;
    private int age;

    public int getFacNumber() {
        return facNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Student(int facNumber, String name, int age) {
        this.facNumber = facNumber;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return String.format("%d %s %d",facNumber,name,age);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.getFacNumber(), o.getFacNumber());
    }
}
