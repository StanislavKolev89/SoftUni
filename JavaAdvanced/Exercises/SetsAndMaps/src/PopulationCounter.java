import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Long> totalPopulation = new LinkedHashMap<>();
        Map<String, Map<String, Long>> populationInCities = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String[] tokens = input.split("[|]");
            String country = tokens[1];
            String city = tokens[0];
            long population = Integer.parseInt(tokens[2]);
            fillingTotalPopulation(totalPopulation, country, city, population);
            fillingTotalPopulationByCity(populationInCities, country, city, population);
            input = scanner.nextLine();
        }

        totalPopulation.entrySet().stream().sorted((e1, e2) ->
                e2.getValue().compareTo(e1.getValue())).forEach(e -> {
            String country = e.getKey();
            System.out.printf("%s (total population: %d)%n", country, e.getValue());

            for (var map : populationInCities.entrySet())
                if (map.getKey().equals(country)) {
                    map.getValue().entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).forEach(el ->
                            System.out.printf("=>%s: %d%n", el.getKey(), el.getValue()));
                }
        });
    }

    private static void fillingTotalPopulationByCity(Map<String, Map<String, Long>> populationInCities, String country, String city, long population) {
        if (!populationInCities.containsKey(country)) {
            populationInCities.put(country, new LinkedHashMap<>());
            populationInCities.get(country).put(city, population);
        } else {
            if (!populationInCities.get(country).containsKey(city)) {
                populationInCities.get(country).put(city, population);
            } else {
                populationInCities.get(country).put(city, populationInCities.get(country).get(city) + population);
            }
        }
    }

    private static void fillingTotalPopulation(Map<String, Long> totalPopulation, String country, String city, long population) {
        if (!totalPopulation.containsKey(country)) {
            totalPopulation.put(country, population);
        } else {
            totalPopulation.put(country, totalPopulation.get(country) + population);
        }
    }
}
