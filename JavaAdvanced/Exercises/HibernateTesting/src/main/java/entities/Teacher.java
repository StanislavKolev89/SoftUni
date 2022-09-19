package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fulLName;

    public Teacher(){};
    public Teacher( String fulLName) {

        this.fulLName = fulLName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFulLName() {
        return fulLName;
    }

    public void setFulLName(String fulLName) {
        this.fulLName = fulLName;
    }
}
