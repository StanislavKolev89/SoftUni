package p01_Database;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Integer[] NUMBERS = {5, 6, 10 ,14, 16};
    private static final Integer[] NUMBERS_MORE_THAN_16 = {5, 6, 10 ,14, 16,123 ,123,13,41,
    1,23,23,123,51,12312,5123,512315123};
    private static final  int UPDATED_DATABASE = NUMBERS.length + 1;

    @Test(expected =  OperationNotSupportedException.class)

    public void addingNullToDataBase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
        database.add(null);
    }

    @Test

    public void tryingToAddElementToDataBase() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
        database.add(8);
        Assert.assertEquals(database.getElements().length,UPDATED_DATABASE);
        Assert.assertEquals(database.getElements()[database.getElements().length-1], Integer.valueOf(8));
    }

    @Test(expected = OperationNotSupportedException.class)

    public void tryToRemoveElementFromEmptyArray() throws OperationNotSupportedException {
        database = new Database(1);
        database.remove();
        Assert.assertEquals(database.getElements().length,0);
        database.remove();
    }

    @Test
    public void  tryingToCreateDatabaseWithValidCountOfElements() throws OperationNotSupportedException {
        new Database(1);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void  tryingToCreateDatabaseWithInvalidCountOfElements() throws OperationNotSupportedException {
        database = new Database(NUMBERS_MORE_THAN_16);
    }
}