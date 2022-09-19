import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> items = new HashMap<>();
        Map<String, Integer> junk = new HashMap<>();
        boolean VictoryOccurred = false;
        String input = scanner.nextLine();
        while (!VictoryOccurred) {
            String[] tokens = input.split("\\s+");
            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String product = tokens[i + 1].toLowerCase(Locale.ROOT);

                if (notJunk(product)) {
                    if (!items.containsKey(product)) {
                        items.put(product, quantity);
                    } else {
                        items.put(product, items.get(product) + quantity);
                    }
                } else {
                    if (!junk.containsKey(product)) {
                        junk.put(product, quantity);
                    } else {
                        junk.put(product, junk.get(product) + quantity);
                    }
                }
                if (winnerFound(items)) {
                    printWinner(items, junk);
                    List<String> item = List.of("motes", "shards", "fragments");
                    items.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).forEach(el -> System.out.printf("%s: %d%n", el.getKey(), el.getValue()));
                    junk.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
                    VictoryOccurred = true;
                    break;

                }
            }
            input = scanner.nextLine();

        }

    }

    private static Map<String, Integer> fillingMap(List item, Map<String, Integer> items) {
        if (!item.isEmpty()) {
            List<String> newList = item;
            for (Object it : item) {
                items.put((String) it, 0);
            }
        }
        return items;
    }


    private static void checkIfItemMissing(List<String> item, Map<String, Integer> items) {
        if(item.size()!=items.size()){
            for (var map : items.entrySet()) {
                for (int i = 0; i < item.size(); i++) {
                        if (map.getKey().equals(item.get(i))){
                            item.remove(item.set(i,null));
                    }
                }
            }
        }


    }

    private static void printWinner(Map<String, Integer> items, Map<String, Integer> junk) {
        for (var map : items.entrySet()) {
            if (map.getValue() > 250) {
                String name = findingName(map.getKey());
                changing(items, map.getKey());
                System.out.printf("%s obtained!%n", name);

            }
        }

    }

    private static void changing(Map<String, Integer> items, String name) {
        int points = ((items.get(name) - 250) < 0) ? 0 : items.get(name) - 250;
        items.put(name, items.get(name) - 250);
    }

    private static String findingName(String key) {
        String name = "";
        switch (key) {
            case "shards":
                name = "Shadowmourne";
                break;
            case "fragments":
                name = "Valanyr";
                break;
            case "motes":
                name = "Dragonwrath";
                break;
        }
        return name;
    }

    private static boolean winnerFound(Map<String, Integer> items) {
        for (var map : items.entrySet()) {
            if (map.getValue() > 250) {
                return true;
            }
        }
        return false;
    }

    private static boolean notJunk(String product) {
        if (!product.equals("shards") && !product.equals("motes") && !product.equals("fragments")) {
            return false;
        }
        return true;
    }
}
