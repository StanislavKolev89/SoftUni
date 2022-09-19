import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> comparator = ((e1, e2) -> {
            if (e1 % 2 == 0 && e2 % 2 != 0) {
                return -1;
            } else if (e1 % 2 != 0 && e2 % 2 == 0) {
                return 1;
            } else if ((e1 % 2 == 0 && e2 % 2 == 0) || (e1 % 2 != 0 && e2 % 2 != 0)) {
                if (e1 <= e2) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return 0;
        });

        numbers.sort(comparator);
        numbers.forEach(e-> System.out.print(e+" "));
    }
}
