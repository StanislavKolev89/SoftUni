package p02_ExtendedDatabase;

import org.junit.Test;

public class PersonTest {

    private Person person;


    @Test
    public void tryingToGetPersonIdAndName() {
        Person person = new Person(2, "Ivan");
        person.getId();
        person.getUsername();
    }




}