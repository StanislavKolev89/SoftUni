import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);


        //remove all numbers if divisible by n
        Predicate<Integer> check = num -> num % n == 0;
        numbers.removeIf(check);

        Consumer<List<Integer>> print = list-> list.forEach(e-> System.out.print(e+" "));

        print.accept(numbers);
    }
}
