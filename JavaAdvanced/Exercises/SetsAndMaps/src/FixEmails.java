import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> emails = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("stop")) {
            String name = input;
            String email = scanner.nextLine();
            collectingData(emails, name, email);

            input = scanner.nextLine();
        }
        printing(emails);
    }

    private static void printing(Map<String, String> emails) {
        emails.entrySet().stream().forEach(e ->
                System.out.printf("%s -> %s%n", e.getKey(), e.getValue()));
    }

    private static void collectingData(Map<String, String> emails, String name, String email) {
        if (!email.endsWith("uk") && !email.endsWith("us") && !email.endsWith("com")) {
            emails.put(name, email);
        }
    }
}
