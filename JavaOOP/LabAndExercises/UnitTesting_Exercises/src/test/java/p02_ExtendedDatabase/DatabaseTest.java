package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Person[] PEOPLE = new Person[1];
    private static final int UPDATED_DATABASE = PEOPLE.length + 1;
    private static final int DECREASED_DATABASE = PEOPLE.length - 1;

    @Before
    public void setUpData() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }


    @Test(expected = OperationNotSupportedException.class)

    public void tryingToAddNullToDatabase() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
        database.add(null);

    }

    @Test
    public void tryingToAddPersonToDatabse() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
        Person person = new Person(24, "Ivan");
        database.add(person);
        Assert.assertEquals(database.getElements().length,UPDATED_DATABASE);
    }

    @Test(expected = OperationNotSupportedException.class)

    public void tryingToRemoveFromEmptyDatabase() throws OperationNotSupportedException {
        database.remove();
        database.remove();

    }

    @Test
    public void tryingToRemovePersonFromDatabase() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(database.getElements().length, DECREASED_DATABASE);

    }

    @Test(expected = OperationNotSupportedException.class)

    public void tryingToFindPersonByUsernameWithNullData() throws OperationNotSupportedException {
        database = new Database(new Person(2, "Stela"));
        database.findByUsername("Stela");
        database.findByUsername(null);
    }

    @Test
    public void tryingToFindPersonByUsername() throws OperationNotSupportedException {
        database = new Database(new Person(2, "Stela"));
        database.findByUsername("Stela");

    }
 @Test(expected = OperationNotSupportedException.class)
    public void tryingToCatchExceptionWhenPersonIsAdded() throws OperationNotSupportedException {
     database = new Database(new Person(2, "Stela"));
     database.findByUsername("Stela");
 }
    @Test
    public void tryingToFindPersonById() throws OperationNotSupportedException {
        database = new Database(new Person(2, "Stela"));
        database.findById(2);

    }
    @Test(expected = OperationNotSupportedException.class)

    public void tryingToFindPersonByIdWithNullData() throws OperationNotSupportedException {
        database = new Database(new Person(2, "Stela"));
        database.findById(2);
        database.findById(3);
    }
    @Test (expected = OperationNotSupportedException.class)

    public void tryingToCatchExceptionWhenSearchingUserByUsername() throws OperationNotSupportedException {
        database = new Database(new Person(2, "Stela"));
        database.findByUsername("Stela");
        database = new Database(new Person(2, "Greta"));
        database.findByUsername("Greta");
    }


}