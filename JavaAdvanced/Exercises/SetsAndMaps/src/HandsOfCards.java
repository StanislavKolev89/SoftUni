import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> personsCards = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");
            collectingData(personsCards, name, cards);

            input = scanner.nextLine();
        }

        Map<String, Integer> playersPoints = new LinkedHashMap<>();
        collectingPoints(personsCards, playersPoints);

        playersPoints.entrySet().stream().forEach(e-> System.out.printf("%s: %d%n",e.getKey(),e.getValue()));

    }

    private static void collectingPoints(Map<String, Set<String>> personsCards, Map<String, Integer> playersPoints) {
        for (var persons : personsCards.entrySet()) {
            String personName = persons.getKey();
            int points = collectingPointsOfEachPlayer(persons.getValue());
            playersPoints.put(personName,points);
        }


    }

    private static int collectingPointsOfEachPlayer(Set<String> value) {
        int total = 0;
        String powerOFCards= "";
        String type ="";
        for (String card : value) {
            if(card.length()<3) {
             powerOFCards = card.split("")[0];
              type = card.split("")[1];
            }else{
                powerOFCards="10";
                type= card.split("")[2];
            }
            total += findPower(powerOFCards) * findType(type);
        }
        return total;
    }

    private static int findPower(String type) {
        int result = 0;
        switch (type) {
            case "2":
                result = 2;
                break;
            case "3":
                result = 3;
                break;
            case "4":
                result = 4;
                break;
            case "5":
                result = 5;
                break;
            case "6":
                result = 6;
                break;
            case "7":
                result = 7;
                break;
            case "8":
                result = 8;
                break;
            case "9":
                result = 9;
                break;
            case "10":
                result = 10;
                break;
            case "J":
                result = 11;
                break;
            case "Q":
                result = 12;
                break;
            case "K":
                result = 13;
                break;
            case "A":
                result = 14;
                break;
        }
        return result;
    }

    private static int findType(String powerOFCards) {

        if (powerOFCards.equals("S")) {
            return 4;
        }
        if (powerOFCards.equals("H")) {
            return 3;
        }
        if (powerOFCards.equals("D")) {
            return 2;
        }
        if (powerOFCards.equals("C")) {
            return 1;
        }
        return 0;
    }

    private static void collectingData(Map<String, Set<String>> personsCards, String name, String[] cards) {
        if (!personsCards.containsKey(name)) {
            personsCards.put(name, new LinkedHashSet<>());
            for (String card : cards) {
                personsCards.get(name).add(card);
            }
        } else {
            for (String card : cards) {
                personsCards.get(name).add(card);
            }
        }
    }
}
