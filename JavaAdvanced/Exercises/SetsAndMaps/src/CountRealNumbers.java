import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> numberOccurrences = new LinkedHashMap<>();
        String[] number = scanner.nextLine().split("\\s+");

        for (String num : number) {
            if (!numberOccurrences.containsKey(num)) {
                numberOccurrences.put(num, 1);
            } else {
                numberOccurrences.put(num, numberOccurrences.get(num) + 1);
            }
        }

        numberOccurrences.entrySet().stream().forEach(e -> System.out.printf("%.1f -> %d%n", Double.parseDouble(e.getKey()), e.getValue()));
    }
}
