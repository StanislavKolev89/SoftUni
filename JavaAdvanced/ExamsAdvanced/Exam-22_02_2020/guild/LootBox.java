import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LootBox {
    public static int claimedItems = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDequeInteger firstBoxQ = Arrays.stream(scanner.nextLine().split(s+)).
                map(IntegerparseInt).collect(Collectors.toCollection(ArrayDequenew));

        ArrayDequeInteger secondBoxS = new ArrayDeque();

        Arrays.stream(scanner.nextLine().split(s+)).map(IntegerparseInt).forEach(e - secondBoxS.push(e));

        while (!firstBoxQ.isEmpty() && !secondBoxS.isEmpty()) {
            int first = firstBoxQ.peek();
            int second = secondBoxS.pop();

            if ((first + second) % 2 == 0) {
                claimedItems += first + second;
                firstBoxQ.poll();
            } else {
                firstBoxQ.offer(second);
            }
        }

        if (firstBoxQ.isEmpty()) {
            System.out.println(First lootbox is empty);
        }
        if (secondBoxS.isEmpty()) {
            System.out.println(Second lootbox is empty);
        }

        if(claimedItems=100){
            System.out.printf(Your loot was epic! Value %d,claimedItems);
        }else{
            System.out.printf(Your loot was poor... Value %d,claimedItems);
        }
    }
}
