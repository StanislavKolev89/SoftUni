import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.DoubleFunction;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();
        String command = scanner.nextLine();

        while (!command.equals("search")) {
            updatingPhoneBook(phonebook, command);

            command = scanner.nextLine();
        }

        String command2 = scanner.nextLine();
        while (!command2.equals("stop")) {
            String name = command2;
            printResult(phonebook, name);
            command2 = scanner.nextLine();
        }
    }

    private static void printResult(Map<String, String> phonebook, String name) {
        if (phonebook.containsKey(name)) {
            System.out.printf("%s -> %s%n", name, phonebook.get(name));
        } else {
            System.out.printf("Contact %s does not exist.%n", name);
        }
    }

    private static void updatingPhoneBook(Map<String, String> phonebook, String command) {
        String[] input = command.split("\\-");
        String name = input[0];
        String number = input[1];
        phonebook.put(name, number);
    }
}
