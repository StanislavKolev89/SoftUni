import java.util.*;

public class CitiesByContinent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            if (!continents.containsKey(continent)) {
                continents.put(continent, new LinkedHashMap<>());
                continents.get(continent).put(country, new ArrayList<>());
                continents.get(continent).get(country).add(city);
            } else {
                Map<String, List<String>> cityInfo = continents.get(continent);
                if (!cityInfo.containsKey(country)) {
                    cityInfo.put(country, new ArrayList<>());
                    cityInfo.get(country).add(city);
                } else {
                        cityInfo.get(country).add(city);

                }

            }
        }

        continents.entrySet().stream().forEach(e -> {
            System.out.printf("%s:%n", e.getKey());
            var countries = e.getValue();
            countries.entrySet().stream().forEach(el -> {
                System.out.printf("  %s -> ", el.getKey());
                System.out.println(String.join(", ", el.getValue()));
            });
        });


    }
}
