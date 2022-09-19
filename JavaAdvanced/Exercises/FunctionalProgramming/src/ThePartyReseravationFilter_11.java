import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReseravationFilter_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Print")) {
            Predicate<String> addOrRemove = creatingPredicate(input);
            if(addOrRemove!=null){
              guestsUpdate(guests,addOrRemove);
            }
            input = scanner.nextLine();
        }

    }

    private static void guestsUpdate(List<String> guests, Predicate<String> addOrRemove) {
    }

    private static Predicate<String> creatingPredicate(String input) {
        String[] tokens = input.split(";");
        switch (tokens[0]) {
            case "Add filter":
                switch (tokens[1]) {
                    case "Starts with":
                        return x -> x.startsWith(tokens[2]);
                    case "Ends with":
                        return x -> x.endsWith(tokens[2]);
                    case "Length":
                        return x -> x.length() == Integer.parseInt(tokens[2]);
                    case "Contains":
                        return x -> x.contains(tokens[2]);
                }
            case"Remove filter":
                switch (tokens[1]) {
                    case "Starts with":
                        return x -> !x.startsWith(tokens[2]);
                    case "Ends with":
                        return x -> !x.endsWith(tokens[2]);
                    case "Length":
                        return x -> x.length() == Integer.parseInt(tokens[2]);
                    case "Contains":
                        return x -> x.contains(tokens[2]);
                }
        }
        return null;
    }
}
