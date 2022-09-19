import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forwardUrls = new ArrayDeque<>();
        String command = scanner.nextLine();

        String currentURL = "";
        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (history.size() > 1) {
                    forwardUrls.addFirst(history.pop());
                    System.out.println();
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (command.equals("forward")) {
                if (forwardUrls.size() > 0) {
                    String url = forwardUrls.pop();
                    System.out.println(url);
                    history.push(url);
                } else {
                    System.out.println("no next URLs");
                }
            } else {
                history.push(command);
                System.out.println(command);
                forwardUrls.clear();
            }
            command = scanner.nextLine();
        }
    }
}
