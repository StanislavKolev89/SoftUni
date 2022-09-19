package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleTest {

    private static final int[] array = {5,12, 54, 544,431,12,312, 1231543};
    private static final int[] sortedArray = Arrays.stream(array).sorted().toArray();

    @Test

    public void TryingToSortTheArray(){
        Bubble.sort(array);
        int[] ints = Arrays.stream(array).sorted().toArray();
        Assert.assertArrayEquals(ints,sortedArray);
    }

}