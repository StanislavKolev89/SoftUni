import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();

        String command = scanner.nextLine();

        String currentURL = "";
        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (history.size() > 1) {
                    history.pop();
                    currentURL = history.peek();
                } else {
                    System.out.println("no previous URLs");
                    command = scanner.nextLine();
                    continue;
                }
            } else {
                history.push(command);
                currentURL = history.peek();
            }
            System.out.println(currentURL);
            command = scanner.nextLine();
        }
    }
}