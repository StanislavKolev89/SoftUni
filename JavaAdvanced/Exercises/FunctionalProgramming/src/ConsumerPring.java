import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] names = input.split("\\s+");

        Consumer<String[]> printString = array->{
            for (String word: array) {
                System.out.println(word);
            }
        };
        printString.accept(names);

//        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(System.out::println);
    }
}
