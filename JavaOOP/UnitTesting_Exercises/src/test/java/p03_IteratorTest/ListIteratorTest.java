package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] ELEMENTS = new String[10];

    @Test
    public void tryingToChangeTheInitialIndex() throws OperationNotSupportedException {
        listIterator = new ListIterator(ELEMENTS);
        listIterator.move();
        Assert.assertEquals(1, 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void tryingToCreateListIteratorWithNoElements() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    @Test
    public void tryingToMoveToPresentIndex() throws OperationNotSupportedException {
        String[] el = {"Maria","Ivan","Petar","Gosho"};
        listIterator = new ListIterator(el);
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.hasNext());
        Assert.assertFalse(listIterator.move());

    }
        @Test(expected =  IllegalStateException.class)
    public void tryingToPrintElementFromListIterator() throws OperationNotSupportedException {
            String[] el = {"Maria","Ivan","Petar","Gosho"};
            listIterator = new ListIterator(el);
            listIterator.print();
            listIterator = new ListIterator();
            listIterator.print();
        }
}