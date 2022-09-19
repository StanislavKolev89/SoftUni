import java.util.*;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer>  firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        int[] cardsFirst = fillingCards(scanner, "\\s+");
        int[] cardsSecond = fillingCards(scanner, "\\s+");

        for (int e : cardsFirst) {
            firstPlayer.add(e);
        }

        for (int e : cardsSecond) {
            secondPlayer.add(e);
        }

        int rounds = 50;
        while (rounds-- > 0) {
            int cardFirst = firstCard(firstPlayer);
            int cardSecond = firstCard(secondPlayer);

            firstPlayer.remove(cardFirst);
            secondPlayer.remove(cardSecond);
            if (cardFirst > cardSecond) {
                firstPlayer.add(cardFirst);
                firstPlayer.add(cardSecond);
            } else if (cardSecond > cardFirst) {
                secondPlayer.add(cardFirst);
                secondPlayer.add(cardSecond);
            }
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }
        }

      printWinner(firstPlayer,secondPlayer);

    }

    private static void printWinner(Set<Integer> firstPlayer, Set<Integer> secondPlayer) {
        if(firstPlayer.size()> secondPlayer.size()){
            System.out.println("First player win!");
        }else if(firstPlayer.size()< secondPlayer.size()){
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw!");
        }
    }

    private static int firstCard(Set<Integer> firstPlayer) {
        for (int number : firstPlayer) {
            return number;
        }
        return 0;
    }

    private static int[] fillingCards(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
