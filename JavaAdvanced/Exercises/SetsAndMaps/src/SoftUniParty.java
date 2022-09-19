import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command1 = scanner.nextLine();

        Set<String> guests = new TreeSet<>();

        while (!command1.equals("PARTY")) {
            guests.add(command1);
            command1 = scanner.nextLine();
        }
        String command2 = scanner.nextLine();
        while (!command2.equals("END")) {
            guests.remove(command2);
            command2 = scanner.nextLine();
        }
        System.out.println(guests.size());
        guests.forEach(System.out::println);
    }
}
