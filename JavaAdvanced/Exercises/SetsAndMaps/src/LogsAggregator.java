import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> users = new TreeMap<>();

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split(" ");
            String username = input[1];
            String ip = input[0];
            int duration = Integer.parseInt(input[2]);

            if (!users.containsKey(username)) {
                users.put(username, new TreeMap<>());
                users.get(username).put(ip, duration);
            } else {
                if (!users.get(username).containsKey(ip)) {
                    users.get(username).put(ip, duration);
                } else {
                    users.get(username).put(ip, users.get(username).get(ip) + duration);
                }
            }
        }
        System.out.println();
        users.entrySet().stream().forEach(e -> {
            String array = fillingArray(e.getValue());
            int total = getTotal(e.getValue());
            System.out.printf("%s: %d %s%n", e.getKey(), total, array);


        });
    }

    private static String fillingArray(Map<String, Integer> value) {
        Set<String> newArray = value.keySet();
        return String.join(",", newArray.toString());

    }


    private static int getTotal(Map<String, Integer> value) {
        int total = 0;
        for (var map : value.entrySet()) {
            total += map.getValue();

        }
        return total;
    }
}
