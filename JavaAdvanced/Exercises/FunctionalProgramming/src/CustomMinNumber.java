import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class CustomMinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ints = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Consumer<int[]> getMin = array -> System.out.println(Arrays.stream(array).min().orElse(0));
        getMin.accept(ints);


    }
}
