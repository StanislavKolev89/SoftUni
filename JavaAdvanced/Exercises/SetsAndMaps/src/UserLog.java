import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> logs = new TreeMap<>();

        String data = scanner.nextLine();

        while (!data.equals("end")) {
            String[] tokens = data.split("\\s+");
            String ip = tokens[0].substring(3);
            String username = tokens[2].substring(5);

            if (!logs.containsKey(username)) {
                logs.put(username, new LinkedHashMap<>());
                logs.get(username).put(ip, 1);
            } else {
                if (!logs.get(username).containsKey(ip)) {
                    logs.get(username).put(ip, 1);
                } else {
                    logs.get(username).put(ip, logs.get(username).get(ip) + 1);
                }
            }

            data = scanner.nextLine();
        }
        logs.entrySet().stream().forEach(e -> {
                    System.out.println(e.getKey() + ":");
                    Map<String, Integer> ips = e.getValue();
                    int counter = ips.size();
                    for (var ip : e.getValue().entrySet()) {
                        if (counter > 1) {
                            System.out.printf("%s => %d, ", ip.getKey(), ip.getValue());
                        } else {
                            System.out.printf("%s => %d.%n", ip.getKey(), ip.getValue());
                        }
                        counter--;
                    }
                }
        );
    }

}
