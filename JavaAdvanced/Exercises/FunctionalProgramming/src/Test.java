import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<Integer> isEven = n -> n % 2 == 0;
        BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y;
        System.out.println(sum.apply(3,5));
        Predicate<String > word = str -> Character.isUpperCase(str.charAt(0));

        List<String> collect = Arrays.stream(scanner.nextLine().split(" ")).filter(word).collect(Collectors.toList());
        collect.stream();

    }
}
