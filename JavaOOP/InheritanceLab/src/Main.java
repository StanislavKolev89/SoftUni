import animals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Animal> animalList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("Beast!")) {
            String typeOfObject = input;
            String[] data = scanner.nextLine().split("\\s+");

            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String gender = data[2];

            try {
                Animal animal = createAnimal(typeOfObject, name, age, gender);
                animalList.add(animal);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }

        for (Animal animal : animalList) {
            System.out.println(animal);
            animal.produceSound();
        }


    }

    public static Animal createAnimal(String typeOfObject, String name, int age, String gender) {
        Animal animal = null;

        switch (typeOfObject) {
            case "Kitten":
                animal = new Kitten(name, age);
                break;
            case "Tomcat":
                animal = new Tomcat(name, age);
                break;
            case "Cat":
                animal = new Cat(name, age, gender);
                break;
            case "Dog":
                animal = new Dog(name, age, gender);
                break;
            case "Frog":
                animal = new Frog(name, age, gender);
                break;
        }

        return animal;

    }

}

