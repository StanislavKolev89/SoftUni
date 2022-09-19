import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");

        ArrayDeque<String> namesOfPlayers = new ArrayDeque<>();
        for (String name : data) {
            namesOfPlayers.offer(name);
        }
        int counts = Integer.parseInt(scanner.nextLine());
        int cycle = 1;

        while (namesOfPlayers.size() > 1) {
            for (int i = 1; i < counts; i++) {
                namesOfPlayers.offer(namesOfPlayers.poll());
            }
            if (isPrime(cycle)) {
                System.out.printf("Prime %s%n", namesOfPlayers.peek());
            } else {
                System.out.printf("Removed %s%n", namesOfPlayers.poll());
            }

            cycle++;
        }
        System.out.printf("Last is %s", namesOfPlayers.peek());
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;

    }


}