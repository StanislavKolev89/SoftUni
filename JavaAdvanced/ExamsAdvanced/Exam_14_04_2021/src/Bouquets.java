import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulipsS = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).
                map(Integer::parseInt).forEach(e -> tulipsS.push(e));

        ArrayDeque<Integer> daffodilsQ = Arrays.stream(scanner.nextLine().split(", ")).
                map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        System.out.println();
        int bouquetCounter = 0;
        int bucketOfFlowers = 0;

        while (!tulipsS.isEmpty() && !daffodilsQ.isEmpty()) {
            int integerFirst = tulipsS.peek();
            int integerSecond = daffodilsQ.peek();
            int sum = integerFirst + integerSecond;
            if(sum==15){
                bouquetCounter++;
                tulipsS.pop();
                daffodilsQ.poll();
            }else if(sum>15) {
                while (sum > 15) {
                    integerFirst = tulipsS.pop()-2;
                    sum = integerFirst + integerSecond;
                    tulipsS.push(integerFirst);
                    if (sum ==15){
                        bouquetCounter++;
                        tulipsS.pop();
                        daffodilsQ.poll();
                    }else if(sum<15){
                        bucketOfFlowers+=sum;
                        tulipsS.pop();
                        daffodilsQ.poll();
                    }
                }
            }else if(sum<15){
                bucketOfFlowers+=sum;
                tulipsS.pop();
                daffodilsQ.poll();
            }
        }
        if (bucketOfFlowers > 0) {
            int bouquetsAdd = bucketOfFlowers / 15;
            bouquetCounter = bouquetCounter + bouquetsAdd;
        }

        if(bouquetCounter>=5){
            System.out.printf("You made it! You go to the competition with %d bouquets!",bouquetCounter);
        }else{
            System.out.printf("You failed... You need more %d bouquets.",(5-bouquetCounter));
        }
    }
}
