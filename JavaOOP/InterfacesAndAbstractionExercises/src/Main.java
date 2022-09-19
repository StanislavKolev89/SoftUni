import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String > numbers = fillNumbers(scanner, "\\s+");
        List<String> urls = fillNumbers(scanner,"\\s+");
        Smartphone smartphone = new Smartphone(numbers, urls);
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }

    private static List<String> fillNumbers(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern)).collect(Collectors.toList());
    }
}
