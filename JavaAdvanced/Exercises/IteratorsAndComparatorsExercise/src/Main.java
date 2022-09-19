import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+")).skip(1).collect(Collectors.toList());

        ListIterator listIterator = new ListIterator(data);

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            switch (command) {
                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "Print":
                    listIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;
                case "PrintAll":
                    listIterator.printAll();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
