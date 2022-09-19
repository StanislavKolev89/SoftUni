import java.util.*;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" ");
        ArrayDeque<String> namesOfPlayers = new ArrayDeque<>();
        for (String name: data) {
            namesOfPlayers.offer(name);
        }
        int counts = Integer.parseInt(scanner.nextLine());

        while(namesOfPlayers.size()>1){
            for (int i = 0; i < counts-1; i++) {
                namesOfPlayers.offer(namesOfPlayers.poll());

            }
            System.out.printf("Removed %s%n",namesOfPlayers.poll());
        }
        System.out.printf("Last is %s", namesOfPlayers.peek());

    }
}
