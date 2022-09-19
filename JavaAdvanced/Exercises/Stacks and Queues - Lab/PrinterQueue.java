import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        ArrayDeque<String> printDocuments = new ArrayDeque<>();

        while (!command.equals("print")) {
            if (!command.equals("cancel")) {
                printDocuments.offer(command);
            } else {
                if (printDocuments.size() > 0) {
                    System.out.println("Canceled " + printDocuments.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            }

            command = scanner.nextLine();
        }
        while (!printDocuments.isEmpty()) {
            System.out.println(printDocuments.poll());
        }
    }

}
