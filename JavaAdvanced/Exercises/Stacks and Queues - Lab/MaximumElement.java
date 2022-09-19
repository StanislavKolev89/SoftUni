import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            int[] digits = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(digits.length>1){
                numbers.push(digits[1]);
            }else if( digits[0]==2){
                numbers.pop();
            }else {
                System.out.println(findingMax(numbers));
            }
        }

    }

    private static int findingMax(ArrayDeque<Integer> numbers) {
        int maxValue = Integer.MIN_VALUE;
        for (int number: numbers) {
            if(number>maxValue){
                maxValue=number;
            }
        }
        return maxValue;
    }
}
