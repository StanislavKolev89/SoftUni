import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> boxQ = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> boxS = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(e -> boxS.push(e));

        int claimedItems = 0;
        while (!boxQ.isEmpty() && !boxS.isEmpty()) {
            int first = boxQ.peek();
            int second = boxS.peek();
            int sum = first + second;

            if (sum % 2 == 0) {
                claimedItems += sum;
                boxQ.poll();
                boxS.pop();
            }else{
                boxQ.offer(boxS.pop());
            }
        }
        if(boxQ.isEmpty()){
            System.out.println("First magic box is empty.");
        }else if(boxS.isEmpty()){
            System.out.println("Second magic box is empty.");
        }

        if(claimedItems>=90){
            System.out.printf("Wow, your prey was epic! Value: %d",claimedItems);
        }else{
            System.out.printf("Poor prey... Value: %d",claimedItems);
        }

    }
}
