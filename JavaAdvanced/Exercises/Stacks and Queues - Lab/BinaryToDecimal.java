import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int finalResult = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            finalResult += numbers[i] * Math.pow(2, numbers.length-1-i);
        }
        System.out.println(finalResult);
    }
}
