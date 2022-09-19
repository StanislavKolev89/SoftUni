import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] sizes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> first = new LinkedHashSet<>(sizes[0]);
        Set<Integer> second = new LinkedHashSet<>(sizes[1]);

        for (int i = 0; i <sizes[0]; i++) {
            first.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < sizes[1]; i++) {
            second.add(Integer.parseInt(scanner.nextLine()));
        }
        first.retainAll(second);
            for (Integer integer : first) {
                System.out.print(integer+" ");
            }
        }
    }

