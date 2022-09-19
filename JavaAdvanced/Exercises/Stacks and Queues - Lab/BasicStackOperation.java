import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("\\s+");
        int numberOfElements = Integer.parseInt(data[0]);
        int countOfPopped = Integer.parseInt(data[1]);
        int numberToCheck = Integer.parseInt(data[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int number : numbers) {
            stack.push(number);
        }

        for (int i = 0; i < countOfPopped; i++) {
            stack.pop();
        }

        if (stack.contains(numberToCheck)) {
            System.out.println(true);
        } else {
            if (stack.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(findingSmallest(stack));
            }
        }
    }

    private static int findingSmallest(ArrayDeque<Integer> stack) {

        int smallest = Integer.MAX_VALUE;
        for (int number : stack) {
            if (number < smallest) {
                smallest = number;
            }
        }
        return smallest;
    }
}
