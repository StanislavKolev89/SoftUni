import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> letters = new TreeMap<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (!letters.containsKey(input.charAt(i))) {
                letters.put(input.charAt(i), 1);
            } else {
                letters.put(input.charAt(i), letters.get(input.charAt(i)) + 1);
            }
        }

        letters.entrySet().stream().forEach(e -> System.out.printf("%c: %d time/s%n", e.getKey(), e.getValue()));
    }
}
