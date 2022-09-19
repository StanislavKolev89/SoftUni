package entities;

import javax.persistence.*;

@Entity(name="students")
public class Student {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @JoinColumn(name="teacher_id", referencedColumnName = "id")
    private int teacherId;

    public Student(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student(String name,Long teacherId) {
        this.name = name;
    }
}
