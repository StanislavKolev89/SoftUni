package university;

import java.util.ArrayList;
import java.util.List;

public class University {

    public int capacity;
    public List<Student> students;

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        StringBuilder builder = new StringBuilder();
        if (!students.contains(student)) {
            if (students.size() < this.capacity) {
                students.add(student);
                builder.append(String.format("Added student %s %s", student.getFirstName(), student.getLastName()));
            } else {
                builder.append("No seat in the university");
            }
        } else if (students.contains(student)) {
            builder.append("Student is already in the university");
        }
        return builder.toString().trim();
    }

    public String dismissStudent(Student student) {
        StringBuilder builder = new StringBuilder();
        if (students.contains(student)) {
            students.remove(student);
            builder.append(String.format("Removed student %s %s", student.getFirstName(), student.getLastName()));
        } else {
            builder.append("Student not found");
        }
        return builder.toString().trim();
    }

    public Student getStudent(String firstName, String lastName){
        return students.stream().filter(e->
                e.firstName.equals(firstName) && e.lastName.equals(lastName)).findFirst().orElse(null);
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        for (Student student: students) {
            builder.append(String.format("==Student: First Name = %s, Last Name = %s," +
                    " Best Subject = %s",student.getFirstName(),student.getLastName(),student.getBestSubject()))
                    .append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
