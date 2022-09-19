import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Party!")) {
            String[] tokens = command.split("\\s+");
            String startOrEnd = tokens[1];
            String letterOrDigit = tokens[2];
            Predicate<String> operate = getPredicate(tokens[0], tokens[1], tokens[2]);

            int count = names.size();
            for (int i = 0; i < names.size(); i++) {
                if (count-- == 0) {
                    break;
                }

                if (operate.test(names.get(i))) {
                    if (tokens[0].equals("Remove")) {
                        names.remove(i);
                        i--;
                    } else {
                        names.add(names.get(i));
                    }
                }
            }


            command = scanner.nextLine();
        }
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(String.join(", ", names.stream().sorted().collect(Collectors.toList()))
                    + " are going to the party!");
        }


    }

    private static Predicate<String> getPredicate(String removeOrDouble, String startEndOrLength, String digitOrLetter) {
        if (removeOrDouble.equals("Remove")) {
            if (startEndOrLength.equals("StartsWith")) {
                return str -> str.startsWith(digitOrLetter);
            } else {
                return str -> str.endsWith(digitOrLetter);
            }
        } else {
            if (startEndOrLength.equals("StartsWith")) {
                return str -> str.startsWith(digitOrLetter);
            } else if (startEndOrLength.equals("EndsWith")) {
                return str -> str.endsWith(digitOrLetter);
            } else {
                return str -> str.length() == Integer.parseInt(digitOrLetter);
            }
        }
    }


}

