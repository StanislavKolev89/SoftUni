package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            switch (tokens[1]) {
                case "company":
                    Company company = new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    if (!people.containsKey(name)) {
                        Person person = new Person(name, company);
                        people.put(name, person);
                    } else {
                        people.get(name).setCompany(company);
                    }
                    break;
                case "car":
                    Car car = new Car(tokens[2], Integer.parseInt(tokens[3]));
                    if (!people.containsKey(name)) {
                        Person person = new Person(name, car);
                        people.put(name, person);
                    } else {
                        people.get(name).setCar(car);
                    }
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(tokens[2], tokens[3]);
                    if (!people.containsKey(name)) {
                        Person person = new Person(name);
                        person.getPokemon().add(pokemon);
                        people.put(name, person);
                    } else {
                        people.get(name).getPokemon().add(pokemon);
                    }
                    break;
                case "parents":
                    Parents parents = new Parents(tokens[2], tokens[3]);
                    if (!people.containsKey(name)) {
                        Person person = new Person(name);
                        person.getParents().add(parents);
                        people.put(name, person);
                    } else {
                        people.get(name).getParents().add(parents);
                    }
                    break;
                case "children":
                    Children children = new Children(tokens[2], tokens[3]);
                    if (!people.containsKey(name)) {
                        Person person = new Person(name);
                        person.getChildren().add(children);
                        people.put(name, person);
                    } else {
                        people.get(name).getChildren().add(children);
                    }
                    break;
            }

            input = scanner.nextLine();

        }
        System.out.println();

        String nameOfPerson = scanner.nextLine();
        System.out.println(people.get(nameOfPerson));


    }
}
